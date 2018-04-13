package com.csdepartment.services;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.csdepartment.entities.Grade;
import com.csdepartment.repositories.GradeRepository;

@Service()
public class GradeService {

	@Inject
	GradeRepository gradeRepository;
	
	public List<Grade> getAllGrades()
	{
		return gradeRepository.findAll();
	}
}
