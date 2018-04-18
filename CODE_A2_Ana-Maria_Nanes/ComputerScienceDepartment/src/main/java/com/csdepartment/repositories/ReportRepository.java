package com.csdepartment.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.csdepartment.entities.Report;

public interface ReportRepository extends MongoRepository<Report, String> {

	public List<Report> findByStudentName(String name);

	public List<Report> findAll();

	public void deleteAll();

	public void deleteById(int id);

	public Report save(Report report);

}
