package com.gradgateways.neu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import com.gradgateways.neu.dao.JobApplicationDAOImpl;
import com.gradgateways.neu.dao.JobPostingDAOImpl;
import com.gradgateways.neu.dao.StudentDAOImpl;
import com.gradgateways.neu.model.Employer;
import com.gradgateways.neu.model.JobApplication;
import com.gradgateways.neu.model.JobPosting;
import com.gradgateways.neu.model.Student;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
*
* @author mrunalipawar
* class : JobApplicationsController
*/

@Controller
public class JobApplicationsController {

	List<JobPosting> jobPostings = new ArrayList<>();

	@Autowired
	private StudentDAOImpl studentDAOImpl;

	@Autowired
	private JobApplicationDAOImpl jobApplicationDAOImpl;
	
	@Autowired
	private JobPostingDAOImpl jobPostingDAOImpl;

	@GetMapping("/students/viewjobs.htm")
	public String viewAvailableJobs(HttpServletRequest request, ModelMap model, HttpSession session) throws Exception {
	    Student student = (Student) session.getAttribute("student");
	    if (student == null) {
	        return "redirect:/students/login.htm"; // Redirect to the login page
	    }

	    List<JobPosting> allJobPostings = jobPostingDAOImpl.findAllJobPosting();
	    List<JobApplication> studentApplications = jobApplicationDAOImpl.findJobApplicationByStudentName(student.getName());
	    
	    //Converting to a set for faster lookups
	    Set<Long> appliedJobIds = studentApplications.stream()
	            .map(JobApplication::getJob) // Assuming getJob() gives me the JobPosting
	            .map(JobPosting::getId)
	            .collect(Collectors.toSet());

	    model.addAttribute("jobPostings", allJobPostings);
	    model.addAttribute("appliedJobIds", appliedJobIds); // Adding applied job IDs to the model

	    return "apply-to-job";
	}

	@PostMapping("/students/jobapply.htm")
	public String applyToAvailableJob(@RequestParam("jobId") Long jobId,
	                                  HttpSession session, 
	                                  SessionStatus status) throws Exception {

	    Student student = (Student) session.getAttribute("student");

	    if (student == null) {
	        System.out.println("Student is not logged in.");
	        return "redirect:/students/login.htm"; 
	    }

	    JobPosting jobPosting = jobPostingDAOImpl.findJobPostingById(jobId); // Find the specific job posting

	    if (jobPosting == null) {
	        System.out.println("Job posting not found for ID: " + jobId);
	        return "redirect:/error"; // Redirect to an error page
	    }

	    // Check if the student has already applied for this job to prevent duplicate applications
	    boolean hasApplied = jobApplicationDAOImpl.hasStudentAppliedToJob(student.getName(), jobId);
	    if (hasApplied) {
	        System.out.println("Student has already applied for the job.");
	        return "redirect:/error"; // Redirect or show an error message
	    } else {
	        JobApplication jobApplication = new JobApplication();
	        jobApplication.setJob(jobPosting);
	        jobApplication.setStudentName(student.getName()); // Consider setting the student entity if you adjust your model to hold a reference
	        jobApplication.setEmployerName(jobPosting.getEmployerName());
	        jobApplication.setStatus("Pending");
	        jobApplication.setApplyDate(new Date());
	        jobApplicationDAOImpl.saveJobApplication(jobApplication);
	        return "job-apply-success"; // Redirect to a success page
	    }
	}
	
	@GetMapping("/employer/viewApplications.htm")
	public String viewJobApplications(HttpServletResponse response, HttpSession session, ModelMap model) throws Exception {
	    
	    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	    response.setHeader("Pragma", "no-cache");
	    response.setHeader("Expires", "0");

	    Employer employer = (Employer) session.getAttribute("employer");
	    if (employer == null) {
	        return "redirect:/employer/login.htm";
	    }
	    System.out.println("view applications : "+ employer.getEmployerName() );
	    List<JobApplication> jobApplication = jobApplicationDAOImpl.findJobApplicationByEmployerName(employer.getEmployerName());
	    System.out.println("view applications : jobApplication : "+  jobApplication);
	    if (jobApplication.isEmpty()) {
	        model.addAttribute("empty", true);
	    } else {
	        model.addAttribute("jobApplication", jobApplication);
	    }

	    return "view-employer-job-application";
	}

	@GetMapping("/employer/viewStudentProfile.htm")
	public String viewStudentProfile(@RequestParam("studentName") String studentName, ModelMap model,
			HttpSession session) {
		Employer employer = (Employer) session.getAttribute("employer");
		System.out.println("viewStudentProfile : "+ employer);
		if (employer == null) {
		    System.out.println("Employer is not logged in.");
		    return "employer-login";
		} else {
		    System.out.println("Employer logged in: " + employer.getEmployerName());
		}

		try {
			Student student = studentDAOImpl.findStudentByName(studentName);
			System.out.println("view student profile :");

			if (student == null) {
				model.addAttribute("errorMessage", "No student found with name : " + studentName);
				return "error";
			}

			model.addAttribute("student", student);
			return "view-student-profile";

		} catch (Exception e) {
			model.addAttribute("errorMessage", "Error viewing student profile: " + e.getMessage());
			return "error";
		}
	}
	
	@PostMapping("/employer/updateApplicationStatus.htm")
	public String updateApplicationStatus(@RequestParam("applicationId") Long applicationId,
	                                      @RequestParam("status") String status,
	                                      HttpSession session, HttpServletResponse response) {
		
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate max-age=0"); // HTTP 1.1.
	    response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
	    response.setHeader("Expires", "0"); // Proxies.
	    
	    Employer employer = (Employer) session.getAttribute("employer");
	    if (employer == null) {
	        return "redirect:/employer/login.htm";
	    }

	    try {
	        JobApplication jobApplication = jobApplicationDAOImpl.findJobApplicationById(applicationId);
	        if (jobApplication != null) {
	            jobApplication.setStatus(status);
	            System.out.println("status : "+ status);
	            jobApplicationDAOImpl.updateJobApplication(jobApplication); 
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        return "redirect:/error"; 
	    }
	    return "redirect:/employer/viewApplications.htm"; // Redirecting to avoid form re-submission issues
	}
	
}
