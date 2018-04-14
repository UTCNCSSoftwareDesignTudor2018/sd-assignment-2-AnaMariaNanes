package com.csdepartment.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "courses")
public class Course {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int courseid;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "credits", nullable = false)
	private int credits;
	
	@Column(name = "room", nullable = false)
	private String room;
	
	@ManyToOne
	@OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "teacherid")
	private Teacher teacher;
	
	@OneToMany(mappedBy = "course", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
	private List<Enrollment> enrollments;
	
	public Course() {}

	public Course(String name, int credits, String room, Teacher teacher) {
		super();
		this.name = name;
		this.credits = credits;
		this.room = room;
		this.teacher = teacher;
		this.enrollments = new ArrayList<Enrollment>();
	}

	public int getCourseid() {
		return courseid;
	}

	public void setCourseid(int courseid) {
		this.courseid = courseid;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}


	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	public List<Enrollment> getEnrollments() {
		return enrollments;
	}

	public void setEnrollments(List<Enrollment> enrollments) {
		this.enrollments = enrollments;
	}
	
	

}
