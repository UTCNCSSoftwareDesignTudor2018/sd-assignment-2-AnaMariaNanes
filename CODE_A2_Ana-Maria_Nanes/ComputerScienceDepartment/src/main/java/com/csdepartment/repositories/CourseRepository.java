package com.csdepartment.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.csdepartment.entities.Course;
import com.csdepartment.entities.Teacher;

public interface CourseRepository extends JpaRepository<Course, Integer> {

	public List<Course> findAll();

	public Course findByCourseid(int id);

	public Course findByName(String name);

	public Course findByTeacher(Teacher teacher);

	public Course save(Course course);

	public void delete(Course course);

	public void deleteByCourseid(int id);
}
