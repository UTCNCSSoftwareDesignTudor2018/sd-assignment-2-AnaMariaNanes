package com.csdepartment.mvc.view;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.csdepartment.mvc.model.StudentModel;

public class StudentRegistrationView extends JFrame {

	private StudentModel studentModel;

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JPasswordField textField_7;

	private JButton btnRegister = new JButton("Register");
	private JButton btnBack = new JButton("BACK");

	public StudentModel getStudentModel() {
		return studentModel;
	}

	public void setStudentModel(StudentModel studentModel) {
		this.studentModel = studentModel;
	}

	public StudentRegistrationView() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 400, 565, 455);
		setTitle("Student Registration");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblIntroduceTheRequired = new JLabel("Introduce the required data:");
		lblIntroduceTheRequired.setBounds(23, 26, 171, 16);
		contentPane.add(lblIntroduceTheRequired);

		JLabel lblCardid = new JLabel("CardID:");
		lblCardid.setBounds(23, 112, 56, 16);
		contentPane.add(lblCardid);

		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setBounds(23, 84, 65, 16);
		contentPane.add(lblLastName);

		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setBounds(23, 55, 81, 16);
		contentPane.add(lblFirstName);

		JLabel lblCnp = new JLabel("Cnp:");
		lblCnp.setBounds(23, 141, 56, 16);
		contentPane.add(lblCnp);

		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setBounds(23, 170, 56, 16);
		contentPane.add(lblAddress);

		JLabel lblGroup = new JLabel("Group:");
		lblGroup.setBounds(23, 199, 56, 16);
		contentPane.add(lblGroup);

		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(23, 228, 65, 16);
		contentPane.add(lblUsername);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(23, 257, 65, 16);
		contentPane.add(lblPassword);

		textField = new JTextField();
		textField.setBounds(116, 52, 116, 22);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(104, 81, 116, 22);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(91, 109, 116, 22);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setBounds(68, 138, 116, 22);
		contentPane.add(textField_3);
		textField_3.setColumns(10);

		textField_4 = new JTextField();
		textField_4.setBounds(91, 167, 116, 22);
		contentPane.add(textField_4);
		textField_4.setColumns(10);

		textField_5 = new JTextField();
		textField_5.setBounds(80, 199, 116, 22);
		contentPane.add(textField_5);
		textField_5.setColumns(10);

		textField_6 = new JTextField();
		textField_6.setBounds(104, 225, 116, 22);
		contentPane.add(textField_6);
		textField_6.setColumns(10);

		textField_7 = new JPasswordField();
		textField_7.setBounds(100, 254, 116, 22);
		contentPane.add(textField_7);
		textField_7.setColumns(10);

		btnRegister.setBounds(80, 307, 97, 25);
		contentPane.add(btnRegister);

		btnBack.setBounds(408, 353, 97, 25);
		contentPane.add(btnBack);
	}

	public List<String> getStudentRegInfo() {
		List<String> userInput = new ArrayList<>();

		String name = textField.getText() + " " + textField_1.getText();
		String cardID = textField_2.getText();
		String cnp = textField_3.getText();
		String address = textField_4.getText();
		String groupID = textField_5.getText();
		String username = textField_6.getText();
		char[] pass = textField_7.getPassword();
		String password = String.valueOf(pass);

		userInput.add(name);
		userInput.add(cardID);
		userInput.add(cnp);
		userInput.add(address);
		userInput.add(groupID);
		userInput.add(username);
		userInput.add(password);

		return userInput;
	}

	public void addStudentRegisterListener(ActionListener al) {
		btnRegister.addActionListener(al);
	}

	public void addBackFromStudentRegListener(ActionListener al) {
		btnBack.addActionListener(al);
	}

}
