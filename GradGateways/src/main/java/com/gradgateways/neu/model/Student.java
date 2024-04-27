package com.gradgateways.neu.model;

import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

/**
*
* @author mrunalipawar
* class : Student
*/

@Component
@Entity
@Table(name = "Student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	
	private String name;

	
	private String email;

	
	private String password;

	
	private String major;

	
	private String skill;

	@Lob
	private byte[] resume;

	public Student() {

	}


	public Student(long id, String name, String email, String password, String major, String skill, byte[] resume) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.major = major;
		this.skill = skill;
		this.resume = resume;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	public byte[] getResume() {
		return resume;
	}

	public void setResume(byte[] resume) {
		this.resume = resume;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", major="
				+ major + ", skill=" + skill + ", resume=" + Arrays.toString(resume) + "]";
	}

}
