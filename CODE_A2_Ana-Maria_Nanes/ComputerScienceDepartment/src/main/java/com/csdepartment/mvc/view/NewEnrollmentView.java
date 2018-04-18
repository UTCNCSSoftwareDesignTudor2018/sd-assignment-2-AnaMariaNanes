package com.csdepartment.mvc.view;

import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class NewEnrollmentView extends JFrame {

	private JPanel contentPane;
	private JList list;
	private JTextField textField;
	private JTextField textField_1;
	private JButton btnBack = new JButton("BACK");
	private JButton btnMakeEnrollment = new JButton("Make enrollment");
	private DefaultListModel<String> listModel = new DefaultListModel<>();

	public NewEnrollmentView() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 500, 650, 500);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		list = new JList();

		JLabel lblStartDate = new JLabel("Start Date:");
		lblStartDate.setBounds(339, 69, 76, 25);
		contentPane.add(lblStartDate);

		JLabel lblEndDate = new JLabel("End Date:");
		lblEndDate.setBounds(339, 109, 76, 25);
		contentPane.add(lblEndDate);

		textField = new JTextField();
		textField.setBounds(417, 67, 116, 22);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(417, 110, 116, 22);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		JLabel lblChooseFromThe = new JLabel("Choose from the above courses:");
		lblChooseFromThe.setBounds(35, 18, 205, 25);
		contentPane.add(lblChooseFromThe);

		btnMakeEnrollment.setBounds(339, 189, 147, 51);
		contentPane.add(btnMakeEnrollment);

		btnBack.setBounds(470, 394, 97, 25);
		contentPane.add(btnBack);

	}

	public void addBackListner(ActionListener al) {
		btnBack.addActionListener(al);
	}

	public void addNewEnListener(ActionListener al) {
		btnMakeEnrollment.addActionListener(al);
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

	public DefaultListModel<String> getListModel() {
		return listModel;
	}

	public String getStartDate() {
		return textField.getText();
	}

	public String getEndDate() {
		return textField_1.getText();
	}

	public JList getList() {
		return list;
	}

	public void clear() {
		textField_1.setText("");
		textField.setText("");
	}

}
