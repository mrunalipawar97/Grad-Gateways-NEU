package com.gradgateways.neu.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gradgateways.neu.dao.EmployerDAOImpl;
import com.gradgateways.neu.dao.JobApplicationDAOImpl;
import com.gradgateways.neu.dao.StudentDAOImpl;
import com.gradgateways.neu.model.JobApplication;
import com.gradgateways.neu.model.Student;
import com.gradgateways.neu.validator.StudentLoginValidator;
import com.gradgateways.neu.validator.StudentValidator;

/**
*
* @author mrunalipawar
* class : StudentController
*/

@Controller
@RequestMapping("/students")
public class StudentController {
	
	@Autowired
	JobApplicationDAOImpl jobApplicationDAOImpl;

	@Autowired
	StudentValidator studentValidator;
	
	@Autowired 
	StudentDAOImpl studentDAOImpl;

	@Autowired
	StudentLoginValidator studentLoginValidator;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
	    binder.setDisallowedFields("resume");
	}

	@GetMapping("/registerstudent.htm")
	public String registerStudent(Model model, Student student) {
		model.addAttribute("student", student);
		return "add-student";
	}

	@GetMapping("/login.htm")
	public String studentLogin(Model model, Student student) {
		model.addAttribute("student", student);
		return "student-login";
	}

	@PostMapping("/login.htm")
	public String registeredStudentLogin(@ModelAttribute("student") Student student, BindingResult result,
			SessionStatus status, HttpServletRequest request, HttpSession session, EmployerDAOImpl employerDAOImpl)
			throws Exception {

		studentLoginValidator.validate(student, result);

		if (result.hasErrors())
			return "student-login";

		Student stud = null;
		try {
			StudentDAOImpl studentDAOImpl = new StudentDAOImpl();
			stud = studentDAOImpl.findStudentByEmail(student.getEmail());
		} catch (Exception e) {
			System.out.println("Exception fetching the user: " + e.getMessage());
		}

		if (stud == null) {
			request.setAttribute("error", "Invalid credentials");
			return "student-login";
		} else if (!student.getPassword().equals(stud.getPassword())) {
			request.setAttribute("error", "Invalid credentials");
			return "student-login";
		}

		request.setAttribute("employerList", employerDAOImpl.findAllEmployers());

		if (session.getAttribute("employer") == null)
			session.setAttribute("student", stud);
		else
			return "student-dashboard";

		return "student-dashboard";
	}

	@PostMapping("/registerstudent.htm")
	public String registerNewStudent(@ModelAttribute("student") Student student,
	                                 BindingResult result,
	                                 @RequestParam("resume") MultipartFile resumeFile,
	                                 SessionStatus status,
	                                 HttpServletRequest request) {

	    //validating the student data
	    studentValidator.validate(student, result);

	    // Print any binding or validation errors
	    if (result.hasErrors()) {
	        System.out.println("Binding errors: " + result);
	        return "add-student"; 
	    }

	    // Process the resume file if no binding errors
	    if (!resumeFile.isEmpty()) {
	        if ("application/pdf".equals(resumeFile.getContentType())) {
	            try {
	                student.setResume(resumeFile.getBytes());
	            } catch (IOException e) {
	                result.rejectValue("resume", "error.student", "There was an error uploading the resume.");
	                return "add-student";
	            }
	        } else {
	            result.rejectValue("resume", "error.student", "File must be a PDF.");
	            return "add-student";
	        }
	    } else {
	        result.rejectValue("resume", "error.student", "Please upload a resume.");
	        return "add-student";
	    }

	    try {
	        // Save the student
	        StudentDAOImpl studentDao = new StudentDAOImpl();
	        studentDao.saveStudent(student);
	    } catch (Exception e) {
	        System.out.println("Exception when saving the student: " + e.getMessage());
	        return "add-student";
	    }

	    status.setComplete();
	    return "student-added"; 
	}
	
	@GetMapping("/logout.htm")
    public String logoutStudentAccount(HttpSession session) {
        session.invalidate();
        return "homepage";
    }
	
	@GetMapping("/viewstudentjobapplications.htm")
	public String viewMyApplications(HttpServletResponse response, HttpSession session, ModelMap model) {
	    
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
	    response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
	    response.setHeader("Expires", "0"); // Proxies.
	    
	    System.out.println("viewMyApplications student : "+ session.getAttribute("student"));
		Student student = (Student) session.getAttribute("student");
	    if (student == null) {
	    	System.out.println("student : "+ student);
	        return "student-login";
	    }

	    try {
	        List<JobApplication> jobApplication = jobApplicationDAOImpl.findJobApplicationByStudentName(student.getName());
	        System.out.println("job applications by student : "+ jobApplication);
	        model.addAttribute("jobApplication", jobApplication);
	    } catch (Exception e) {
	        e.printStackTrace();
	        return "redirect:/error"; 
	    }
	    
	    return "view-student-job-applications";
	}

	
	@GetMapping("/dashboard.htm")
	public String showStudentDashboard(HttpSession session, ModelMap model, HttpServletResponse response) {
	    // Set headers to prevent caching
	    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
	    response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
	    response.setHeader("Expires", "0"); // Proxies.

	    // Check if the student is logged in
	    Student student = (Student) session.getAttribute("student");
	    if (student == null) {
	      
	        return "student-login";
	    }
	    return "student-dashboard"; 
	}

}
