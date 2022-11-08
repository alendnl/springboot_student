package com.spring.student.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.spring.student.entity.MarkEntity;
import com.spring.student.entity.StudentEntity;

public interface MarkDao extends JpaRepository<MarkEntity, Integer> {

	MarkEntity findByStudentId(int studentId);

//	@Transactional
//	@Modifying(clearAutomatically = true, flushAutomatically = true)
//	@Query(value = "SELECT student_id, :subject FROM mark m", nativeQuery = true)
//	List<?> getSubjectMarks(String subject);

}
