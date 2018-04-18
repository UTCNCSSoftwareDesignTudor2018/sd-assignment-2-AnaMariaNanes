package com.csdepartment.services;

import java.util.List;

import javax.inject.Inject;
import com.csdepartment.entities.Report;

import org.springframework.stereotype.Service;
import com.csdepartment.repositories.ReportRepository;

@Service()
public class ReportService {

	@Inject
	ReportRepository reportRepository;

	public List<Report> getAllReports() {
		return reportRepository.findAll();
	}

	public List<Report> getReportOfStudent(String studentName) {
		return reportRepository.findByStudentName(studentName);
	}

	public void deleteAll() {
		reportRepository.deleteAll();
	}

	public void deleteByReportId(int id) {
		reportRepository.deleteById(id);
	}

	public Report insert(Report rep) {
		return reportRepository.save(rep);
	}
}
