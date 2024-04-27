package com.gradgateways.neu.model;

import org.springframework.stereotype.Component;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
*
* @author mrunalipawar
* class : JobApplication
*/

@Component
@Entity
@Table(name = "JobApplication")
public class JobApplication {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long applicationId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "job_id", nullable = false)
	private JobPosting job;
	
	private String jobtitle;

	private String studentName;

	private String employerName;

	@Column(nullable = false, length = 255)
	private String status;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "apply_date", nullable = false)
	private Date applyDate;

	
	
	public JobApplication() {
		
	}

	public JobApplication(Long applicationId, JobPosting job, String jobtitle, String studentName, String employerName, String status,
			Date applyDate) {
		super();
		this.applicationId = applicationId;
		this.job = job;
		this.studentName = studentName;
		this.employerName = employerName;
		this.status = status;
		this.jobtitle = jobtitle;
		this.applyDate = applyDate;
	}

	public Long getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(Long applicationId) {
		this.applicationId = applicationId;
	}

	public JobPosting getJob() {
		return job;
	}

	public void setJob(JobPosting job) {
		this.job = job;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getApplyDate() {
		return applyDate;
	}

	public void setApplyDate(Date applyDate) {
		this.applyDate = applyDate;
	}

	
	public String getJobTitle() {
		return jobtitle;
	}

	public void setJobTitle(String jobtitle) {
		this.jobtitle = jobtitle;
	}

	@Override
	public String toString() {
		return "JobApplication [applicationId=" + applicationId + ", job=" + job + ", studentName=" + studentName
				+ ", employerName=" + employerName + ", status=" + status + ", applyDate=" + applyDate + "]";
	}

	

}