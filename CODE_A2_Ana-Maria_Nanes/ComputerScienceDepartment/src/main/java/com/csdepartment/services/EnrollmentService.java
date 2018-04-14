package com.csdepartment.services;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.csdepartment.entities.Course;
import com.csdepartment.entities.Enrollment;
import com.csdepartment.entities.Student;
import com.csdepartment.repositories.EnrollmentRepository;

@Service()
public class EnrollmentService {

	@Inject
	EnrollmentRepository enrollmentRepository;
	
	public List<Enrollment> getAllEnrollments()
	{
		return enrollmentRepository.findAll();
	}
	
	public Enrollment getByEnrollmentid(int id)
	{
		return enrollmentRepository.findByEnrollmentid(id);
	}
	
	public List<Enrollment> getByCourse(Course course)
	{
		return enrollmentRepository.findByCourse(course);
	}
	
	public List<Enrollment> getByStudent(Student student)
	{
		return enrollmentRepository.findByStudent(student);
	}
	
	public Enrollment insert(Enrollment enrollment)
	{
		return enrollmentRepository.save(enrollment);
	}
	
	public void delete(Enrollment enrollment)
	{
		enrollmentRepository.delete(enrollment);
	}
	
	public void deleteByEnrollmentid(int id)
	{
		enrollmentRepository.deleteByEnrollmentid(id);
	}
	
	public void update(Enrollment enrollment)
	{
		Enrollment foundEnrollment =  enrollmentRepository.findByEnrollmentid(enrollment.getEnrollmentid());
		foundEnrollment = enrollment;
		enrollmentRepository.save(foundEnrollment);
	}
}
