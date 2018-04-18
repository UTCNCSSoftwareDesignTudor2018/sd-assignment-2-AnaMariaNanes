package com.csdepartment.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.csdepartment.entities.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {

	public List<Teacher> findAll();

	public Teacher findByTeacherid(int id);

	public Teacher findByName(String name);

	public Teacher findByUsername(String username);

	public void delete(Teacher teacher);

	public void deleteByTeacherid(int id);

	public Teacher save(Teacher student);
}
