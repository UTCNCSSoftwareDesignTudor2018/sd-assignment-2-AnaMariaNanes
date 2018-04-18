package com.csdepartment.validators;

import java.util.List;

import javax.inject.Inject;

import com.csdepartment.entities.Student;
import com.csdepartment.services.StudentService;

public class StudentValidator {

	@Inject
	StudentService studentService;

	public StudentValidator() {
	}

	public String validateStudent(Student st) {
		String message = "correct";

		if (st.getName().equals("") || st.getName().equals("") || (!isNameUnique(st.getName())))
			return message = "Wrong name field format";
		if (st.getCard() == null || st.getCard().equals("") || st.getCard().length() != 5
				|| (!st.getCard().matches("[0-9]+")) || (!isCardIDUnique(st.getCard())))
			return message = "Wrong cardID field format";
		if (st.getCnp() == null || st.getCnp().equals("") || st.getCnp().length() != 10
				|| (!st.getCard().matches("[0-9]+")) || (!isCnpUnique(st.getCnp())))
			return message = "Wrong cnp field format";
		if (st.getAddress() == null || st.getAddress().equals(""))
			return message = "Wrong address field format";
		if (st.getGroupid() == null || st.getGroupid().equals("") || st.getGroupid().length() != 5
				|| (!st.getCard().matches("[0-9]+")))
			return message = "Wrong groupID field format";
		if (st.getUsername() == null || st.getUsername().equals("") || (!isUsernameUnique(st.getUsername())))
			return message = "Wrong username field format";
		if (st.getPassword() == null || st.getPassword().equals("") || st.getPassword().length() != 5
				|| (!st.getCard().matches("[0-9]+")))
			return message = "Wrong password field format";

		return message;
	}

	public String validateUpdateStudent(Student st) {
		String message = "correct";

		if (st.getName().equals("") || st.getName().equals(""))
			return message = "Wrong name field format";
		if (st.getCard() == null || st.getCard().equals("") || st.getCard().length() != 5
				|| (!st.getCard().matches("[0-9]+")))
			return message = "Wrong cardID field format";
		if (st.getCnp() == null || st.getCnp().equals("") || st.getCnp().length() != 10
				|| (!st.getCard().matches("[0-9]+")))
			return message = "Wrong cnp field format";
		if (st.getAddress() == null || st.getAddress().equals(""))
			return message = "Wrong address field format";
		if (st.getGroupid() == null || st.getGroupid().equals("") || st.getGroupid().length() != 5
				|| (!st.getCard().matches("[0-9]+")))
			return message = "Wrong groupID field format";
		if (st.getUsername() == null || st.getUsername().equals(""))
			return message = "Wrong username field format";
		if (st.getPassword() == null || st.getPassword().equals("") || st.getPassword().length() != 5
				|| (!st.getCard().matches("[0-9]+")))
			return message = "Wrong password field format";

		return message;
	}

	private boolean isNameUnique(String name) {
		List<Student> allStud = studentService.getAllStudents();
		for (Student st : allStud) {
			if (st.getName().equals(name))
				return false;
		}

		return true;
	}

	private boolean isUsernameUnique(String username) {
		List<Student> allStud = studentService.getAllStudents();
		for (Student st : allStud) {
			if (st.getUsername().equals(username))
				return false;
		}

		return true;
	}

	private boolean isCardIDUnique(String cardID) {
		List<Student> allStud = studentService.getAllStudents();
		for (Student st : allStud) {
			if (st.getCard().equals(cardID))
				return false;
		}

		return true;
	}

	private boolean isCnpUnique(String cnp) {
		List<Student> allStud = studentService.getAllStudents();
		for (Student st : allStud) {
			if (st.getCnp().equals(cnp))
				return false;
		}

		return true;
	}

}
