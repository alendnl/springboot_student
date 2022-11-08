package com.spring.student.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.student.dto.StudentDTO;
import com.spring.student.exception.StudentException;
import com.spring.student.exception.ValidationException;
import com.spring.student.pojo.LoginResponse;
import com.spring.student.pojo.LoginObject;
import com.spring.student.service.StudentService;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/student")
@Validated
public class StudentController {

	@Autowired
	private StudentService studentService;

	@PostMapping("/create")
	public ResponseEntity<?> createStudent(@Valid @RequestBody StudentDTO studentDTO, Errors errors)
			throws StudentException, ValidationException {
		if (errors.hasErrors()) {
			String response = errors.getAllErrors().stream().map(ObjectError::getDefaultMessage)
					.collect(Collectors.joining(",\n"));
			throw new ValidationException(response);
		}

		String response = studentService.createStudent(studentDTO);
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}

	@PostMapping("/login")
	public ResponseEntity<?> loginStudent(@RequestBody LoginObject loginObject) throws StudentException {
//		System.out.println("123");
//		System.out.println(loginObject.getName() +" "+ loginObject.getPassword());

		Boolean response = studentService.loginStudent(loginObject);
		return new ResponseEntity<LoginResponse>(new LoginResponse(response), HttpStatus.OK);
	}

	@GetMapping("/byId/{id}")
	public ResponseEntity<?> getStudentById(@PathVariable("id") int id) throws StudentException {
		StudentDTO studentDTO = studentService.getStudentById(id);
		return new ResponseEntity<StudentDTO>(studentDTO, HttpStatus.OK);
	}

	@GetMapping("/byName/{name}")
	public ResponseEntity<?> getStudentByName(@PathVariable("name") String name) throws StudentException {
		List<StudentDTO> studentsDTOs = studentService.getStudentByName(name);
		return new ResponseEntity<List<StudentDTO>>(studentsDTOs, HttpStatus.OK);
	}

	@GetMapping("/byDoB/{dob}")
	public ResponseEntity<?> getStudentByDoB(@PathVariable("dob") String dob) throws StudentException {
		List<StudentDTO> studentsDTOs = studentService.getStudentByDoB(dob);
		return new ResponseEntity<List<StudentDTO>>(studentsDTOs, HttpStatus.OK);
	}

	@GetMapping("/byAge/{age}")
	public ResponseEntity<?> getStudentByAge(@PathVariable("age") int age) throws StudentException {
		List<StudentDTO> studentsDTOs = studentService.getStudentByAge(age);
		return new ResponseEntity<List<StudentDTO>>(studentsDTOs, HttpStatus.OK);
	}

	@GetMapping("/byGender/{gender}")
	public ResponseEntity<?> getStudentByGender(@PathVariable("gender") String gender) throws StudentException {
		List<StudentDTO> studentsDTOs = studentService.getStudentByGender(gender);
		return new ResponseEntity<List<StudentDTO>>(studentsDTOs, HttpStatus.OK);
	}

	@GetMapping("/filter")
	public ResponseEntity<?> getStudentByFilter(@RequestParam("name") Optional<String> name,
			@RequestParam("dob") Optional<String> dob, @RequestParam("age") Optional<Integer> age,
			@RequestParam("gender") Optional<String> gender) throws StudentException {
		List<StudentDTO> studentsDTOs = studentService.getStudentByFilter(name.orElseGet(() -> ""),
				dob.orElseGet(() -> ""), age.orElseGet(() -> 0), gender.orElseGet(() -> ""));
		return new ResponseEntity<List<StudentDTO>>(studentsDTOs, HttpStatus.OK);
	}

	@GetMapping("/allStudents")
	public ResponseEntity<?> getAllStudents() throws StudentException {
		List<StudentDTO> studentsDTOs = studentService.getAllStudents();
		return new ResponseEntity<List<StudentDTO>>(studentsDTOs, HttpStatus.OK);
	}

	@PutMapping("update")
	public ResponseEntity<?> updateStudent(@RequestBody StudentDTO studentDTO) throws StudentException {
		String response = studentService.updateStudent(studentDTO);
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable("id") int id) throws StudentException {
		String response = studentService.deleteStudent(id);
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}

}
