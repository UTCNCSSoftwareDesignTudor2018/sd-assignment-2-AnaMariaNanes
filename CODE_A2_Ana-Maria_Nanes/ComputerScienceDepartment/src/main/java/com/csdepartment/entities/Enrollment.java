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
@Table(name = "enrollments")
public class Enrollment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int enrollmentid;

	@Column(name = "examGrade", nullable = false)
	private float examGrade;

	@Column(name = "startDate", nullable = false)
	private String startDate;

	@Column(name = "endDate", nullable = false)
	private String endDate;

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

	public Enrollment() {
	}

	public Enrollment(float examGrade, String startDate, String endDate, Course course, Student student) {
		super();
		this.examGrade = examGrade;
		this.startDate = startDate;
		this.endDate = endDate;
		this.course = course;
		this.student = student;
		this.grades = new ArrayList<Grade>();
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

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
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

	public String checkPeriod(String start, String end) {
		String not_considered = "NO";
		String still_enrolled = "ENROLLED";
		String finished = "FINISHED";

		String[] start_dates1 = this.startDate.split("-");
		String[] start_dates2 = start.split("-");
		String[] end_dates1 = this.endDate.split("-");
		String[] end_dates2 = end.split("-");

		int start_course = Integer.valueOf(start_dates1[0] + start_dates1[1] + start_dates1[2]);
		int end_course = Integer.valueOf(end_dates1[0] + end_dates1[1] + end_dates1[2]);
		int start_period = Integer.valueOf(start_dates2[0] + start_dates2[1] + start_dates2[2]);
		int end_period = Integer.valueOf(end_dates2[0] + end_dates2[1] + end_dates2[2]);

		if (start_period <= start_course && end_period <= start_course)
			return not_considered;

		if (start_period <= start_course && end_period < end_course)
			return still_enrolled;

		if (start_period <= start_course && end_period >= end_course)
			return finished;

		if (start_period >= start_course && start_period < end_course && end_period < end_course)
			return still_enrolled;

		if (start_period >= end_course && end_period > end_course)
			return finished;

		return null;
	}
}
