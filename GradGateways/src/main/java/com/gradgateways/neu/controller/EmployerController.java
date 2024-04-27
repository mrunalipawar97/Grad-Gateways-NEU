package com.gradgateways.neu.controller;

import java.io.IOException;
import java.net.URLEncoder;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;
import com.gradgateways.neu.dao.EmployerDAOImpl;
import com.gradgateways.neu.dao.StudentDAOImpl;
import com.gradgateways.neu.model.Employer;
import com.gradgateways.neu.model.Student;
import com.gradgateways.neu.validator.EmployerLoginValidator;
import com.gradgateways.neu.validator.EmployerValidator;

/**
*
* @author mrunalipawar
* class : EmployerController
*/

@Controller
@RequestMapping("/employer")
public class EmployerController {

	@Autowired
	StudentDAOImpl studentDAOImpl;
	
	@Autowired
	private EmployerValidator employerValidator;
	
	@Autowired
	EmployerDAOImpl employerDAOImpl;
	
	@Autowired
	private EmployerLoginValidator employerLoginValidator;
	
	@GetMapping("/registeremployer.htm")
	public String addEmployerGet(Model model, Employer employer) {
		model.addAttribute("employer", employer);
		return "add-employer";
	}

	@PostMapping("/registeremployer.htm")
	public String addEmployerPost(@ModelAttribute("employer") Employer employer, BindingResult result,
			SessionStatus status) {
		Employer emp1 = null;
		employerValidator.validate(employer, result);

		if (result.hasErrors()) {
			return "add-employer";
		}

		try {
			EmployerDAOImpl employerDAOImpl = new EmployerDAOImpl();
			employerDAOImpl.saveEmployer(employer);
		} catch (Exception e) {
			System.out.println("Employer Cannot be added: " + e.getMessage());
		}
		status.setComplete();
		return "employer-added";
	}

	@GetMapping("/login.htm")
	public String employerLoginGet(Model model, Employer employer) {
		model.addAttribute("employer", employer);
		return "employer-login";
	}

	@PostMapping("/login.htm")
	public String registeredEmployerLogin(@ModelAttribute("employer") Employer employer, BindingResult result,
			SessionStatus status, HttpSession session, Model model) throws Exception {
		
		employerLoginValidator.validate(employer, result);
		
		if (result.hasErrors()) {
			System.out.println("test error : "+ result.getAllErrors());
			return "employer-login";
		}
		EmployerDAOImpl employerDAOImpl = new EmployerDAOImpl();
		System.out.println("at success login : "+ employer.getEmployerEmail());
		Employer emp = employerDAOImpl.findEmployerByEmail(employer.getEmployerEmail());
		if (emp != null && emp.getEmployerPassword().equals(employer.getEmployerPassword())) {
			session.setAttribute("employer", emp);
			System.out.println("at success login : "+ emp.getEmployerEmail());
			return "employer-dashboard";
			//return "redirect:/employer/employerdashboard.htm";
		} else {
			model.addAttribute("loginError", "Invalid username or password.");
			return "employer-login";
		}
	}

	@GetMapping("/viewprofile.htm")
	public String viewProfile(@ModelAttribute("employer") Employer employer, SessionStatus status, HttpSession session,
			ModelMap model) {
		model.addAttribute("employer", (Employer) session.getAttribute("employer"));
		return "view-employer-profile";
	}
	
	@PostMapping("/updateprofile.htm")
	public String updateProfile(@ModelAttribute("employer") Employer employer, BindingResult result, HttpSession session) {
	    if (result.hasErrors()) {
	        System.out.println("Update profile error: " + result);
	        return "view-employer-profile"; // Ensure this is the correct view name
	    }
	    try {
	    	System.out.println("Attempting to update profile for ID: " + employer.getId());
	        System.out.println("Attempting to update employer profile for: " + employer.getEmployerName());
	        employerDAOImpl.updateEmployer(employer);
	        session.setAttribute("employer", employer); // Update session with new employer details
	        System.out.println("Employer profile updated successfully: " + employer.getEmployerName());
	        session.setAttribute("updateSuccess", "Employer profile updated successfully.");
	    } catch (Exception e) {
	        
	        e.printStackTrace();
	        result.reject("updateFailed", "Unable to update profile: " + e.getMessage());
	        return "view-employer-profile"; 
	    }
	    return "redirect:/employer/dashboard.htm"; 
	}

	
	@GetMapping("/studentResumeByName/{studentName}")
	public void getStudentResumeByName(@PathVariable("studentName") String studentName, HttpServletResponse response) throws Exception {
	    try {
	    	System.out.println("view resume : ");
	        Student student = studentDAOImpl.findStudentByName(studentName);

	        if (student != null && student.getResume() != null) {
	            response.setContentType("application/pdf");
	            response.setHeader("Content-Disposition", "inline; filename=" + URLEncoder.encode(student.getName(), "UTF-8") + "_Resume.pdf");
	            response.getOutputStream().write(student.getResume());
	            response.getOutputStream().flush();
	        } else {
	            response.sendError(HttpServletResponse.SC_NOT_FOUND, "No resume found for student: " + studentName);
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	
	@GetMapping("/logout.htm")
    public String logoutEmployerAccount(HttpSession session) {
        session.invalidate();
        return "homepage";
    }
	
	@GetMapping("/dashboard.htm")
	public String showEmployerDashboard(HttpSession session, ModelMap model, HttpServletResponse response) {
	    // Set headers to prevent caching
	    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
	    response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
	    response.setHeader("Expires", "0"); // Proxies.

	    // Check if the student is logged in
	    Employer employer = (Employer) session.getAttribute("employer");
	    if (employer == null) {
	      
	        return "employer-login";
	    }
	    return "employer-dashboard"; 
	}

}
