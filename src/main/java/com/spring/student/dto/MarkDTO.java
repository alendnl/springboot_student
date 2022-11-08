package com.spring.student.dto;

import java.util.Objects;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

public class MarkDTO {

	@Digits(integer = 5, fraction = 0, message = "Student Id should be upto 5 digit")
	private int studentId;
	
	@Min(value = 0, message = "Minimum mark is 0")
	@Max(value = 100, message = "Maximum mark is 100")
	private int maths;
	
	@Min(value = 0, message = "Minimum mark is 0")
	@Max(value = 100, message = "Maximum mark is 100")
	private int computer;
	
	@Min(value = 0, message = "Minimum mark is 0")
	@Max(value = 100, message = "Maximum mark is 100")
	private int language;
	
	@Min(value = 0, message = "Minimum mark is 0")
	@Max(value = 100, message = "Maximum mark is 100")
	private int percentage;

	public MarkDTO() {
	}

	public MarkDTO(int studentId, int maths, int computer, int language, int percentage) {
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
	public int hashCode() {
		return Objects.hash(computer, language, maths, percentage, studentId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MarkDTO other = (MarkDTO) obj;
		return computer == other.computer && language == other.language && maths == other.maths
				&& percentage == other.percentage && studentId == other.studentId;
	}

	@Override
	public String toString() {
		return "MarkDTO [studentId=" + studentId + ", maths=" + maths + ", computer=" + computer + ", language="
				+ language + ", percentage=" + percentage + "]";
	}

}
