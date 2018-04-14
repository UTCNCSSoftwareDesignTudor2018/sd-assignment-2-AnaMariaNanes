package com.csdepartment.services;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.csdepartment.entities.Course;
import com.csdepartment.entities.Teacher;
import com.csdepartment.repositories.CourseRepository;

@Service()
public class CourseService {
	
	@Inject
	CourseRepository courseRepository;
	
	public List<Course> getAllCourses()
	{
		return courseRepository.findAll();
	}
	
	public Course getByCourseid(int id)
	{
		return courseRepository.findByCourseid(id);
	}
	
	public Course getByName(String name)
	{
		return courseRepository.findByName(name);
	}
	
	public Course getByTeacher(Teacher teacher)
	{
		return courseRepository.findByTeacher(teacher);
	}
	
	public Course insert(Course course)
	{
		return courseRepository.save(course);
	}
	
	public void delete(Course course)
	{
		courseRepository.delete(course);
	}
	
	public void deleteByCourseId(int id)
	{
		courseRepository.deleteByCourseid(id);
		
	}
	
	public void update(Course course)
	{
		Course foundCourse = courseRepository.findByCourseid(course.getCourseid());
		foundCourse = course;
		courseRepository.save(foundCourse);
	}
	
}
