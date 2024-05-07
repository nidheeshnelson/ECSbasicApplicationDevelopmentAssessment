package com.nidheeshnelson.datafromexceltomysql;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.nidheeshnelson.datafromexceltomysql.service.StudentService;

@SpringBootTest
class DatafromexceltomysqlApplicationTests {
	@Autowired
	StudentService studentService;
	@Test
    public void testGetJSONfromDataBaseReturnsStringEnterInt() {
		String result = studentService.getJSONfromDataBase(1003); 

        assertNotNull("Returned value is not null", result);
        System.out.println(result);
      
	}
	@Test
	public void testGetJSONfromDataBaseReturnsStringEnterString() {
		String result = studentService.getJSONfromDataBase("Alan"); 

        assertNotNull("Returned value is not null", result);
        System.out.println(result);
      
	}
	
}
