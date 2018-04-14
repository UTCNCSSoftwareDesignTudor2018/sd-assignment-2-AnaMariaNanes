package com.csdepartment.validators;

import java.util.List;

import javax.inject.Inject;

import com.csdepartment.entities.Teacher;
import com.csdepartment.services.TeacherService;

public class TeacherValidator {
	
    @Inject
	TeacherService teacherService;

	public TeacherValidator() {
	}
	
	public String validateTeacher(Teacher tc)
	{
		String message  = "correct";
		
		if(tc.getName() == null || tc.getName().equals("") || (! isNameUnique(tc.getName())))
			return message = "Wrong name field format";
		if(tc.getUsername() == null || tc.getUsername().equals("") || (! isUsernameUnique(tc.getUsername())))
			return message = "Wrong username field format";
		if(tc.getPassword() == null || tc.getPassword().equals("") || tc.getPassword().length() !=5)
			return message = "Wrong password field format";
		
		
		return message;
	}
	
	public String validateUpdateTeacher(Teacher tc)
	{
		String message  = "correct";
		
		if(tc.getName() == null || tc.getName().equals(""))
			return message = "Wrong name field format";
		if(tc.getUsername() == null || tc.getUsername().equals("") )
			return message = "Wrong username field format";
		if(tc.getPassword() == null || tc.getPassword().equals("") || tc.getPassword().length() !=5)
			return message = "Wrong password field format";
		return message;
	}
	
	private boolean isNameUnique(String name)
	{
		List<Teacher> allTeachers = teacherService.getAllTeachers();
		
		for(Teacher tc : allTeachers)
		{
			if(tc.getName().equals(name))
			  return false;
		}
		return true;
	}
	
	private boolean isUsernameUnique(String username )
	{
		List<Teacher> allTeachers = teacherService.getAllTeachers();
		for(Teacher tc : allTeachers)
		{
			if(tc.getUsername().equals(username))
			  return false;
		}
		return true;
	}
	
}
