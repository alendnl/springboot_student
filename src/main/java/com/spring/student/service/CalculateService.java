package com.spring.student.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Service;

@Service
public class CalculateService {
	
	public int calculateAge(String dob) {
		// LocalDate Conversion
		Date localDate = new Date();
		SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
		String localDateStr = dateFormatter.format(localDate);
		int localDateDay = Integer.parseInt(localDateStr.split("/")[0]);
		int localDateMonth = Integer.parseInt(localDateStr.split("/")[1]);
		int localDateYear = Integer.parseInt(localDateStr.split("/")[2]);
		// StudentDate Conversion
		int dobDay = Integer.parseInt(dob.split("-")[0]);
		int dobMonth = Integer.parseInt(dob.split("-")[1]);
		int dobYear = Integer.parseInt(dob.split("-")[2]);
		// Age Calculation
		int studentAge = localDateYear - dobYear - 1;
		if ((localDateMonth == dobMonth && localDateDay >= dobDay) || localDateMonth > dobMonth)
			studentAge++;
		return studentAge;
	}

}
