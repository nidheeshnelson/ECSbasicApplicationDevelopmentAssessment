package com.nidheeshnelson.datafromexceltomysql.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.nidheeshnelson.datafromexceltomysql.configuration.AppConfig;
import com.nidheeshnelson.datafromexceltomysql.model.StudentModel;
import com.nidheeshnelson.datafromexceltomysql.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	StudentRepository studentRepository;
	@Autowired
	AppConfig appConfig;
	
	public String getJSONfromExcelSheet(MultipartFile excelFile) {
		
		List<StudentModel> studentsList = new ArrayList<>();
		
        try (Workbook workbook = WorkbookFactory.create(excelFile.getInputStream())) 
        {
        	Sheet sheet = workbook.getSheetAt(0);
            int lastRowIndex = sheet.getLastRowNum();
            
            for (int i=1;i <= lastRowIndex;i++) 
            {
                Row row = sheet.getRow(i);
                
                if(row != null) 
                {
                	StudentModel studentModel = new StudentModel();
                	studentModel.setStudentName(row.getCell(0).toString());
                	studentModel.setAdmissionNumber(Integer.parseInt(row.getCell(1).toString().split("\\.")[0]));
                	studentModel.setPhysicsMark(row.getCell(2).getNumericCellValue());
                	studentModel.setChemistryMark(row.getCell(3).getNumericCellValue());
                	studentModel.setMathsMark(row.getCell(4).getNumericCellValue());
             
                	studentsList.add(studentModel);
                	studentRepository.save(studentModel);
                }
            }
            System.out.println(studentsList);
        }
        catch (Exception e) 
        {
			e.printStackTrace();
		}
        
        return appConfig.ExcelSheetFactoryBean().createJSON().produceJSON(studentsList, 0, null, studentRepository);
	}
	
	public String getJSONfromDataBase(int admissionNumber) 
	{
		return appConfig.DataBaseFactoryBean().createJSON().produceJSON(null, admissionNumber, null, studentRepository);
	}
	
	public String getJSONfromDataBase(String studentName) 
	{
		return appConfig.DataBaseFactoryBean().createJSON().produceJSON(null, 0, studentName, studentRepository);
	}
}
