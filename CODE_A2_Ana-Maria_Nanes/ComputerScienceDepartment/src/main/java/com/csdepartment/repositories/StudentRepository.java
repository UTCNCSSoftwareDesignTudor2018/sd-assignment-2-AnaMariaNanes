package com.csdepartment.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.csdepartment.entities.Student;


public interface StudentRepository extends JpaRepository<Student, Integer> {
	
	public List<Student> findAll();
	public Student findByStudentid(int id);
	public Student findByName(String name);
	public void deleteAll();
	public Student save(Student student);
}
