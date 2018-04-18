package com.csdepartment.mvc.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;

public class HomePageView extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField textField_1;

	private JButton btnLogIn = new JButton("Log in");
	private JButton btnCreateStudentAccount = new JButton("Create Student Account");
	private JButton btnCreateTeacherAccount = new JButton("Create Teacher Account");

	public HomePageView() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 500, 650, 500);
		setTitle("Computer Science Department Page");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblWelcomeToThe = new JLabel("Welcome to the Computer Science Department!");
		lblWelcomeToThe.setBounds(170, 34, 288, 16);
		contentPane.add(lblWelcomeToThe);

		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(50, 104, 80, 16);
		contentPane.add(lblUsername);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(50, 133, 78, 16);
		contentPane.add(lblPassword);

		textField = new JTextField();
		textField.setBounds(152, 101, 116, 22);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JPasswordField();
		textField_1.setBounds(152, 130, 116, 22);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		btnLogIn.setBounds(119, 176, 97, 25);
		contentPane.add(btnLogIn);

		btnCreateStudentAccount.setBounds(50, 273, 178, 25);
		contentPane.add(btnCreateStudentAccount);

		btnCreateTeacherAccount.setBounds(264, 273, 178, 25);
		contentPane.add(btnCreateTeacherAccount);
	}

	public String getInputUsername() {
		return textField.getText();
	}

	public String getInputPassword() {
		char[] pass = textField_1.getPassword();
		String password = String.valueOf(pass);
		return password;
	}

	public void addLoginListener(ActionListener al) {
		btnLogIn.addActionListener(al);
	}

	public void addStudentRegistrationListener(ActionListener al) {
		btnCreateStudentAccount.addActionListener(al);
	}

	public void addTeacherRegistrationListener(ActionListener al) {
		btnCreateTeacherAccount.addActionListener(al);
	}

	public void clear() {
		textField.setText("");
		textField_1.setText("");
	}

}
