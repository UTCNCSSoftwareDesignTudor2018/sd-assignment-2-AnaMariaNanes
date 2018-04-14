package com.csdepartment.mvc.model;

import com.csdepartment.entities.*;

public class TeacherModel {
	
	private Teacher teacher;

	public TeacherModel() {
		this.teacher = new Teacher();
	}
		
	public TeacherModel(Teacher teacher) {
		this.teacher = teacher;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	

}
