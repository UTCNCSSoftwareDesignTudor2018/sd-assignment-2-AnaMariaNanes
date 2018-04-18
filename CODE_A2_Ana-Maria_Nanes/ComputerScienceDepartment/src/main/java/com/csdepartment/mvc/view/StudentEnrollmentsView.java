package com.csdepartment.mvc.view;

import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

public class StudentEnrollmentsView extends JFrame {

	private JPanel contentPane;
	private JList list;
	private DefaultListModel<String> listModel = new DefaultListModel<>();

	private JTextPane textPane = new JTextPane();
	private JTextPane textPane_1 = new JTextPane();

	private JButton btnRemoveEnrollment = new JButton("Remove Enrollment");
	private JButton btnNewEnrollment = new JButton("New Enrollment");
	private JButton btnBack = new JButton("BACK");

	public StudentEnrollmentsView() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 500, 650, 500);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblCourseEnrollments = new JLabel("Course enrollments:");
		lblCourseEnrollments.setBounds(36, 26, 133, 28);
		contentPane.add(lblCourseEnrollments);

		JLabel lblCourseDetails = new JLabel("Course details:");
		lblCourseDetails.setBounds(312, 13, 107, 16);
		contentPane.add(lblCourseDetails);

		JLabel lblCourseGrades = new JLabel("Course Grades:");
		lblCourseGrades.setBounds(312, 212, 94, 16);
		contentPane.add(lblCourseGrades);

		textPane.setBounds(312, 42, 240, 157);
		textPane.setEditable(false);
		contentPane.add(textPane);

		textPane_1.setBounds(312, 241, 240, 107);
		textPane.setEditable(false);
		contentPane.add(textPane_1);

		list = new JList();

		btnRemoveEnrollment.setBounds(36, 292, 170, 36);
		contentPane.add(btnRemoveEnrollment);

		btnNewEnrollment.setBounds(312, 361, 170, 36);
		contentPane.add(btnNewEnrollment);

		btnBack.setBounds(489, 404, 97, 25);
		contentPane.add(btnBack);
	}

	public void addListListener(MouseListener al) {
		list.addMouseListener(al);
	}

	public void addRemoveEnListener(ActionListener al) {
		btnRemoveEnrollment.addActionListener(al);
	}

	public void addEnListener(ActionListener al) {
		btnNewEnrollment.addActionListener(al);
	}

	public void addBackListener(ActionListener al) {
		btnBack.addActionListener(al);
	}

	public void initializeList(List<String> courseNames) {
		for (String st : courseNames) {
			listModel.addElement(st);
		}
		list = new JList<>(listModel);

		list.setBounds(36, 67, 200, 190);
		list.setVisible(true);
	}

	public void addTheList() {
		contentPane.add(list);
	}

	public void setCourseDetails(String content) {
		textPane.setText(content);
	}

	public void setCourseGrades(String content) {
		textPane_1.setText(content);
	}

	public JList getList() {
		return list;
	}

	public DefaultListModel<String> getListModel() {
		return listModel;
	}
}
