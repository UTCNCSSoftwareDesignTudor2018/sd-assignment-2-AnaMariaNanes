package com.csdepartment.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "students")
public class Student {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int studentid;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "card", nullable = false, length = 5)
	private String card;
	
	@Column(name = "cnp", nullable = false, length = 10)
	private String cnp;
	
	@Column(name = "address", nullable = false)
	private String address;
	
	@Column(name = "groupid", nullable = false, length = 5)
	private String groupid;
	
	@Column(name = "username", nullable = false)
	private String username;
	
	@OneToMany(mappedBy = "student", fetch = FetchType.EAGER)
	private List<Enrollment> enrollments;
	
	public Student() {}
	



	public Student(String name, String card, String cnp, String address, String groupid, String username) {
		super();
		this.name = name;
		this.card = card;
		this.cnp = cnp;
		this.address = address;
		this.groupid = groupid;
		this.username = username;
		this.enrollments = new ArrayList<Enrollment>();
	}




	public int getStudentid() {
		return studentid;
	}

	public void setStudentid(int studentid) {
		this.studentid = studentid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCard() {
		return card;
	}

	public void setCard(String card) {
		this.card = card;
	}

	public String getCnp() {
		return cnp;
	}

	public void setCnp(String cnp) {
		this.cnp = cnp;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGroupid() {
		return groupid;
	}

	public void setGroupid(String groupid) {
		this.groupid = groupid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Enrollment> getEnrollments() {
		return enrollments;
	}

	public void setEnrollments(List<Enrollment> enrollments) {
		this.enrollments = enrollments;
	}

}
