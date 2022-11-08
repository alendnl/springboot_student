package com.spring.student.constants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.lang.String;

//@PropertySource("classpath:message.properties")
public enum MessageConstants {

	STUDENT_ALREADY_EXIST("student.already.exist"), 
	STUDENT_CREATED("student.created"),
	STUDENT_UPDATED("student.updated"),
	STUDENT_DELETED("student.deleted"),
	STUDENT_NOT_FOUND("student.not.found"), 
	
	MARK_ALREADY_EXIST("mark.already.exist"), 
	MARK_CREATED("mark.created"),
	MARK_UPDATED("mark.updated"),
	MARK_DELETED("mark.deleted"),
	MARK_NOT_FOUND("mark.not.found");

//	@Autowired
//	private Environment environment;

	private final String type;

	private MessageConstants(String type) {
		this.type = type;
	}

	public String toPropertyString() {
		return this.type;
//		return environment.getProperty(this.type.toString());
	}

	@Override
	public String toString() {
		return this.type;
	}
}
