package com.spring.student.service;

import java.util.Arrays;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.spring.student.constants.MessageConstants;
import com.spring.student.dao.StudentDao;
import com.spring.student.dto.StudentDTO;
import com.spring.student.entity.StudentEntity;
import com.spring.student.exception.StudentException;
import com.spring.student.pojo.LoginObject;

@Service
@PropertySource("classpath:message.properties")
public class StudentServiceImpl implements StudentService {

	@Autowired
	private ModelMapper mapper;
	@Autowired
	private StudentDao studentDao;
	@Autowired
	private CalculateService calculatService;
	@Autowired
	private Environment environment;

	@Override
	public String createStudent(StudentDTO studentDTO) throws StudentException {
		// Check Id exist
		StudentEntity tempEntity = studentDao.findByStudentId(studentDTO.getStudentId());
		if (tempEntity == null) {
			// Age Calculation
			if (studentDTO.getStudentAge() == 0) {
				int age = calculatService.calculateAge(studentDTO.getStudentDoB());
				studentDTO.setStudentAge(age);
			} else {
				// check whether the given age is correct or not
				int age = calculatService.calculateAge(studentDTO.getStudentDoB());
				if (age != studentDTO.getStudentAge()) {
					// Error response - given age is wrong
				}
			}
			StudentEntity studentEntity = mapper.map(studentDTO, StudentEntity.class);
			studentDao.save(studentEntity);
			return environment.getProperty(MessageConstants.STUDENT_CREATED.toString());
		}
		throw new StudentException(environment.getProperty(MessageConstants.STUDENT_ALREADY_EXIST.toString()));
	}

	@Override
	public Boolean loginStudent(LoginObject loginObject) throws StudentException {
		// Check Id exist
		List<StudentEntity> tempEntities = studentDao.findByStudentName(loginObject.getName());
		if (tempEntities.size() > 0) {
			return true;
		}
		return false;
	}

	@Override
	public StudentDTO getStudentById(int id) throws StudentException {
		StudentEntity studentEntity = studentDao.findByStudentId(id);
		if (studentEntity != null) {
			StudentDTO studentDTO = mapper.map(studentEntity, StudentDTO.class);
			return studentDTO;
		}
		throw new StudentException(environment.getProperty(MessageConstants.STUDENT_NOT_FOUND.toString()));
	}

	@Override
	public List<StudentDTO> getStudentByName(String name) throws StudentException {
		List<StudentEntity> studentEntities = studentDao.findByStudentName(name);
		if (studentEntities != null) {
			List<StudentDTO> studentsDTOs = mapper.map(studentEntities, new TypeToken<List<StudentDTO>>() {
			}.getType());
			return studentsDTOs;
		}
		throw new StudentException(environment.getProperty(MessageConstants.STUDENT_NOT_FOUND.toString()));
	}

	@Override
	public List<StudentDTO> getStudentByDoB(String dob) throws StudentException {
		List<StudentEntity> studentEntities = studentDao.findByStudentDoB(dob);
		if (studentEntities != null) {
			List<StudentDTO> studentsDTOs = mapper.map(studentEntities, new TypeToken<List<StudentDTO>>() {
			}.getType());
			return studentsDTOs;
		}
		throw new StudentException(environment.getProperty(MessageConstants.STUDENT_NOT_FOUND.toString()));
	}

	@Override
	public List<StudentDTO> getStudentByAge(int age) throws StudentException {
		List<StudentEntity> studentEntities = studentDao.findByStudentAge(age);
		if (studentEntities != null) {
			List<StudentDTO> studentsDTOs = mapper.map(studentEntities, new TypeToken<List<StudentDTO>>() {
			}.getType());
			return studentsDTOs;
		}
		throw new StudentException(environment.getProperty(MessageConstants.STUDENT_NOT_FOUND.toString()));
	}

	@Override
	public List<StudentDTO> getStudentByGender(String gender) throws StudentException {
		List<StudentEntity> studentEntities = studentDao.findByStudentGender(gender);
		if (studentEntities != null) {
			List<StudentDTO> studentsDTOs = mapper.map(studentEntities, new TypeToken<List<StudentDTO>>() {
			}.getType());
			return studentsDTOs;
		}
		throw new StudentException(environment.getProperty(MessageConstants.STUDENT_NOT_FOUND.toString()));
	}

	@Override
	public List<StudentDTO> getStudentByFilter(String name, String dob, int age, String gender)
			throws StudentException {
		List<StudentEntity> studentEntities = studentDao.findByStudentFilter(name, dob, age, gender);
		if (studentEntities != null) {
			List<StudentDTO> studentsDTOs = mapper.map(studentEntities, new TypeToken<List<StudentDTO>>() {
			}.getType());
			return studentsDTOs;
		}
		throw new StudentException(environment.getProperty(MessageConstants.STUDENT_NOT_FOUND.toString()));
	}

	@Override
	public List<StudentDTO> getAllStudents() throws StudentException {
		List<StudentEntity> studentsEntities = studentDao.findAll();
		if (studentsEntities != null) {
			List<StudentDTO> studentsDTOs = Arrays.asList(mapper.map(studentsEntities, StudentDTO[].class));
			return studentsDTOs;
		}
		throw new StudentException(environment.getProperty(MessageConstants.STUDENT_NOT_FOUND.toString()));
	}

	@Override
	public List<String> getAllStudentsName() {
		List<String> studentNames = studentDao.getAllStudentsName();
		return studentNames;
	}

	@Override
	public String updateStudent(StudentDTO studentDTO) throws StudentException {
		StudentEntity studentEntity = studentDao.findByStudentId(studentDTO.getStudentId());
		if (studentEntity != null) {
			if (!studentDTO.getStudentName().isEmpty()) {
				studentEntity.setStudentName(studentDTO.getStudentName());
			}
			if (!studentDTO.getStudentDoB().isEmpty()) {
				studentEntity.setStudentDoB(studentDTO.getStudentDoB());
			}
			studentEntity.setStudentAge(calculatService.calculateAge(studentDTO.getStudentDoB()));
//			if (studentDTO.getStudentAge() != 0) {
//				// check whether the given age is correct or not
//				studentEntity.setStudentAge(studentDTO.getStudentAge());
//			}
			if (!studentDTO.getStudentGender().isEmpty()) {
				studentEntity.setStudentGender(studentDTO.getStudentGender());
			}
			studentDao.save(studentEntity);
			return environment.getProperty(MessageConstants.STUDENT_UPDATED.toString());
		}
		throw new StudentException(environment.getProperty(MessageConstants.STUDENT_NOT_FOUND.toString()));
	}

	@Override
	public String deleteStudent(int id) throws StudentException {
		StudentEntity studentEntity = studentDao.findByStudentId(id);
		if (studentEntity != null) {
			studentDao.deleteById(id);
			return environment.getProperty(MessageConstants.STUDENT_DELETED.toString());
		}
		throw new StudentException(environment.getProperty(MessageConstants.STUDENT_NOT_FOUND.toString()));
	}

}
