package com.gradgateways.neu.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

/**
*
* @author mrunalipawar
* class : Feedback
*/

@Component
@Entity
@Table(name = "Feedback")
public class Feedback {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "employer_id", nullable = false)
	private Employer employer;
	
	@Column(name = "studentName")
	private String studentName;
	
	@Column(name = "employerName")
	private String employerName;
	
	@Column(name = "employerEmail")
	private String employerEmail;

	@Column(length = 1024)
	private String message;

	public Feedback() {

	}

	public Feedback(Long id, Employer employer, String studentName, String employerName, String employerEmail,
			String message) {
		super();
		this.id = id;
		this.employer = employer;
		this.studentName = studentName;
		this.employerName = employerName;
		this.employerEmail = employerEmail;
		this.message = message;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Employer getEmployer() {
		return employer;
	}

	public void setEmployer(Employer employer) {
		this.employer = employer;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	
	public String getEmployerName() {
		return employerName;
	}

	public void setEmployerName(String employerName) {
		this.employerName = employerName;
	}

	public String getEmployerEmail() {
		return employerEmail;
	}

	public void setEmployerEmail(String employerEmail) {
		this.employerEmail = employerEmail;
	}

	@Override
	public String toString() {
		return "Feedback [id=" + id + ", employer=" + employer + ", studentName=" + studentName + ", message=" + message
				+ "]";
	}

	

}
