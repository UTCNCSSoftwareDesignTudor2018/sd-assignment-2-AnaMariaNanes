package com.csdepartment.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.csdepartment.entities.Course;
import com.csdepartment.entities.Teacher;



public interface CourseRepository extends JpaRepository<Course, Integer> {
	
	public List<Course> findAll();
	public Course findByName(String name);
	public Course findByTeacher(Teacher teacher);
	public void deleteAll();
	public Course save(Course course);
}
