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

import com.csdepartment.entities.Student;

public class StudentProfileInfoView extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JPasswordField textField_7;

	private JButton btnUpdate = new JButton("Update");
	private JButton btnBack = new JButton("BACK");

	public StudentProfileInfoView() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 500, 650, 500);
		setTitle("Student Profile Information");

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblStudentid = new JLabel("StudentID:");
		lblStudentid.setBounds(30, 29, 70, 21);
		contentPane.add(lblStudentid);

		JLabel lblFullName = new JLabel("Full Name:");
		lblFullName.setBounds(30, 63, 70, 16);
		contentPane.add(lblFullName);

		JLabel lblCardid = new JLabel("CardID:");
		lblCardid.setBounds(30, 98, 56, 16);
		contentPane.add(lblCardid);

		JLabel lblCnp = new JLabel("Cnp:");
		lblCnp.setBounds(30, 127, 56, 16);
		contentPane.add(lblCnp);

		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setBounds(30, 156, 56, 16);
		contentPane.add(lblAddress);

		JLabel lblGroupid = new JLabel("GroupID:");
		lblGroupid.setBounds(30, 189, 56, 16);
		contentPane.add(lblGroupid);

		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(30, 224, 70, 16);
		contentPane.add(lblUsername);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(30, 253, 70, 16);
		contentPane.add(lblPassword);

		textField = new JTextField();
		textField.setBounds(110, 28, 116, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		textField.setEditable(false);

		textField_1 = new JTextField();
		textField_1.setBounds(110, 60, 116, 22);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(98, 92, 116, 22);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setBounds(78, 127, 116, 22);
		contentPane.add(textField_3);
		textField_3.setColumns(10);

		textField_4 = new JTextField();
		textField_4.setBounds(98, 153, 116, 22);
		contentPane.add(textField_4);
		textField_4.setColumns(10);

		textField_5 = new JTextField();
		textField_5.setBounds(98, 186, 116, 22);
		contentPane.add(textField_5);
		textField_5.setColumns(10);

		textField_6 = new JTextField();
		textField_6.setBounds(110, 221, 116, 22);
		contentPane.add(textField_6);
		textField_6.setColumns(10);

		textField_7 = new JPasswordField();
		textField_7.setBounds(110, 250, 116, 22);
		contentPane.add(textField_7);
		textField_7.setColumns(10);

		btnUpdate.setBounds(62, 307, 97, 25);
		contentPane.add(btnUpdate);

		btnBack.setBounds(469, 394, 97, 25);
		contentPane.add(btnBack);
	}

	public void initView(Student student) {
		textField.setText(String.valueOf(student.getStudentid()));
		textField_1.setText(student.getName());
		textField_2.setText(student.getCard());
		textField_3.setText(student.getCnp());
		textField_4.setText(student.getAddress());
		textField_5.setText(student.getGroupid());
		textField_6.setText(student.getUsername());
		textField_7.setText(student.getPassword());
	}

	public void addUpdateListener(ActionListener al) {
		btnUpdate.addActionListener(al);
	}

	public void addBackListener(ActionListener al) {
		btnBack.addActionListener(al);
	}

	public List<String> getInput() {
		List<String> input = new ArrayList<String>();
		input.add(textField_1.getText());
		input.add(textField_2.getText());
		input.add(textField_3.getText());
		input.add(textField_4.getText());
		input.add(textField_5.getText());
		input.add(textField_6.getText());

		char[] pass = textField_7.getPassword();
		String password = String.valueOf(pass);
		input.add(password);

		return input;
	}

}
