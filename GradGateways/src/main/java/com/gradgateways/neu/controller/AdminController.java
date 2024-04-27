package com.gradgateways.neu.controller;

import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.gradgateways.neu.dao.EmployerDAOImpl;
import com.gradgateways.neu.dao.FeedbackDAOimpl;
import com.gradgateways.neu.dao.StudentDAOImpl;
import com.gradgateways.neu.model.Feedback;
import com.gradgateways.neu.model.Student;

/**
*
* @author mrunalipawar
* class : AdminController
*/

@Controller
@RequestMapping(value = "/admin")
public class AdminController {

	@Autowired
    private StudentDAOImpl studentDAOImpl;

    @Autowired
    private EmployerDAOImpl employerDAOImpl;

    @Autowired
    private FeedbackDAOimpl feedbackDAOimpl;

    @GetMapping("/login.htm")
    public String showAdminLoginPage() {
        return "admin-login"; 
    }

    @PostMapping("/login.htm")
    public String validateAdminLogin(@RequestParam("username") String username,
                                     @RequestParam("password") String password,
                                     HttpSession session,
                                     RedirectAttributes redirectAttrs) {
        final String adminUsername = "admin";
        final String adminPassword = "pass";
        
        if (adminUsername.equals(username) && adminPassword.equals(password)) {
            session.setAttribute("isAdmin", true);
            return "redirect:/admin/dashboard.htm"; 
        } else {
            redirectAttrs.addFlashAttribute("errorMessage", "Invalid username or password.");
            return "redirect:/admin/login.htm";
        }
    }

    @GetMapping("/dashboard.htm")
    public String adminDashboard(HttpSession session, Model model) {
        if (session.getAttribute("isAdmin") == null) {
            return "redirect:/admin/login.htm";
        }
        model.addAttribute("students", studentDAOImpl.findAll());
        model.addAttribute("employers", employerDAOImpl.findAllEmployers());
        return "admin-dashboard";
    }

    @GetMapping("/viewfeedbacks.htm")
    public String showFeedbacks(Model model, HttpSession session) {
        if (session.getAttribute("isAdmin") == null) {
            return "redirect:/admin/login.htm";
        }
        List<Feedback> feedbackList = feedbackDAOimpl.findAllFeedbacks(); 
        model.addAttribute("feedbacks", feedbackList);
        return "view-feedbacks"; 
    }
    

	@PostMapping("/deletestudent.htm")
	public String deleteStudent(@RequestParam("studentName") String studentName, RedirectAttributes redirectAttrs) {
	    try {
	    	 System.out.println("deleting student record : "+studentName );
	         Student student = studentDAOImpl.findStudentByName(studentName);
	        if (student != null) {
	            studentDAOImpl.deleteStudent(student);
	            System.out.println("deleting student record : "+ student.getName());
	            redirectAttrs.addFlashAttribute("successMessage", "Student deleted successfully.");
	        } else {
	            redirectAttrs.addFlashAttribute("errorMessage", "Student not found.");
	        }
	    } catch (Exception e) {
	        redirectAttrs.addFlashAttribute("errorMessage", "Failed to delete student: " + e.getMessage());
	    }
	    return "redirect:/admin/dashboard.htm";
	}
    
    @GetMapping("/logout.htm")
    public String logoutAdminAccount(HttpSession session) {
        session.invalidate();
        return "homepage";
    }
}
