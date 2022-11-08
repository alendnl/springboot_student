package com.spring.student.service;

import java.util.List;

import com.spring.student.dto.StudentDTO;
import com.spring.student.exception.StudentException;
import com.spring.student.pojo.LoginObject;

public interface StudentService {

	String createStudent(StudentDTO studentDTO) throws StudentException;
	
	Boolean loginStudent(LoginObject loginObject) throws StudentException;

	StudentDTO getStudentById(int id) throws StudentException;

	List<StudentDTO> getStudentByName(String name) throws StudentException;

	List<StudentDTO> getStudentByDoB(String dob) throws StudentException;

	List<StudentDTO> getStudentByAge(int age) throws StudentException;

	List<StudentDTO> getStudentByGender(String gender) throws StudentException;

	List<StudentDTO> getStudentByFilter(String name, String dob, int age, String gender) throws StudentException;

	List<StudentDTO> getAllStudents() throws StudentException;

	String updateStudent(StudentDTO studentDTO) throws StudentException;

	String deleteStudent(int id) throws StudentException;

	List<String> getAllStudentsName();

}