package com.csdepartment.services;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.csdepartment.entities.Teacher;
import com.csdepartment.repositories.TeacherRepository;

@Service()
public class TeacherService {
	
	@Inject
	TeacherRepository teacherRepository;
	
	public List<Teacher> getAllTeachers()
	{
		return teacherRepository.findAll();
	}
	
	public Teacher getTeacherById(int id)
	{
		return teacherRepository.findByTeacherid(id);
	}
	
	public Teacher getTeacherByName(String name)
	{
		return teacherRepository.findByName(name);
	}
	

}
