package com.csdepartment;
import javax.inject.Inject;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.csdepartment.entities.Customer;
import com.csdepartment.entities.Report;
import com.csdepartment.entities.Student;
import com.csdepartment.repositories.CustomerRepository;
import com.csdepartment.services.ReportService;
import com.csdepartment.services.StudentService;

@Component
public class Loader implements ApplicationListener<ContextRefreshedEvent>{
    
    @Inject 
    StudentService studentService;
    
    @Inject 
    CustomerRepository customerRepository;
    
    @Inject
    ReportService reportService;
    
    
	public void onApplicationEvent(ContextRefreshedEvent event) {
        	
             
            for (Customer customer : customerRepository.findAll()) {
     			System.out.println(customer.getFirstName() + " " + customer.getLastName());
     		}
     		System.out.println();
     		
     		Student student = studentService.getStudentById(1);
     		System.out.println(student.getName());
     		
     		System.out.println();
     		
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
    		
    		
     		
     		
     		
     		
        }
}