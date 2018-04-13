package com.csdepartment.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.csdepartment.entities.Teacher;


public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
	
	public List<Teacher> findAll();
	public Teacher findByTeacherid(int id);
	public Teacher findByName(String name);
	public void deleteAll();
	public Teacher save(Teacher student);
}
