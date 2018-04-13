package com.csdepartment.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "grades")
public class Grade {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int gradeid;
	
	@Column(name = "grade", nullable = false)
	private float grade;
	
	@ManyToOne
    @JoinColumn(name = "enrollmentid")
	private Enrollment enrollment;
	
	public Grade() { }

	
	public Grade(Enrollment enrollment, float grade) {
		super();
		this.enrollment = enrollment;
		this.grade = grade;
	}


	public int getGradeid() {
		return gradeid;
	}

	public void setGradeid(int gradeid) {
		this.gradeid = gradeid;
	}

	public Enrollment getEnrollment() {
		return enrollment;
	}

	public void setEnrollment(Enrollment enrollment) {
		this.enrollment = enrollment;
	}

	public float getGrade() {
		return grade;
	}

	public void setGrade(float grade) {
		this.grade = grade;
	}

}
