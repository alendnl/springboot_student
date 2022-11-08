package com.spring.student.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mark")
public class MarkEntity {

	@Id
	@Column(name = "student_id")
	private int studentId;

	@Column(name = "maths")
	private int maths;

	@Column(name = "computer")
	private int computer;

	@Column(name = "language")
	private int language;

	@Column(name = "percentage")
	private int percentage;

	public MarkEntity() {
	}

	public MarkEntity(int studentId, int maths, int computer, int language, int percentage) {
		super();
		this.studentId = studentId;
		this.maths = maths;
		this.computer = computer;
		this.language = language;
		this.percentage = percentage;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public int getMaths() {
		return maths;
	}

	public void setMaths(int maths) {
		this.maths = maths;
	}

	public int getComputer() {
		return computer;
	}

	public void setComputer(int computer) {
		this.computer = computer;
	}

	public int getLanguage() {
		return language;
	}

	public void setLanguage(int language) {
		this.language = language;
	}

	public int getPercentage() {
		return percentage;
	}

	public void setPercentage(int percentage) {
		this.percentage = percentage;
	}

	@Override
	public String toString() {
		return "MarkEntity [studentId=" + studentId + ", maths=" + maths + ", computer=" + computer + ", language="
				+ language + ", percentage=" + percentage + "]";
	}

}
