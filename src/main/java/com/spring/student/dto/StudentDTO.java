package com.spring.student.dto;

import java.util.Objects;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class StudentDTO {

	@Digits(integer = 5, fraction = 0, message = "Student Id should be upto 5 digit")
	private int studentId;

	@NotNull(message = "Student Name should not be null")
	@Pattern(regexp = "[A-Za-z ]{4,25}", message = "Student Name does not match the pattern")
	private String studentName;

	@NotNull(message = "Student DoB should not be null")
	@Pattern(regexp = "[0-9- ]{10}", message = "Student DoB does not match the pattern")
	private String studentDoB;

	@Digits(integer = 2, fraction = 0, message = "Student age should be upto 2 digit")
	private int studentAge;

	@NotNull(message = "Student Gender should not be null")
	@Pattern(regexp = "[MF]{1}", message = "Student Gender does not match the pattern")
	private String studentGender;

	public StudentDTO() {
	}

	public StudentDTO(int studentId, String studentName, String studentDoB, int studentAge, String studentGender) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentDoB = studentDoB;
		this.studentAge = studentAge;
		this.studentGender = studentGender;
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

	@Override
	public int hashCode() {
		return Objects.hash(studentAge, studentDoB, studentGender, studentId, studentName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StudentDTO other = (StudentDTO) obj;
		return studentAge == other.studentAge && Objects.equals(studentDoB, other.studentDoB)
				&& Objects.equals(studentGender, other.studentGender) && studentId == other.studentId
				&& Objects.equals(studentName, other.studentName);
	}

	@Override
	public String toString() {
		return "StudentDTO [studentId=" + studentId + ", studentName=" + studentName + ", studentDoB=" + studentDoB
				+ ", studentAge=" + studentAge + ", studentGender=" + studentGender + "]";
	}

}
