package com.gradgateways.neu.controller;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.gradgateways.neu.dao.FeedbackDAOimpl;
import com.gradgateways.neu.model.Employer;
import com.gradgateways.neu.model.Feedback;

/**
*
* @author mrunalipawar
* class : FeedbackController
*/

@Controller
@RequestMapping("/feedback")
public class FeedbackController {

	@Autowired
	FeedbackDAOimpl feedbackDAOimpl;

	
	@GetMapping("/form.htm")
	public String showFeedbackForm(@RequestParam(value = "studentName", required = false) String studentName, Model model, HttpSession session) {
	    Feedback feedback = new Feedback();
	    Employer loggedEmployer = (Employer) session.getAttribute("employer");
		System.out.println("inside get method submit form : " + loggedEmployer.getEmployerEmail());
		feedback.setEmployerEmail(loggedEmployer.getEmployerEmail());
	    feedback.setEmployerName(loggedEmployer.getEmployerName());
	    if (studentName != null && !studentName.isEmpty()) {
	        feedback.setStudentName(studentName);
	    }
	    model.addAttribute("feedback", feedback);
	    return "give-feedback";
	}
	
	@PostMapping("/form.htm")
	public String processFeedback(@ModelAttribute("feedback") Feedback feedback, BindingResult result,
			RedirectAttributes redirectAttributes, HttpSession session) {
		System.out.println("Processing feedback...");

		if (result.hasErrors()) {
			System.out.println("Form has errors: " + result.getAllErrors());
			return "give-feedback";
		}

		try {
			Employer loggedEmployer = (Employer) session.getAttribute("employer");
			if (loggedEmployer != null) {
				feedback.setEmployer(loggedEmployer);
				feedback.setEmployerEmail(loggedEmployer.getEmployerEmail());
				feedback.setEmployerName(loggedEmployer.getEmployerName());
			} else {
				System.out.println("Employer not logged in.");
				return "employer-login";
			}

			System.out.println("Saving feedback: " + feedback);
			feedbackDAOimpl.saveFeedback(feedback);
			System.out.println("Feedback saved successfully.");
			redirectAttributes.addFlashAttribute("successMessage", "Feedback successfully submitted!");
		} catch (Exception e) {
			System.out.println("Error saving feedback: " + e.getMessage());
			redirectAttributes.addFlashAttribute("errorMessage", "Error submitting feedback.");
		}
		return "give-feedback";
	}
}
