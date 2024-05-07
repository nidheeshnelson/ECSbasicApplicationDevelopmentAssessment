package com.nidheeshnelson.datafromexceltomysql.product;

import java.util.List;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nidheeshnelson.datafromexceltomysql.model.StudentModel;
import com.nidheeshnelson.datafromexceltomysql.repository.StudentRepository;
@Component
public class JSONfromDataBase implements JSON 
{
	@Override
	public String produceJSON(List<StudentModel> studentsList, int admissionNumber, String StudentName, StudentRepository studentRepository) 
	{
		StudentModel studentModel = null;
		ObjectMapper objectMapper = new ObjectMapper();
		String json = null;
		if(admissionNumber!=0) 
		{
			studentModel=studentRepository.findByAdmissionNumber(admissionNumber);
			try 
			{
				json = objectMapper.writeValueAsString(studentModel);
			} 
			catch (JsonProcessingException e) {
				e.printStackTrace();
				System.out.println(e);
			}
		}
		else if(!StudentName.equals(null)) {
			List<StudentModel> studentsList1=studentRepository.findByStudentNameContaining(StudentName);
			try 
			{
				json = objectMapper.writeValueAsString(studentsList1);
			} 
			catch (JsonProcessingException e) {
				e.printStackTrace();
				System.out.println(e);
			}
		}
		else 
		{
			studentsList=studentRepository.findAll();
			try 
			{
				json = objectMapper.writeValueAsString(studentsList);
			} 
			catch (JsonProcessingException e) {
				e.printStackTrace();
				System.out.println(e);
			}
		}
		
		return json;
	}
}
