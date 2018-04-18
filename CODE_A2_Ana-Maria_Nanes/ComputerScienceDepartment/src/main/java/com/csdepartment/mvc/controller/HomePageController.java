package com.csdepartment.mvc.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import com.csdepartment.entities.*;
import com.csdepartment.mvc.model.*;
import com.csdepartment.mvc.view.*;
import com.csdepartment.services.*;
import com.csdepartment.validators.*;

public class HomePageController {

	@Inject
	TeacherService teacherService;
	@Inject
	StudentService studentService;
	@Inject
	CourseService courseService;
	@Inject
	GradeService gradeService;
	@Inject
	ReportService reportService;
	@Inject
	EnrollmentService enrollmentService;
	@Inject
	TeacherValidator teacherValidator;
	@Inject
	StudentValidator studentValidator;
	@Inject
	EnrollmentValidator enrollmentValidator;

	private StudentModel studentModel;
	private TeacherModel teacherModel;

	private HomePageView homePageView;
	private StudentRegistrationView studRegView;
	private TeacherRegistrationView teacherRegView;

	private StudentAccountView studAccView;
	private TeacherAccountView teacherAccView;

	private StudentProfileInfoView studInfoView;
	private StudentEnrollmentsView studEnrollView;
	private NewEnrollmentView newEnrollView;

	public void init(HomePageView homePageView, StudentModel studentModel, TeacherModel teacherModel) {
		this.homePageView = homePageView;
		this.studentModel = studentModel;
		this.teacherModel = teacherModel;

		this.homePageView.setVisible(true);

		this.studRegView = new StudentRegistrationView();
		this.teacherRegView = new TeacherRegistrationView();

		this.studAccView = new StudentAccountView();
		this.teacherAccView = new TeacherAccountView();

		this.studentModel = new StudentModel();
		this.teacherModel = new TeacherModel();

		this.studInfoView = new StudentProfileInfoView();
		this.studEnrollView = new StudentEnrollmentsView();
		this.newEnrollView = new NewEnrollmentView();

		// add action listeners inner classes
		homePageView.addLoginListener(new LoginListener());
		homePageView.addStudentRegistrationListener(new StudentRegistrationListener());
		homePageView.addTeacherRegistrationListener(new TeacherRegistrationListener());

		teacherRegView.addBackFromTeacherRegListener(new TeacherRegBackListener());
		teacherRegView.addTeacherRegisterListener(new TeacherRegListener());

		studRegView.addBackFromStudentRegListener(new StudentRegBackListener());
		studRegView.addStudentRegisterListener(new StudentRegListener());

		studAccView.addDetailsListeners(new DetailsListeners());
		studAccView.addDeleteAccListener(new DelStudAccListener());
		studAccView.addEnrollmentsListener(new EnrollmentsLisener());
		studAccView.addLogoutListener(new StudLogoutListener());

		studInfoView.addUpdateListener(new UpdateStudListener());
		studInfoView.addBackListener(new BackFromDetailsListner());

		studEnrollView.addBackListener(new BackEnrListener());
		studEnrollView.addRemoveEnListener(new RemoveEnrollmentListener());
		studEnrollView.addEnListener(new MakeEnrollListener());

		newEnrollView.addBackListner(new BackFromNewListener());
		newEnrollView.addNewEnListener(new NewEnrollListener());

		teacherAccView.addTeacherUpdateListener(new UpdateTeacherListener());
		teacherAccView.addDeleteTeacherAccListener(new DeleteTeacherAccListener());
		teacherAccView.addLogoutListener(new TeacherLogOutListener());
		teacherAccView.addAddExamGradeListener(new AddExamGradeListener());
		teacherAccView.addDisplayExamGradeListener(new DisplayExamGradesListener());
		teacherAccView.addGenerateReportListener(new GenerateReportListener());
		teacherAccView.addViewGradesListener(new ViewGradesListener());
		teacherAccView.addInsertGradeListener(new InsertGradeListener());

	}

	class LoginListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String username = homePageView.getInputUsername();
			String password = homePageView.getInputPassword();

			try {
				Student student = studentService.getStudentByUsername(username);
				if (student.getPassword().equals(password)) {

					studentModel.setStudent(student);
					studAccView.setStudentModel(studentModel);
					studAccView.setTitle("Student account: " + studentModel.getStudent().getName());
					studAccView.setVisible(true);
					homePageView.setVisible(false);

				} else {
					JOptionPane.showMessageDialog(null, "Incorrect password for student account.", "Log in error",
							JOptionPane.ERROR_MESSAGE);
				}
			} catch (Exception e1) {

				try {
					Teacher teacher = teacherService.getTeacherByUsername(username);

					if (teacher.getPassword().equals(password)) {

						teacherModel.setTeacher(teacher);
						teacherAccView.setTeacherModel(teacherModel);
						List<Enrollment> enrollments = enrollmentService
								.getByCourse(teacherModel.getTeacher().getCourses().get(0));
						List<String> studentNames = new ArrayList<String>();
						for (Enrollment en : enrollments) {
							studentNames.add(en.getStudent().getName());
						}

						teacherAccView.clear();
						teacherAccView.initializeList(studentNames);
						teacherAccView.initView(teacherModel.getTeacher());
						teacherAccView.addTheList();
						teacherAccView.setTitle("Teacher account: " + teacherModel.getTeacher().getName());
						teacherAccView.setCourseName(teacherModel.getTeacher().getCourses().get(0).getName());
						teacherAccView.setVisible(true);
						homePageView.setVisible(false);

					} else {
						JOptionPane.showMessageDialog(null, "Incorrect password for teacher account.", "Log in error",
								JOptionPane.ERROR_MESSAGE);
					}

				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "No account exists for provided username.", "Log in error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		}
	}

	class StudentRegistrationListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			homePageView.setVisible(false);
			studRegView.setVisible(true);
		}
	}

	class TeacherRegistrationListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			homePageView.setVisible(false);
			teacherRegView.setVisible(true);
		}
	}

	class TeacherRegBackListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			homePageView.setVisible(true);
			teacherRegView.setVisible(false);
		}
	}

	class TeacherRegListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			List<String> userInput = teacherRegView.getTeacherRegInfo();

			Teacher newTeacher = new Teacher(userInput.get(0), userInput.get(1), userInput.get(2));
			String message = teacherValidator.validateTeacher(newTeacher);

			if (message.equals("correct")) {
				teacherService.insert(newTeacher);

				JOptionPane.showMessageDialog(null, "Account created.", "Registration Status",
						JOptionPane.INFORMATION_MESSAGE);

				homePageView.setVisible(true);
				teacherRegView.setVisible(false);
			} else {
				JOptionPane.showMessageDialog(null, message, "Registration Status", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	class StudentRegBackListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			homePageView.setVisible(true);
			studRegView.setVisible(false);
		}
	}

	class StudentRegListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			List<String> userInput = studRegView.getStudentRegInfo();

			Student newStudent = new Student(userInput.get(0), userInput.get(1), userInput.get(2), userInput.get(3),
					userInput.get(4), userInput.get(5), userInput.get(6));
			String message = studentValidator.validateStudent(newStudent);

			if (message.equals("correct")) {
				studentService.insert(newStudent);
				JOptionPane.showMessageDialog(null, "Account created.", "Registration Status",
						JOptionPane.INFORMATION_MESSAGE);

				homePageView.setVisible(true);
				studRegView.setVisible(false);
			} else {
				JOptionPane.showMessageDialog(null, message, "Registration Status", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	class DetailsListeners implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			studInfoView.setVisible(true);
			studInfoView.initView(studentModel.getStudent());
			studAccView.setVisible(false);

		}
	}

	class EnrollmentsLisener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			List<String> courseNames = new ArrayList<String>();
			List<Course> allCourses = studentService.findStudentCourses(studentModel.getStudent().getStudentid());
			allCourses.stream().forEach(a -> courseNames.add(a.getName()));

			studEnrollView.getListModel().removeAllElements();
			studEnrollView.initializeList(courseNames);
			studEnrollView.setTitle("Student Account: " + studentModel.getStudent().getName() + " COURSES");
			studEnrollView.getList().addMouseListener(new ListMouseListener());
			studEnrollView.addTheList();
			studEnrollView.setVisible(true);
			studAccView.setVisible(false);
		}
	}

	class DelStudAccListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			studentService.delete(studentModel.getStudent());

			JOptionPane.showMessageDialog(null, "Student account deleted.", "Delete status.",
					JOptionPane.INFORMATION_MESSAGE);

			studAccView.setVisible(false);
			homePageView.setVisible(true);
			homePageView.clear();
		}
	}

	class StudLogoutListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			studAccView.setVisible(false);
			homePageView.setVisible(true);
			homePageView.clear();
		}
	}

	class BackFromDetailsListner implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			studInfoView.setVisible(false);
			homePageView.setVisible(true);
			homePageView.clear();
		}
	}

	class UpdateStudListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			List<String> input = studInfoView.getInput();

			Student updatedStudent = new Student(input.get(0), input.get(1), input.get(2), input.get(3), input.get(4),
					input.get(5), input.get(6));
			updatedStudent.setStudentid(studentModel.getStudent().getStudentid());
			String message = studentValidator.validateUpdateStudent(updatedStudent);
			if (message.equals("correct")) {
				studentService.update(updatedStudent);

				JOptionPane.showMessageDialog(null, "Student account information updated.", "Update status.",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, message, "Update status.", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	class ListMouseListener extends MouseAdapter {
		public void mouseClicked(MouseEvent e) {

			List<String> courseNames = new ArrayList<String>();
			List<Course> allCourses = studentService.findStudentCourses(studentModel.getStudent().getStudentid());
			allCourses.stream().forEach(a -> courseNames.add(a.getName()));

			JList theList = (JList) e.getSource();
			if (e.getClickCount() == 2) {
				int index = theList.locationToIndex(e.getPoint());
				String courseName = courseNames.get(index);

				try {
					Course chosenCourse = courseService.getByName(courseName);
					Teacher teacher = chosenCourse.getTeacher();
					String teacherName = teacher.getName();
					int credits = chosenCourse.getCredits();
					String room = chosenCourse.getRoom();

					Enrollment enrollment = enrollmentService.getByStudentAndCourse(studentModel.getStudent(),
							chosenCourse);

					String line1 = "Course:   " + courseName + "\n";
					String line2 = "Teacher:   " + teacherName + "\n";
					String line3 = "Credits:   " + credits + "\n";
					String line4 = "Room:   " + room + "\n";
					String line5 = "Start date:   " + enrollment.getStartDate() + "\n";
					String line6 = "End date:   " + enrollment.getEndDate() + "\n";
					String content = line1 + line2 + line3 + line4 + line5 + line6;
					studEnrollView.setCourseDetails(content);

					float examGrade = enrollment.getExamGrade();
					List<Grade> allGrades = enrollment.getGrades();

					String theGrades = "";
					for (Grade gr : allGrades) {
						theGrades = theGrades + gr.getGrade() + ", ";
					}

					String line2_1 = "Course:   " + courseName + "\n";
					String line2_2;
					if (!theGrades.equals("")) {
						line2_2 = "Grades:   " + theGrades + "\n";
					} else {
						line2_2 = "Grades:   " + "No grades yet." + "\n";
					}
					String line2_3 = "Final Exam Grade:   " + examGrade + "\n";
					String content2 = line2_1 + line2_2 + line2_3;
					studEnrollView.setCourseGrades(content2);

				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		}
	}

	class BackEnrListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			studEnrollView.setVisible(false);
			studAccView.setVisible(true);
		}
	}

	class RemoveEnrollmentListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Object selectedCourse = studEnrollView.getList().getSelectedValue();
			String courseName = (String) selectedCourse;
			int selectedIndex = studEnrollView.getList().getSelectedIndex();

			if (selectedCourse != null) {
				try {
					Course toRemoveCourse = courseService.getByName(courseName);
					Enrollment enroll = enrollmentService.getByStudentAndCourse(studentModel.getStudent(),
							toRemoveCourse);

					studEnrollView.getListModel().removeElementAt(selectedIndex);
					enrollmentService.delete(enroll);

				} catch (Exception e1) {
					e1.printStackTrace();
				}
			} else {
				JOptionPane.showMessageDialog(null, "No course selected.", "Remove Enrollment",
						JOptionPane.ERROR_MESSAGE);
			}

		}
	}

	class MakeEnrollListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			List<Course> allCourses = courseService.getAllCourses();
			List<Course> allCoursesOfStud = studentService.findStudentCourses(studentModel.getStudent().getStudentid());
			List<Course> remainingCourses = new ArrayList<Course>();
			for (Course allC : allCourses) {
				int ok = 1;
				for (Course studC : allCoursesOfStud) {
					if (allC.getCourseid() == studC.getCourseid()) {
						ok = 0;
					}
				}
				if (ok == 1) {
					remainingCourses.add(allC);
				}
			}

			List<String> courseNames = new ArrayList<String>();
			for (Course c : remainingCourses) {
				courseNames.add(c.getName());
			}

			newEnrollView.clear();
			newEnrollView.getListModel().removeAllElements();
			newEnrollView.initializeList(courseNames);
			newEnrollView.setTitle("Student: " + studentModel.getStudent().getName() + "  New Enrollment.");
			newEnrollView.addTheList();

			newEnrollView.setVisible(true);
			studEnrollView.setVisible(false);
		}
	}

	class BackFromNewListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			newEnrollView.setVisible(false);
			studEnrollView.setVisible(true);
		}
	}

	class NewEnrollListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String startDate = newEnrollView.getStartDate();
			String endDate = newEnrollView.getEndDate();
			Object selectedCourse = newEnrollView.getList().getSelectedValue();
			String courseName = (String) selectedCourse;

			if (selectedCourse != null) {
				try {
					Course selCourse = courseService.getByName(courseName);
					Enrollment newEnrollment = new Enrollment(0, startDate, startDate, selCourse,
							studentModel.getStudent());
					String message = enrollmentValidator.validateEnrollment(newEnrollment);
					if (message.equals("correct")) {
						enrollmentService.insert(newEnrollment);

						JOptionPane.showMessageDialog(null, "The enrollment was performed.", "Enrollment Status",
								JOptionPane.INFORMATION_MESSAGE);

						newEnrollView.setVisible(false);
						studEnrollView.getListModel().addElement(courseName);
						studEnrollView.setVisible(true);
					} else {
						JOptionPane.showMessageDialog(null, message, "Enrollment Status", JOptionPane.ERROR_MESSAGE);
					}

				} catch (Exception e1) {
					e1.printStackTrace();
				}
			} else {
				JOptionPane.showMessageDialog(null, "No course selected", "Make enrollment", JOptionPane.ERROR_MESSAGE);
			}

		}
	}

	class UpdateTeacherListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			List<String> input = new ArrayList<>();
			input = teacherAccView.getUserInput();

			Teacher newTeacher = new Teacher(input.get(0), input.get(1), input.get(2));
			newTeacher.setTeacherid(teacherModel.getTeacher().getTeacherid());
			// String message = teacherValidator.validateUpdateTeacher(newTeacher);
			String message = "correct";
			if (message.equals("correct")) {
				teacherService.update(newTeacher);

				JOptionPane.showMessageDialog(null, "Account updated.", "Update Status",
						JOptionPane.INFORMATION_MESSAGE);

				teacherAccView.setTitle("Teacher account: " + newTeacher.getName());

			} else {
				JOptionPane.showMessageDialog(null, message, "Update Status", JOptionPane.ERROR_MESSAGE);
			}

		}
	}

	class DeleteTeacherAccListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			teacherService.delete(teacherModel.getTeacher());
			JOptionPane.showMessageDialog(null, "The account has been deleted", "Account deletion",
					JOptionPane.INFORMATION_MESSAGE);

			teacherAccView.setVisible(false);
			homePageView.clear();
			homePageView.setVisible(true);
		}
	}

	class TeacherLogOutListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			teacherAccView.setVisible(false);
			homePageView.clear();
			homePageView.setVisible(true);
		}
	}

	class AddExamGradeListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Object selectedStudent = teacherAccView.getList().getSelectedValue();
			String studentName = (String) selectedStudent;

			if (selectedStudent == null) {
				JOptionPane.showMessageDialog(null, "No student chosen", "Student Exam Grading",
						JOptionPane.ERROR_MESSAGE);
			} else {
				try {
					float newGrade = teacherAccView.getExamGrade();
					Student selStudent;
					Course selCourse;
					try {

						selStudent = studentService.getStudentByName(studentName);
						selCourse = teacherModel.getTeacher().getCourses().get(0);
						List<Enrollment> enrollments = enrollmentService.getByCourse(selCourse);
						Enrollment enrol = new Enrollment();
						for (Enrollment en : enrollments) {
							if (en.getStudent().getStudentid() == selStudent.getStudentid())
								enrol = en;
						}
						enrol.setExamGrade(newGrade);
						enrollmentService.update(enrol);
						teacherAccView.clearExamGrade();

						JOptionPane.showMessageDialog(null, "Exam Grade updated.", "Exam Grade",
								JOptionPane.INFORMATION_MESSAGE);

					} catch (Exception e1) {
						e1.printStackTrace();
					}
				} catch (java.lang.NumberFormatException exp) {
					JOptionPane.showMessageDialog(null, "Wrong grade format", "Student Exam Grading",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		}
	}

	class GenerateReportListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String startPeriod = teacherAccView.getStartDate();
			String endPeriod = teacherAccView.getEndDate();

			Object selectedStudent = teacherAccView.getList().getSelectedValue();
			String studentName = (String) selectedStudent;

			if (selectedStudent == null) {
				JOptionPane.showMessageDialog(null, "No student chosen", "Student Report", JOptionPane.ERROR_MESSAGE);
			} else {
				String message = enrollmentValidator.validateDates(startPeriod, endPeriod);
				if (message.equals("correct")) {

					Student selStudent;
					Course selCourse;
					try {
						selStudent = studentService.getStudentByName(studentName);
						selCourse = teacherModel.getTeacher().getCourses().get(0);
						List<Enrollment> enrol = enrollmentService.getByStudent(selStudent);

						List<Enrollment> finished_courses = new ArrayList<>();
						List<Enrollment> enrolled_courses = new ArrayList<>();
						for (Enrollment en : enrol) {
							if (en.checkPeriod(startPeriod, endPeriod).equals("FINISHED"))
								finished_courses.add(en);
							if (en.checkPeriod(startPeriod, endPeriod).equals("ENROLLED"))
								enrolled_courses.add(en);
						}

						StringBuilder enrolled = new StringBuilder();
						StringBuilder finished = new StringBuilder();

						for (Enrollment en : finished_courses) {
							finished.append(en.getCourse().getName());
						}

						for (Enrollment en : enrolled_courses) {
							enrolled.append(en.getCourse().getName());
						}

						Report newReport = new Report.ReportBuilder().studentName(studentName)
								.teacherName(teacherModel.getTeacher().getName()).startPeriod(startPeriod)
								.endPeriod(endPeriod).coursesEnrolled(enrolled.toString())
								.coursesFinished(finished.toString()).create();

						reportService.insert(newReport);

					} catch (Exception e1) {
						e1.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(null, message, "Student Report", JOptionPane.ERROR_MESSAGE);
				}

			}
		}
	}

	class DisplayExamGradesListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Object selectedStudent = teacherAccView.getList().getSelectedValue();
			String studentName = (String) selectedStudent;

			if (selectedStudent == null) {
				JOptionPane.showMessageDialog(null, "No student chosen", "Student Exam Grade",
						JOptionPane.ERROR_MESSAGE);
			} else {

				Student selStudent;
				Course selCourse;
				try {
					selStudent = studentService.getStudentByName(studentName);
					selCourse = teacherModel.getTeacher().getCourses().get(0);
					List<Enrollment> enrollments = enrollmentService.getByCourse(selCourse);
					Enrollment enrol = new Enrollment();
					for (Enrollment en : enrollments) {
						if (en.getStudent().getStudentid() == selStudent.getStudentid())
							enrol = en;
					}
					Float grade = enrol.getExamGrade();

					if (grade > 0)
						teacherAccView.setExamGrade(String.valueOf(grade));
					else
						teacherAccView.setExamGrade("No exam grade yet.");
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		}
	}

	class ViewGradesListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			DefaultListModel model = (DefaultListModel) teacherAccView.getList().getModel();
			Object selectedStudent = model.getElementAt(teacherAccView.getList().getSelectedIndex());
			String studentName = (String) selectedStudent;

			if (selectedStudent == null) {
				JOptionPane.showMessageDialog(null, "No student chosen", "Student Exam Grades",
						JOptionPane.ERROR_MESSAGE);
			} else {
				Student selStudent;
				Course selCourse;

				try {

					selStudent = studentService.getStudentByName(studentName);
					selCourse = teacherModel.getTeacher().getCourses().get(0);
					List<Enrollment> enrollments = enrollmentService.getByCourse(selCourse);
					Enrollment enrol = new Enrollment();
					for (Enrollment en : enrollments) {
						if (en.getStudent().getStudentid() == selStudent.getStudentid())
							enrol = en;
					}

					List<Grade> allGrades = enrol.getGrades();
					String theGrades = "";
					for (Grade gr : allGrades) {
						if (theGrades.equals(""))
							theGrades = theGrades + gr.getGrade();
						else
							theGrades = theGrades + ", " + gr.getGrade();
					}
					teacherAccView.setGrades(theGrades);

				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		}
	}

	class InsertGradeListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			Object selectedStudent = teacherAccView.getList().getSelectedValue();
			String studentName = (String) selectedStudent;

			if (selectedStudent == null) {
				JOptionPane.showMessageDialog(null, "No student chosen", "Student Report", JOptionPane.ERROR_MESSAGE);
			} else {

				Student selStudent;
				Course selCourse;

				try {
					float grade = Float.valueOf(teacherAccView.getInputGrade());
					teacherAccView.clearInputGrade();
					if (grade < 4 || grade > 10) {
						JOptionPane.showMessageDialog(null, "Wrong grade format", "Student Grade",
								JOptionPane.ERROR_MESSAGE);
					} else {
						try {
							selStudent = studentService.getStudentByName(studentName);
							selCourse = teacherModel.getTeacher().getCourses().get(0);
							List<Enrollment> enrollments = enrollmentService.getByCourse(selCourse);
							Enrollment enrol = new Enrollment();
							for (Enrollment en : enrollments) {
								if (en.getStudent().getStudentid() == selStudent.getStudentid())
									enrol = en;
							}

							Grade newGrade = new Grade(enrol, grade);
							gradeService.insert(newGrade);

							JOptionPane.showMessageDialog(null, "The student`s grade was added.", "Grade received",
									JOptionPane.INFORMATION_MESSAGE);
							teacherAccView.updateGrades(String.valueOf(newGrade.getGrade()));
							teacherAccView.clearInputGrade();

						} catch (Exception e1) {
							e1.printStackTrace();
						}
					}

				} catch (java.lang.NumberFormatException exp) {
					JOptionPane.showMessageDialog(null, "Wrong grade format", "Student Grade",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		}
	}
}
