package com.spring.student.service;

import java.util.List;
import com.spring.student.dto.DisplaySubjectMarksDTO;
import com.spring.student.dto.MarkDTO;
import com.spring.student.exception.MarkException;
import com.spring.student.exception.StudentException;

public interface MarkService {

	String createMark(MarkDTO markDTO) throws MarkException, StudentException;

	MarkDTO getMark(int id) throws MarkException, StudentException;

	List<DisplaySubjectMarksDTO> getSubjectMarks(String subject) throws StudentException;

	String updateMark(MarkDTO markDTO) throws MarkException, StudentException;

	String deleteMark(int id) throws MarkException, StudentException;

}