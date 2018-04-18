package com.csdepartment;

import javax.inject.Inject;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.csdepartment.mvc.controller.HomePageController;
import com.csdepartment.mvc.model.*;
import com.csdepartment.mvc.view.HomePageView;
import com.csdepartment.services.*;

@Component
public class Loader implements ApplicationListener<ContextRefreshedEvent> {

	@Inject
	ReportService reportService;
	@Inject
	StudentService studentService;
	@Inject
	HomePageView homePage;
	@Inject
	StudentModel studentModel;
	@Inject
	TeacherModel teacherModel;
	@Inject
	HomePageController homePageController;

	public void onApplicationEvent(ContextRefreshedEvent event) {
		homePageController.init(homePage, studentModel, teacherModel);

	}
}