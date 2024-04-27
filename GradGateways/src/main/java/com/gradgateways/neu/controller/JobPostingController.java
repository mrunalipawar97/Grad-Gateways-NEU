package com.gradgateways.neu.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;
import com.gradgateways.neu.dao.JobPostingDAOImpl;
import com.gradgateways.neu.model.Employer;
import com.gradgateways.neu.model.JobPosting;

/**
*
* @author mrunalipawar
* class : JobPostingController
*/

@Controller
@RequestMapping("/jobs")
public class JobPostingController {

	@GetMapping("/employer/addjob.htm")
	public String addJobGet(Model model, JobPosting jobPosting) {
		model.addAttribute("jobPosting", jobPosting);
		return "add-jobs";
	}

	@PostMapping("/employer/addjob.htm")
	public String addJob(@ModelAttribute("jobPosting") JobPosting jobPosting, BindingResult result,
			SessionStatus status, HttpSession session, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		response.setContentType("text/html;charset=UTF-8");

		if (result.hasErrors()) {
			System.out.println("Test error add job : " + result.getAllErrors());
			return "add-jobs";
		}

		Employer employer = (Employer) session.getAttribute("employer");
		if (employer == null) {
			return "employer-login";
		}

		jobPosting.setEmployerName(employer.getEmployerName());
		JobPostingDAOImpl jobPostingDAOImpl = new JobPostingDAOImpl();
		try {
			jobPostingDAOImpl.saveJobPosting(jobPosting);
		} catch (Exception e) {
			System.out.println("Unable to add job: " + e.getMessage());

			return "add-jobs";
		}

		return "job-added-success";
	}

	@GetMapping("/employer/viewjob.htm")
	public String viewJob(@ModelAttribute("jobPosting") JobPosting jobPosting, BindingResult result,
			SessionStatus status, HttpSession session, HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		Employer employer = (Employer) session.getAttribute("employer");
		if (employer == null) {
			System.out.println("error viewving jobs :  " + result.getAllErrors());
			return "homepage";
		}

		// Retrieving jobs posted by the logged-in employer
		JobPostingDAOImpl jobPostingDAOImpl = new JobPostingDAOImpl();
		List<JobPosting> list = jobPostingDAOImpl.findJobPostingByEmployerName(employer.getEmployerName());
		request.setAttribute("employerjobs", list);
		return "jobs-list";
	}
}
