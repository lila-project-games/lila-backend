package backend.lilaproject.controllers;

import org.junit.jupiter.api.Test;
import backend.lilaproject.models.Student;
import backend.lilaproject.models.Student;
import backend.lilaproject.services.StudentServices;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import backend.lilaproject.models.Student;
import backend.lilaproject.services.StudentServices;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import backend.lilaproject.models.Student;
import backend.lilaproject.services.StudentServices;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;


import static org.junit.jupiter.api.Assertions.*;

class StudentControllerTest {
    @InjectMocks
    private StudentController studentController;

    @Mock
    private StudentServices studentServices;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createStudent() {
        Student student = new Student();
        student.setId(1L);
        student.setStudentName("John Doe");
        // Create a sample response
        Student responseStudent = new Student();
        responseStudent.setId(1L);
        responseStudent.setStudentName("John Doe");

        // Mock the service call
        when(studentServices.save(any(Student.class))).thenReturn(responseStudent);

        // Call the controller method
        ResponseEntity<Map<String, Object>> responseEntity = studentController.createStudent(student);

        // Verify the response status code
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());

        Map<String, Object> responseBody = responseEntity.getBody();
        assertNotNull(responseBody);
        assertTrue(responseBody.containsKey("success"));
        assertTrue((Boolean) responseBody.get("success"));
        assertTrue(responseBody.containsKey("message"));
        assertEquals("Student created successfully", responseBody.get("message"));
        assertTrue(responseBody.containsKey("data"));

        // Verify the response student object
        Student createdStudent = (Student) responseBody.get("data");
        assertNotNull(createdStudent);
        assertEquals(student.getId(), createdStudent.getId());
        assertEquals(student.getStudentName(), createdStudent.getStudentName());
    }


    @Test
    void getStudentById() {
    }

    @Test
    void getAllStudents() {
    }

    @Test
    void getStudentsBySchoolId() {
    }

    @Test
    void updateStudent() {
    }

    @Test
    void deleteStudent() {
    }
}