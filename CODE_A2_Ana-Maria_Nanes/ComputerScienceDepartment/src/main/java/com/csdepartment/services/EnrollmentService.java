package com.csdepartment.services;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.csdepartment.entities.Enrollment;
import com.csdepartment.repositories.EnrollmentRepository;

@Service()
public class EnrollmentService {

	@Inject
	EnrollmentRepository enrollmentRepository;
	
	public List<Enrollment> getAllEnrollments()
	{
		return enrollmentRepository.findAll();
	}
}
