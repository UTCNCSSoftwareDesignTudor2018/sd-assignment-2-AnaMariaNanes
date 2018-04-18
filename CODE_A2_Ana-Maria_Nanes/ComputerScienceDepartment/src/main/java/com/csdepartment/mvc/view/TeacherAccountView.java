package com.csdepartment.mvc.view;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.csdepartment.entities.Teacher;
import com.csdepartment.mvc.model.TeacherModel;

public class TeacherAccountView extends JFrame {

	private TeacherModel teacherModel;

	private JPanel contentPane;

	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JPasswordField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JList list;
	private DefaultListModel<String> listModel = new DefaultListModel<>();
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;

	private JButton btnUpdate = new JButton("Update");
	private JButton btnDeleteAccount = new JButton("Delete Account");
	private JButton btnLogOut = new JButton("Log out");
	private JButton btnAddExamGrade = new JButton("Add exam grade");
	private JButton btnDisplayExamGrade = new JButton("Display Exam Grade");
	private JButton btnGenerateStudentReport = new JButton("GENERATE STUDENT REPORT");
	private JButton btnViewGrades = new JButton("View Grades");
	private JButton btnInsertGrade = new JButton("Insert Grade");

	public TeacherAccountView() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(700, 700, 850, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTeacherid = new JLabel("TeacherID: ");
		lblTeacherid.setBounds(17, 25, 77, 21);
		contentPane.add(lblTeacherid);

		JLabel lblUsername = new JLabel("Username: ");
		lblUsername.setBounds(17, 88, 77, 16);
		contentPane.add(lblUsername);

		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(17, 59, 56, 16);
		contentPane.add(lblName);

		JLabel lblPassword = new JLabel("Password: ");
		lblPassword.setBounds(17, 117, 77, 26);
		contentPane.add(lblPassword);

		textField = new JTextField();
		textField.setBounds(84, 24, 116, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		textField.setEditable(false);

		textField_1 = new JTextField();
		textField_1.setBounds(68, 53, 116, 22);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(84, 85, 116, 22);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JPasswordField();
		textField_3.setBounds(84, 117, 116, 22);
		contentPane.add(textField_3);
		textField_3.setColumns(10);

		JLabel lblCourse = new JLabel("Course: ");
		lblCourse.setBounds(259, 27, 56, 16);
		contentPane.add(lblCourse);

		JLabel lblStudents = new JLabel("Students: ");
		lblStudents.setBounds(403, 54, 77, 21);
		contentPane.add(lblStudents);

		JLabel lblExamGrade = new JLabel("Exam Grade:");
		lblExamGrade.setBounds(226, 446, 89, 26);
		contentPane.add(lblExamGrade);

		textField_4 = new JTextField();
		textField_4.setBounds(320, 24, 245, 22);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		textField_4.setEditable(false);
		contentPane.add(textField_4);

		list = new JList();

		textField_5 = new JTextField();
		textField_5.setBounds(330, 448, 116, 22);
		contentPane.add(textField_5);
		textField_5.setColumns(13);

		textField_6 = new JTextField();
		textField_6.setBounds(333, 377, 116, 22);
		contentPane.add(textField_6);
		textField_6.setColumns(10);

		textField_7 = new JTextField();
		textField_7.setBounds(474, 377, 116, 22);
		contentPane.add(textField_7);
		textField_7.setColumns(10);

		JLabel lblPeriod = new JLabel("Period:");
		lblPeriod.setBounds(258, 380, 56, 16);
		contentPane.add(lblPeriod);

		textField_8 = new JTextField();
		textField_8.setBounds(360, 546, 268, 22);
		contentPane.add(textField_8);
		textField_8.setEditable(false);
		textField_8.setColumns(10);

		textField_9 = new JTextField();
		textField_9.setBounds(364, 588, 116, 22);
		contentPane.add(textField_9);
		textField_9.setColumns(10);

		btnUpdate.setBounds(51, 166, 97, 25);
		contentPane.add(btnUpdate);
		btnDeleteAccount.setBounds(35, 614, 128, 26);
		contentPane.add(btnDeleteAccount);
		btnLogOut.setBounds(35, 576, 128, 25);
		contentPane.add(btnLogOut);
		btnAddExamGrade.setBounds(336, 494, 144, 26);
		contentPane.add(btnAddExamGrade);
		btnDisplayExamGrade.setBounds(458, 447, 170, 25);
		contentPane.add(btnDisplayExamGrade);
		btnGenerateStudentReport.setBounds(320, 340, 245, 25);
		contentPane.add(btnGenerateStudentReport);
		btnViewGrades.setBounds(226, 545, 110, 25);
		contentPane.add(btnViewGrades);
		btnInsertGrade.setBounds(226, 587, 110, 25);
		contentPane.add(btnInsertGrade);
	}

	public TeacherModel getTeacherModel() {
		return teacherModel;
	}

	public void setTeacherModel(TeacherModel teacherModel) {
		this.teacherModel = teacherModel;
	}

	public void addLogoutListener(ActionListener al) {
		btnLogOut.addActionListener(al);
	}

	public void addTeacherUpdateListener(ActionListener al) {
		btnUpdate.addActionListener(al);
	}

	public void addDeleteTeacherAccListener(ActionListener al) {
		btnDeleteAccount.addActionListener(al);
	}

	public void addAddExamGradeListener(ActionListener al) {
		btnAddExamGrade.addActionListener(al);
	}

	public void addDisplayExamGradeListener(ActionListener al) {
		btnDisplayExamGrade.addActionListener(al);
	}

	public void addGenerateReportListener(ActionListener al) {
		btnGenerateStudentReport.addActionListener(al);
	}

	public void addViewGradesListener(ActionListener al) {
		btnViewGrades.addActionListener(al);
	}

	public void addInsertGradeListener(ActionListener al) {
		btnInsertGrade.addActionListener(al);
	}

	public void initView(Teacher teacher) {
		textField.setText(String.valueOf(teacher.getTeacherid()));
		textField_1.setText(teacher.getName());
		textField_2.setText(teacher.getUsername());
		textField_3.setText(teacher.getPassword());
	}

	public List<String> getUserInput() {
		List<String> input = new ArrayList<>();
		input.add(textField_1.getText());
		input.add(textField_2.getText());
		char[] pass = textField_3.getPassword();
		String password = String.valueOf(pass);
		input.add(password);

		return input;
	}

	public void setCourseName(String courseName) {
		textField_4.setText(courseName);
	}

	public JList getList() {
		return list;
	}

	public DefaultListModel<String> getListModel() {
		return listModel;
	}

	public void initializeList(List<String> studentNames) {
		listModel.removeAllElements();
		for (String st : studentNames) {
			listModel.addElement(st);
		}
		list = new JList<>(listModel);

		list.setBounds(248, 84, 403, 243);
		list.setVisible(true);

	}

	public void addTheList() {
		contentPane.add(list);
	}

	public void setGrades(String theGrades) {
		textField_8.setText(theGrades);
	}

	public void clear() {
		textField_8.setText("");
	}

	public String getInputGrade() {
		return textField_9.getText();
	}

	public void clearInputGrade() {
		textField_9.setText("");
	}

	public void updateGrades(String grade) {
		textField_8.setText(textField_8.getText() + " ," + grade);
	}

	public void setExamGrade(String examGrade) {
		textField_5.setText(examGrade);
	}

	public Float getExamGrade() {
		return Float.valueOf(textField_5.getText());
	}

	public void clearExamGrade() {
		textField_5.setText("");
	}

	public String getStartDate() {
		return textField_6.getText();
	}

	public String getEndDate() {
		return textField_7.getText();
	}
}
