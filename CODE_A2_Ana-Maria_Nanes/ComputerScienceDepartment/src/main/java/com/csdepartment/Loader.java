package com.csdepartment;
import javax.inject.Inject;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.csdepartment.entities.*;
import com.csdepartment.mvc.controller.HomePageController;
import com.csdepartment.mvc.model.*;
import com.csdepartment.mvc.view.HomePageView;
import com.csdepartment.services.*;


@Component
public class Loader implements ApplicationListener<ContextRefreshedEvent>{
    

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
        	
	
		    // initialize MongoDB if empty 		
     		if(reportService.getAllReports().size() == 0)
     		{
     		
     		reportService.insert(new Report("Ana", "Mr Joldos", "Maths, DSD", "System Theory", "1.02.2018", "16.05.2018"));
     		reportService.insert(new Report("Crina", "Mr Popescu", "Logic Design", "Graphics, Image Processing", "1.02.2018", "16.05.2018"));
     		reportService.insert(new Report("Dorel", "Mr Gorgan", "OOP, Distributed Systems", "Algebra", "1.02.2018", "16.05.2018"));
     		}
     		    		
     	    // retrieve from MongoDB   		
     		for (Report report: reportService.getAllReports()) {
    			System.out.println(report.getStudentName());
    		}
    		System.out.println();
    	
    		
    		//students		
    		for (Student student: studentService.getAllStudents()) {
    			System.out.println(student.getName());
    		}
    		System.out.println();
    	    	 		
    		homePageController.init(homePage, studentModel, teacherModel);
    		
    		  		 		 		
	}
}