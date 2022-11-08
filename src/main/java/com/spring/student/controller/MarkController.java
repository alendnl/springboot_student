package com.spring.student.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.student.dto.DisplaySubjectMarksDTO;
import com.spring.student.dto.MarkDTO;
import com.spring.student.exception.MarkException;
import com.spring.student.exception.StudentException;
import com.spring.student.exception.ValidationException;
import com.spring.student.service.MarkService;

@RestController
@RequestMapping("/mark")
@Validated
public class MarkController {

	@Autowired
	private MarkService markService;

	@PostMapping("/create")
	public ResponseEntity<?> createMark(@Valid @RequestBody MarkDTO markDTO, Errors errors)
			throws MarkException, StudentException, ValidationException {
		if (errors.hasErrors()) {
			String response = errors.getAllErrors().stream().map(ObjectError::getDefaultMessage)
					.collect(Collectors.joining(","));
			throw new ValidationException(response);
		}
//		if (!((markDTO.getMaths() >= 0 && markDTO.getMaths() <= 100)
//				&& (markDTO.getComputer() >= 0 && markDTO.getComputer() <= 100)
//				&& (markDTO.getLanguage() >= 0 && markDTO.getLanguage() <= 100))) {
//			throw new ValidationException("Invalid mark");
//		}
		String status = markService.createMark(markDTO);
		return new ResponseEntity<String>(status, HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getMark(@PathVariable("id") int id) throws MarkException, StudentException {
		MarkDTO markDTO = markService.getMark(id);
		return new ResponseEntity<MarkDTO>(markDTO, HttpStatus.FOUND);
	}

	@GetMapping("marks/{subject}")
	public List<DisplaySubjectMarksDTO> getSubjectMarks(@PathVariable("subject") String subject) throws StudentException {
		List<DisplaySubjectMarksDTO> marks = markService.getSubjectMarks(subject);
		return marks;
	}

	@PutMapping("/update")
	public ResponseEntity<?> updateMark(@RequestBody MarkDTO markDTO) throws MarkException, StudentException {
		String response = markService.updateMark(markDTO);
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}

	@DeleteMapping("/delete")
	public ResponseEntity<?> deleteMark(@RequestParam("id") int id) throws MarkException, StudentException {
		String response = markService.deleteMark(id);
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}

}
