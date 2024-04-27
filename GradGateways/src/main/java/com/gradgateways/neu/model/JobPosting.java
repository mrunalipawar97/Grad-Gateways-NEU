package com.gradgateways.neu.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.stereotype.Component;

/**
*
* @author mrunalipawar
* class : JobPosting
*/

@Component
@Entity
@Table(name = "JobPosting")
public class JobPosting {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "jobtitle", nullable = false)
    private String jobtitle;

    @Column(name = "description", length = 2000)
    private String description;

    @Column(name = "location")
    private String location;

    @Column(name = "posted_date")
    @Temporal(TemporalType.DATE)
    private Date postedDate;

    @Column(name = "employerName")
    private String employerName;
    
    public JobPosting() {
    	
    }

	public JobPosting(Long id, String jobtitle, String description, String location, Date postedDate,
			String employerName) {
		super();
		this.id = id;
		this.jobtitle = jobtitle;
		this.description = description;
		this.location = location;
		this.postedDate = postedDate;
		this.employerName = employerName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getJobtitle() {
		return jobtitle;
	}

	public void setJobtitle(String jobtitle) {
		this.jobtitle = jobtitle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getPostedDate() {
		return postedDate;
	}

	public void setPostedDate(Date postedDate) {
		this.postedDate = postedDate;
	}

	public String getEmployerName() {
		return employerName;
	}

	public void setEmployerName(String employerName) {
		this.employerName = employerName;
	}

	@Override
	public String toString() {
		return "JobPosting [id=" + id + ", jobtitle=" + jobtitle + ", description=" + description + ", location="
				+ location + ", postedDate=" + postedDate + ", employerName=" + employerName + "]";
	}
    
}
