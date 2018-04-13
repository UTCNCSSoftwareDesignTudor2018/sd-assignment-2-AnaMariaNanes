package com.csdepartment.entities;

import org.springframework.data.annotation.Id;

public class Report {
	
	 @Id
	 private String id;
	 
	 private String studentName;
	 private String teacherName;
	 private String coursesEnrolled;
	 private String coursesFinished;
	 private String startPeriod;
	 private String endPeriod;
	 
	 public Report() {}

	public Report(String studentName, String teacherName, String coursesEnrolled, String coursesFinished,
			String startPeriod, String endPeriod) {
		super();
		this.studentName = studentName;
		this.teacherName = teacherName;
		this.coursesEnrolled = coursesEnrolled;
		this.coursesFinished = coursesFinished;
		this.startPeriod = startPeriod;
		this.endPeriod = endPeriod;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getCoursesEnrolled() {
		return coursesEnrolled;
	}

	public void setCoursesEnrolled(String coursesEnrolled) {
		this.coursesEnrolled = coursesEnrolled;
	}

	public String getCoursesFinished() {
		return coursesFinished;
	}

	public void setCoursesFinished(String coursesFinished) {
		this.coursesFinished = coursesFinished;
	}

	public String getStartPeriod() {
		return startPeriod;
	}

	public void setStartPeriod(String startPeriod) {
		this.startPeriod = startPeriod;
	}

	public String getEndPeriod() {
		return endPeriod;
	}

	public void setEndPeriod(String endPeriod) {
		this.endPeriod = endPeriod;
	}

}
