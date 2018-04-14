package com.csdepartment.mvc.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.inject.Inject;
import javax.swing.JOptionPane;

import com.csdepartment.entities.*;
import com.csdepartment.mvc.model.*;
import com.csdepartment.mvc.view.*;
import com.csdepartment.services.*;
import com.csdepartment.validators.*;

public class HomePageController {
	
	//services
	@Inject 
	TeacherService teacherService;
	
	@Inject
	StudentService studentService;
	
	//validators
	@Inject 
	TeacherValidator teacherValidator;
	
	@Inject 
	StudentValidator studentValidator;
	
	
	private StudentModel studentModel;
	private TeacherModel teacherModel;
	
	private HomePageView homePageView;
	private StudentRegistrationView studRegView;
	private TeacherRegistrationView teacherRegView;
	
	private StudentAccountView studAccView;
	private TeacherAccountView teacherAccView;

	public void init(HomePageView homePageView, StudentModel studentModel, TeacherModel teacherModel) {
		this.homePageView = homePageView;
		this.studentModel = studentModel;
		this.teacherModel = teacherModel;
		
		this.homePageView.setVisible(true);
	
		this.studRegView = new StudentRegistrationView();
		this.teacherRegView = new TeacherRegistrationView();
		
		this.studAccView = new StudentAccountView();
		this.teacherAccView = new TeacherAccountView();
		
		this.studentModel=  new StudentModel();
		this.teacherModel = new TeacherModel();
		
		//add action listeners inner classes		
		homePageView.addLoginListener(new LoginListener());
		homePageView.addStudentRegistrationListener( new StudentRegistrationListener() );
		homePageView.addTeacherRegistrationListener( new TeacherRegistrationListener());	
		
		teacherRegView.addBackFromTeacherRegListener(new TeacherRegBackListener());
		teacherRegView.addTeacherRegisterListener(new TeacherRegListener() );
		
		studRegView.addBackFromStudentRegListener(new StudentRegBackListener());
		studRegView.addStudentRegisterListener(new StudentRegListener() );
	}
	
	// action listeners for HomePage
	
	class LoginListener implements ActionListener
		{
			public void actionPerformed(ActionEvent e)
			{
				String username = homePageView.getInputUsername();
				String password = homePageView.getInputPassword();
				
				// try to find student account
				try {
					Student student = studentService.getStudentByUsername(username);
					if(student.getPassword().equals(password))
					{

						studentModel.setStudent(student);
						studAccView.setStudentModel(studentModel);
						studAccView.setTitle("Student account: "+ studentModel.getStudent().getName() );
						studAccView.setVisible(true);
						homePageView.setVisible(false);
						
					}
					else
					{
						JOptionPane.showMessageDialog(null, 
		                        "Incorrect password for student account.", 
		                        "Log in error", 
		                        JOptionPane.ERROR_MESSAGE);
					}
				} catch (Exception e1) {
					
					// try to find teacher account
					try {
						Teacher teacher = teacherService.getTeacherByUsername(username);
						if(teacher.getPassword().equals(password))
						{
						
						teacherModel.setTeacher(teacher);
						teacherAccView.setTeacherModel(teacherModel);
						teacherAccView.setTitle("Teacher account: " + teacherModel.getTeacher().getName());
						teacherAccView.setVisible(true);
                        homePageView.setVisible(false);
						
						}
						else
						{
							JOptionPane.showMessageDialog(null, 
			                        "Incorrect password for teacher account.", 
			                        "Log in error", 
			                        JOptionPane.ERROR_MESSAGE);
						}
						
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null, 
		                        "No account exists for provided username.", 
		                        "Log in error", 
		                        JOptionPane.ERROR_MESSAGE);}
				}
			}
		}
		
		class StudentRegistrationListener implements ActionListener
		{
			public void actionPerformed(ActionEvent e)
			{
				homePageView.setVisible(false);
				studRegView.setVisible(true);
			}
		}
	
		class TeacherRegistrationListener implements ActionListener
		{
			public void actionPerformed(ActionEvent e)
			{
				homePageView.setVisible(false);
				teacherRegView.setVisible(true);
			}
		}
		
		// action Listeners for TeacherRegistration
		
		class TeacherRegBackListener implements ActionListener
		{
			public void actionPerformed(ActionEvent e)
			{
				homePageView.setVisible(true);
				teacherRegView.setVisible(false);
			}
		}
		
		class TeacherRegListener implements ActionListener
		{		
			public void actionPerformed(ActionEvent e)
			{
				List<String> userInput = teacherRegView.getTeacherRegInfo();
				
				Teacher newTeacher = new Teacher(userInput.get(0),userInput.get(1),userInput.get(2));
				String message = teacherValidator.validateTeacher(newTeacher);
		
				if(message.equals("correct"))
				{
					teacherService.insert(newTeacher);
					
					JOptionPane.showMessageDialog(null, 
	                        "Account created.", 
	                        "Registration Status", 
	                        JOptionPane.INFORMATION_MESSAGE);
					
					homePageView.setVisible(true);
					studRegView.setVisible(false);
				}
				else
				{
					JOptionPane.showMessageDialog(null, 
	                         message, 
	                        "Registration Status", 
	                        JOptionPane.ERROR_MESSAGE);
				}		
			}
				
		}
		
		// action Listeners for StudentRegistration		
		class StudentRegBackListener implements ActionListener
		{
			public void actionPerformed(ActionEvent e)
			{
				homePageView.setVisible(true);
				studRegView.setVisible(false);
			}
		}
		
		class StudentRegListener implements ActionListener
		{
			public void actionPerformed(ActionEvent e)
			{
				List<String> userInput = studRegView.getStudentRegInfo();
								
				Student newStudent = new Student(userInput.get(0),userInput.get(1),userInput.get(2),userInput.get(3),
						userInput.get(4),userInput.get(5),userInput.get(6));
				String message = studentValidator.validateStudent(newStudent);
				
				if(message.equals("correct")) {
					studentService.insert(newStudent);
					JOptionPane.showMessageDialog(null, 
	                        "Account created.", 
	                        "Registration Status", 
	                        JOptionPane.INFORMATION_MESSAGE);
					
				    homePageView.setVisible(true);
					studRegView.setVisible(false);
				}
				else
				{
					JOptionPane.showMessageDialog(null, 
	                         message, 
	                        "Registration Status", 
	                        JOptionPane.ERROR_MESSAGE);
				}
			}
		}
}
