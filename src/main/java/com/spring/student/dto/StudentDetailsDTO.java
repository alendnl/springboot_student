package com.spring.student.dto;

public class StudentDetailsDTO {
	private int studentId;
	private String studentName;
	private String studentDoB;
	private int studentAge;
	private String studentGender;
	private String studentPassword;
	private String studentContactNumber;
	private String studentAddress;

	public StudentDetailsDTO() {
	}

	public StudentDetailsDTO(int studentId, String studentName, String studentDoB, int studentAge, String studentGender,
			String studentPassword, String studentContactNumber, String studentAddress) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentPassword = studentPassword;
		this.studentDoB = studentDoB;
		this.studentAge = studentAge;
		this.studentGender = studentGender;
		this.studentContactNumber = studentContactNumber;
		this.studentAddress = studentAddress;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentDoB() {
		return studentDoB;
	}

	public void setStudentDoB(String studentDoB) {
		this.studentDoB = studentDoB;
	}

	public int getStudentAge() {
		return studentAge;
	}

	public void setStudentAge(int studentAge) {
		this.studentAge = studentAge;
	}

	public String getStudentGender() {
		return studentGender;
	}

	public void setStudentGender(String studentGender) {
		this.studentGender = studentGender;
	}

	public String getStudentPassword() {
		return studentPassword;
	}

	public void setStudentPassword(String studentPassword) {
		this.studentPassword = studentPassword;
	}

	public String getStudentContactNumber() {
		return studentContactNumber;
	}

	public void setStudentContactNumber(String studentContactNumber) {
		this.studentContactNumber = studentContactNumber;
	}

	public String getStudentAddress() {
		return studentAddress;
	}

	public void setStudentAddress(String studentAddress) {
		this.studentAddress = studentAddress;
	}

	@Override
	public String toString() {
		return "StudentDetailsDTO [studentId=" + studentId + ", studentName=" + studentName + ", studentDoB="
				+ studentDoB + ", studentAge=" + studentAge + ", studentGender=" + studentGender + ", studentPassword="
				+ studentPassword + ", studentContactNumber=" + studentContactNumber + ", studentAddress="
				+ studentAddress + "]";
	}

}
