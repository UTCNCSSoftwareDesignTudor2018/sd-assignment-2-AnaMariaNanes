package com.csdepartment;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import com.csdepartment.mvc.view.HomePageView;
import com.csdepartment.validators.*;
import com.csdepartment.mvc.controller.HomePageController;
import com.csdepartment.mvc.model.*;

@SpringBootApplication
public class SpringBootPostgreSQLApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(SpringBootPostgreSQLApplication.class)
        		.headless(false)
        		.run(args);
	}
	
	@Bean
    public HomePageView homeFrame() {
        return new HomePageView();
    }
	
	
	@Bean
    public StudentModel createStudentModel() {
        return new StudentModel();
    }
	
	@Bean
    public TeacherModel createTeacherModel() {
        return new TeacherModel();
    }
	
	@Bean
    public HomePageController createHomePageController() {
        return new HomePageController();
    }
	
	@Bean
    public TeacherValidator createTeacherValidator() {
        return new TeacherValidator();
    }
	
	@Bean
    public StudentValidator createStudentValidator() {
        return new StudentValidator();
    }
	
	@Bean
    public EnrollmentValidator createEnrollmentValidator() {
        return new EnrollmentValidator();
    }
	
}
