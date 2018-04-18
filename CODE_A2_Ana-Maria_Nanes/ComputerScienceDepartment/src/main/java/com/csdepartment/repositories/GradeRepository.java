package com.csdepartment.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.csdepartment.entities.Enrollment;
import com.csdepartment.entities.Grade;

public interface GradeRepository extends JpaRepository<Grade, Integer> {

	public List<Grade> findAll();

	public Grade findByGradeid(int id);

	public List<Grade> findByEnrollment(Enrollment enrollment);

	public Grade save(Grade grade);

	public void delete(Grade grade);

	public void deleteByGradeid(int id);
}
