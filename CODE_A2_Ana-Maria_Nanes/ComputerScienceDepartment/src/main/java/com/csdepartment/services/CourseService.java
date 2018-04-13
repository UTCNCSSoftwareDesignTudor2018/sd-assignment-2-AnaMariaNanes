package com.csdepartment.services;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.csdepartment.entities.Course;
import com.csdepartment.repositories.CourseRepository;

@Service()
public class CourseService {
	
	@Inject
	CourseRepository courseRepository;
	
	public List<Course> getAllCourses()
	{
		return courseRepository.findAll();
	}
	

}
