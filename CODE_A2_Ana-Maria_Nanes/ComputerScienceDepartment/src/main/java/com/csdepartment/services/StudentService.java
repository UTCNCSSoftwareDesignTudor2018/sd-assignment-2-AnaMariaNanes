package com.csdepartment.services;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.csdepartment.entities.Course;
import com.csdepartment.entities.Student;
import com.csdepartment.repositories.StudentRepository;

@Service()
public class StudentService {

	@Inject
	StudentRepository studentRepository;

	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	public Student getStudentById(int id) {
		return studentRepository.findByStudentid(id);
	}

	public Student getStudentByName(String name) {
		return studentRepository.findByName(name);
	}

	public Student getStudentByUsername(String username) {
		return studentRepository.findByUsername(username);
	}

	public Student insert(Student student) {
		return studentRepository.save(student);
	}

	public void delete(Student student) {
		studentRepository.delete(student);
	}

	public void deleteByStudentId(int id) {
		studentRepository.deleteByStudentid(id);
	}

	public void update(Student oneStudent) {
		Student foundStudent = studentRepository.findByStudentid(oneStudent.getStudentid());
		foundStudent = oneStudent;
		studentRepository.save(foundStudent);
	}

	public List<Course> findStudentCourses(int id) {
		List<Course> allCourses = new ArrayList<Course>();
		studentRepository.findByStudentid(id).getEnrollments().stream().forEach(e -> allCourses.add(e.getCourse()));
		return allCourses;
	}

}
