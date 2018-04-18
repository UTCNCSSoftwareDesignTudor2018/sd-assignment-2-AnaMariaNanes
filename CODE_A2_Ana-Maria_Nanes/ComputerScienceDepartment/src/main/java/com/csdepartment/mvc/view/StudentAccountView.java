package com.csdepartment.mvc.view;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.csdepartment.mvc.model.StudentModel;

public class StudentAccountView extends JFrame {

	private StudentModel studentModel;

	private JPanel contentPane;
	private JButton btnViewStudentProfile = new JButton("View Student Profile");
	private JButton btnEnrollments = new JButton("Enrollments");
	private JButton btnDeleteAccount = new JButton("Delete Account");
	private JButton btnLogOut = new JButton("Log out");

	public StudentAccountView() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 500, 650, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnViewStudentProfile.setBounds(54, 74, 214, 203);
		contentPane.add(btnViewStudentProfile);

		btnEnrollments.setBounds(338, 74, 232, 203);
		contentPane.add(btnEnrollments);

		btnDeleteAccount.setBounds(440, 329, 135, 25);
		contentPane.add(btnDeleteAccount);

		btnLogOut.setBounds(473, 398, 97, 25);
		contentPane.add(btnLogOut);
	}

	public StudentModel getStudentModel() {
		return studentModel;
	}

	public void setStudentModel(StudentModel studentModel) {
		this.studentModel = studentModel;
	}

	public void addDetailsListeners(ActionListener al) {
		btnViewStudentProfile.addActionListener(al);
	}

	public void addEnrollmentsListener(ActionListener al) {
		btnEnrollments.addActionListener(al);
	}

	public void addDeleteAccListener(ActionListener al) {
		btnDeleteAccount.addActionListener(al);
	}

	public void addLogoutListener(ActionListener al) {
		btnLogOut.addActionListener(al);
	}

}
