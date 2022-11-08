package com.spring.student.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.spring.student.constants.MessageConstants;
import com.spring.student.dao.MarkDao;
import com.spring.student.dao.StudentDao;
import com.spring.student.dto.DisplaySubjectMarksDTO;
import com.spring.student.dto.MarkDTO;
import com.spring.student.dto.StudentDTO;
import com.spring.student.entity.MarkEntity;
import com.spring.student.exception.MarkException;
import com.spring.student.exception.StudentException;

@Service
@PropertySource("classpath:message.properties")
public class MarkServiceImpl implements MarkService {

	@Autowired
	private ModelMapper mapper;
	@Autowired
	private StudentDao studentDao;
	@Autowired
	private MarkDao markDao;
	@Autowired
	private StudentService studentService;
	@Autowired
	private Environment environment;

	@Override
	public String createMark(MarkDTO markDTO) throws MarkException, StudentException {
		if (!studentDao.findById(markDTO.getStudentId()).isPresent())
			throw new StudentException(environment.getProperty(MessageConstants.STUDENT_NOT_FOUND.toString()));
		if (markDao.findById(markDTO.getStudentId()).isPresent())
			throw new MarkException(environment.getProperty(MessageConstants.MARK_ALREADY_EXIST.toString()));
		markDTO.setPercentage((markDTO.getMaths() + markDTO.getComputer() + markDTO.getLanguage()) / 3);
		MarkEntity markEntity = mapper.map(markDTO, MarkEntity.class);
		markDao.save(markEntity);
		return environment.getProperty(MessageConstants.MARK_CREATED.toString());
	}

	@Override
	public MarkDTO getMark(int id) throws MarkException, StudentException {
		if (!studentDao.findById(id).isPresent())
			throw new StudentException(environment.getProperty(MessageConstants.STUDENT_NOT_FOUND.toString()));
		MarkEntity markEntity = markDao.findByStudentId(id);
		if (markEntity == null) {
			throw new MarkException(environment.getProperty(MessageConstants.MARK_NOT_FOUND.toString()));
		}
		MarkDTO markDTO = mapper.map(markEntity, MarkDTO.class);
		return markDTO;
	}

	@Override
	public List<DisplaySubjectMarksDTO> getSubjectMarks(String subject) throws StudentException {
		List<MarkDTO> allMarks = mapper.map(markDao.findAll(), new TypeToken<List<MarkDTO>>() {
		}.getType());
		List<String> studentNames = studentService.getAllStudentsName();
		List<DisplaySubjectMarksDTO> response = new ArrayList<>();
		for (int i = 0; i < allMarks.size(); i++) {
			response.add(new DisplaySubjectMarksDTO(allMarks.get(i).getStudentId(), studentNames.get(i),
					("maths".equalsIgnoreCase(subject)) ? allMarks.get(i).getMaths()
							: ("computer".equalsIgnoreCase(subject)) ? (allMarks.get(i).getComputer())
									: allMarks.get(i).getLanguage()));
		}
		return response;
	}

	@Override
	public String updateMark(MarkDTO markDTO) throws MarkException, StudentException {
		if (!studentDao.findById(markDTO.getStudentId()).isPresent())
			throw new StudentException(environment.getProperty(MessageConstants.STUDENT_NOT_FOUND.toString()));

		MarkEntity markEntity = markDao.findByStudentId(markDTO.getStudentId());
		if (markEntity != null) {
			if (markDTO.getMaths() != 0) {
				markEntity.setMaths(markDTO.getMaths());
			}
			if (markDTO.getComputer() != 0) {
				markEntity.setComputer(markDTO.getComputer());
			}
			if (markDTO.getLanguage() != 0) {
				markEntity.setLanguage(markDTO.getLanguage());
			}
			markEntity.setPercentage((markEntity.getMaths() + markEntity.getComputer() + markEntity.getLanguage()) / 3);
			markDao.save(markEntity);
			return environment.getProperty(MessageConstants.MARK_UPDATED.toString());
		}
		throw new MarkException(environment.getProperty(MessageConstants.MARK_NOT_FOUND.toString()));
	}

	@Override
	public String deleteMark(int id) throws MarkException, StudentException {
		if (!studentDao.findById(id).isPresent())
			throw new StudentException(environment.getProperty(MessageConstants.STUDENT_NOT_FOUND.toString()));
		if (!markDao.findById(id).isPresent())
			throw new MarkException(environment.getProperty(MessageConstants.MARK_NOT_FOUND.toString()));

		markDao.deleteById(id);
		return environment.getProperty(MessageConstants.MARK_DELETED.toString());
	}

}
