package com.spring.student.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class StudentEntity {

	@Id
	@Column(name = "student_id")
	private int studentId;

	@Column(name = "student_name")
	private String studentName;

	@Column(name = "student_dob")
	private String studentDoB;

	@Column(name = "student_age")
	private int studentAge;

	@Column(name = "student_gender")
	private String studentGender;

	public StudentEntity() {
	}

	public StudentEntity(int studentId, String studentName, String studentDoB, int studentAge, String studentGender) {
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
	public String toString() {
		return "StudentEntity [studentId=" + studentId + ", studentName=" + studentName + ", studentDoB=" + studentDoB
				+ ", studentAge=" + studentAge + ", studentGender=" + studentGender + "]";
	}

}
