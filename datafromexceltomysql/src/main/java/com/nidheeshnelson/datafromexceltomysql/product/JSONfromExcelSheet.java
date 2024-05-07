package com.nidheeshnelson.datafromexceltomysql.product;

import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nidheeshnelson.datafromexceltomysql.model.StudentModel;
import com.nidheeshnelson.datafromexceltomysql.repository.StudentRepository;
@Component
public class JSONfromExcelSheet implements JSON {

	@Override
	public String produceJSON(List<StudentModel> studentsList, int admissionNumber, String StudentName, StudentRepository studentRepository) 
	{
		ObjectMapper objectMapper = new ObjectMapper();
		String json = null;
		
		try 
		{
			json = objectMapper.writeValueAsString(studentsList);
		} 
		catch (JsonProcessingException e) {
			e.printStackTrace();
			System.out.println(e);
		}
		return json;
	}

}
