package com.csdepartment.services;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.csdepartment.entities.Enrollment;
import com.csdepartment.entities.Grade;
import com.csdepartment.repositories.GradeRepository;

@Service()
public class GradeService {

	@Inject
	GradeRepository gradeRepository;

	public List<Grade> getAllGrades() {
		return gradeRepository.findAll();
	}

	public Grade getByGradeid(int id) {
		return gradeRepository.findByGradeid(id);
	}

	public List<Grade> getByEnrollment(Enrollment enrollment) {
		return gradeRepository.findByEnrollment(enrollment);
	}

	public Grade insert(Grade grade) {
		return gradeRepository.save(grade);
	}

	public void delete(Grade grade) {
		gradeRepository.delete(grade);
	}

	public void deleteByGradeid(int id) {
		gradeRepository.deleteByGradeid(id);
	}

	public void update(Grade grade) {
		Grade foundGrade = gradeRepository.findByGradeid(grade.getGradeid());
		foundGrade = grade;
		gradeRepository.save(foundGrade);
	}
}
