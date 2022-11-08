package com.spring.student.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.spring.student.entity.StudentEntity;

public interface StudentDao extends JpaRepository<StudentEntity, Integer> {

	StudentEntity findByStudentId(int studentId);

	List<StudentEntity> findByStudentName(String name);

	List<StudentEntity> findByStudentDoB(String dob);

	List<StudentEntity> findByStudentAge(int age);

	List<StudentEntity> findByStudentGender(String gender);

	@Transactional
	@Modifying(clearAutomatically = true, flushAutomatically = true)
	@Query(value = "SELECT * FROM student s WHERE s.student_name=:name OR s.student_dob=:dob OR s.student_age=:age OR s.student_gender=:gender", nativeQuery = true)
	List<StudentEntity> findByStudentFilter(String name, String dob, int age, String gender);
	
	@Transactional
	@Modifying(clearAutomatically = true, flushAutomatically = true)
	@Query(value = "SELECT student_name FROM student", nativeQuery = true)
	List<String> getAllStudentsName();

}