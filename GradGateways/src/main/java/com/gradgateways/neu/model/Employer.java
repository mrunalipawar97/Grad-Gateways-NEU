package com.gradgateways.neu.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.stereotype.Component;

/**
*
* @author mrunalipawar
* class : Employer
*/

@Component
@Entity
@Table(name = "Employer")
public class Employer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String employerName;


	private String employerAddress;


	private String employerEmail;


	private String employerPassword;
	
	public Employer() {
		
	}

	public Employer(long id, String employerName, String employerAddress, String employerEmail,
			String employerPassword) {
		super();
		this.id = id;
		this.employerName = employerName;
		this.employerAddress = employerAddress;
		this.employerEmail = employerEmail;
		this.employerPassword = employerPassword;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmployerName() {
		return employerName;
	}

	public void setEmployerName(String employerName) {
		this.employerName = employerName;
	}

	public String getEmployerAddress() {
		return employerAddress;
	}

	public void setEmployerAddress(String employerAddress) {
		this.employerAddress = employerAddress;
	}

	public String getEmployerEmail() {
		return employerEmail;
	}

	public void setEmployerEmail(String employerEmail) {
		this.employerEmail = employerEmail;
	}

	public String getEmployerPassword() {
		return employerPassword;
	}

	public void setEmployerPassword(String employerPassword) {
		this.employerPassword = employerPassword;
	}

	@Override
	public String toString() {
		return "Employer [id=" + id + ", employerName=" + employerName + ", employerAddress=" + employerAddress
				+ ", employerEmail=" + employerEmail + ", employerPassword=" + employerPassword + "]";
	}

}
