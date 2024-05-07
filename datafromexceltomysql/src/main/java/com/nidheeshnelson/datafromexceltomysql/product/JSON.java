package com.nidheeshnelson.datafromexceltomysql.product;

import java.util.List;

import org.springframework.stereotype.Component;

import com.nidheeshnelson.datafromexceltomysql.model.StudentModel;
import com.nidheeshnelson.datafromexceltomysql.repository.StudentRepository;
@Component
public interface JSON 
	{
	public String produceJSON(List<StudentModel> studentsList, int admissionNumber, String StudentName, StudentRepository studentRepository);
	}
