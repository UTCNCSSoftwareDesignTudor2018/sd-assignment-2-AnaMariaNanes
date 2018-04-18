package com.csdepartment.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.csdepartment.entities.Student;

public interface StudentRepository extends CrudRepository<Student, Integer> {

	public List<Student> findAll();

	public Student findByStudentid(int id);

	public Student findByName(String name);

	public Student findByUsername(String username);

	public Student save(Student student);

	public void delete(Student student);

	public void deleteByStudentid(int id);

}
