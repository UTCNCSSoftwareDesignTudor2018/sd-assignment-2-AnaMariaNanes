package com.csdepartment.entities;

import java.util.ArrayList;
import java.util.Date;
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
@Table(name = "enrollments")
public class Enrollment {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int enrollmentid;
	
	@Column(name = "examGrade", nullable = false)
	private float examGrade;
	
	@Column(name = "startDate", nullable = false)
	private Date startDate;
	
	@Column(name = "endDate", nullable = false)
	private Date endDate;
	
	@ManyToOne
	@OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "courseid")
	private Course course;
	
	@ManyToOne
	@OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "studentid")
	private Student student;
	
	@OneToMany(mappedBy = "enrollment", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
	private List<Grade> grades;
	
	public Enrollment() {}

	public Enrollment(float examGrade, Date startDate, Date endDate, Course course, Student student) {
		super();
		this.examGrade = examGrade;
		this.startDate = startDate;
		this.endDate = endDate;
		this.course = course;
		this.student = student;
		this.grades =  new ArrayList<Grade>();
	}

	public int getEnrollmentid() {
		return enrollmentid;
	}

	public void setEnrollmentid(int enrollmentid) {
		this.enrollmentid = enrollmentid;
	}

	public float getExamGrade() {
		return examGrade;
	}

	public void setExamGrade(float examGrade) {
		this.examGrade = examGrade;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public List<Grade> getGrades() {
		return grades;
	}

	public void setGrades(List<Grade> grades) {
		this.grades = grades;
	}
	
	
	
}
