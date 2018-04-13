package com.csdepartment;
import javax.inject.Inject;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.csdepartment.entities.Course;
import com.csdepartment.entities.Enrollment;
import com.csdepartment.entities.Grade;
import com.csdepartment.entities.Report;
import com.csdepartment.entities.Student;
import com.csdepartment.entities.Teacher;
import com.csdepartment.services.CourseService;
import com.csdepartment.services.EnrollmentService;
import com.csdepartment.services.GradeService;
import com.csdepartment.services.ReportService;
import com.csdepartment.services.StudentService;
import com.csdepartment.services.TeacherService;

@Component
public class Loader implements ApplicationListener<ContextRefreshedEvent>{
    
    
    @Inject
    CourseService courseService;
    
    @Inject
    EnrollmentService enrollmentService;
    
    @Inject 
    GradeService gradeService;
    
    @Inject
    ReportService reportService;
    
    @Inject 
    StudentService studentService;
    
    @Inject
    TeacherService teacherService;
    
    
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
    		
    		// teachers
    		for (Teacher teacher: teacherService.getAllTeachers()) {
    			System.out.println(teacher.getName());
    		}
    		System.out.println();
    		
    		// courses
    		for (Course course : courseService.getAllCourses()) {
    			System.out.println(course.getName());
    		}
    		System.out.println();
    		
    		
    		// enrollments
    		for (Enrollment enrollment: enrollmentService.getAllEnrollments()) {
    			System.out.println(enrollment.getEnrollmentid());
    		}
    		System.out.println();   		
    		
    		// grades
    		for (Grade grade: gradeService.getAllGrades()) {
    			System.out.println(grade.getGrade() + "  enrollmentID:   " + grade.getEnrollment().getEnrollmentid());
    		}
    		System.out.println();  
        }
}