package com.nidheeshnelson.datafromexceltomysql.controller;

import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.ui.Model;
import javax.servlet.http.HttpSession;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class StudentControllerTest {

    @Test
    public void testExcelUpload() throws Exception {
        // Create a mock MultipartFile
        MockMultipartFile mockFile = new MockMultipartFile(
                "file",
                "test.xlsx",
                "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet",
                "testdata".getBytes()
        );

        // Create a mock HttpSession
        HttpSession mockSession = new MockHttpSession();

        // Create a mock Model
        Model mockModel = mock(Model.class);

        // Mock the behavior of studentService.getJSONfromExcelSheet(file)
        String expectedJson = "mocked json data";
        StudentService studentService = mock(StudentService.class);
        when(studentService.getJSONfromExcelSheet(mockFile)).thenReturn(expectedJson);

        // Create an instance of StudentController and inject the mock StudentService
        StudentController studentController = new StudentController(studentService);

        // Perform the excelUpload method and verify the result
        String result = studentController.excelUpload(mockFile, mockSession, mockModel);
        assertEquals("redirect:/redirection1", result);

        // Verify that the session attribute "jsonexcel" is set with the expected JSON data
        assertEquals(expectedJson, mockSession.getAttribute("jsonexcel"));

        // Verify that no error occurred by checking that the model does not contain "error"
        verifyZeroInteractions(mockModel);
    }
}