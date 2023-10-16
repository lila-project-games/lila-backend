package backend.lilaproject.controllers;

import backend.lilaproject.models.School;
import org.junit.jupiter.api.Test;
import backend.lilaproject.models.Student;
import backend.lilaproject.services.StudentServices;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;
import java.lang.Long;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

@SpringBootTest
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
    void getStudentById() {
        Student testStudent = new Student();
        testStudent.setId(1L);
        testStudent.setStudentName("Santiago Contreras");

        when(studentServices.getById(1L)).thenReturn(Optional.of(testStudent));

        ResponseEntity<Map<String, Object>> responseEntity = studentController.getStudentById(1L);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Student responseStudent = (Student) responseEntity.getBody().get("data");
        assertEquals(testStudent.getId(), responseStudent.getId());
        assertEquals(testStudent.getStudentName(), responseStudent.getStudentName());

        verify(studentServices, times(1)).getById(1L);
    }

    @Test
    void getAllStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1L, "Santiago Contreras", null));
        students.add(new Student(2L, "Maria Castillo", null));

        Mockito.when(studentServices.getAll()).thenReturn(students);

        ResponseEntity<Map<String, Object>> responseEntity = studentController.getAllStudents();

        assertNotNull(responseEntity);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

        Map<String, Object> responseBody = responseEntity.getBody();
        assertNotNull(responseBody);
        assertEquals(true, responseBody.get("success"));
        assertNotNull(responseBody.get("data"));

        List<Student> responseStudents = (List<Student>) responseBody.get("data");
        assertEquals(students.size(), responseStudents.size());
        for (int i = 0; i < students.size(); i++) {
            assertEquals(students.get(i).getId(), responseStudents.get(i).getId());
            assertEquals(students.get(i).getStudentName(), responseStudents.get(i).getStudentName());
        }
    }

    @Test
    void getStudentsBySchoolId() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1L, "Santiago", new School())); // Crea objetos School para asignar a los estudiantes
        students.add(new Student(2L, "Maria", new School())); // Aquí también

        when(studentServices.getAll()).thenReturn(students);

        ResponseEntity<Map<String, Object>> responseEntity = studentController.getAllStudents();

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

        Map<String, Object> responseBody = responseEntity.getBody();
        assertEquals(true, responseBody.get("success"));

        List<Student> retrievedStudents = (List<Student>) responseBody.get("data");
        assertEquals(2, retrievedStudents.size());

        Student student1 = retrievedStudents.get(0);
        assertEquals(1L, student1.getId());
        assertEquals("Santiago", student1.getStudentName());

        Student student2 = retrievedStudents.get(1);
        assertEquals(2L, student2.getId());
        assertEquals("Maria", student2.getStudentName());
    }

    @Test
    void updateStudent() {
        Student updatedStudent = new Student();
        updatedStudent.setId(1L);
        updatedStudent.setStudentName("Updated Name");

        when(studentServices.update(any(Student.class))).thenReturn(updatedStudent);

        ResponseEntity<Map<String, Object>> responseEntity = studentController.updateStudent(updatedStudent);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

        Map<String, Object> responseBody = responseEntity.getBody();
        assertEquals(true, responseBody.get("success"));

        Student updated = (Student) responseBody.get("data");
        assertEquals(updatedStudent.getId(), updated.getId());
        assertEquals(updatedStudent.getStudentName(), updated.getStudentName());
    }

    @Test
    void deleteStudent() {
        Long studentId = 1L;

        ResponseEntity<Map<String, Object>> responseEntity = studentController.deleteStudent(studentId);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

        Map<String, Object> responseBody = responseEntity.getBody();
        assertEquals(true, responseBody.get("success"));

        String message = (String) responseBody.get("message");
        assertEquals("Deleted student with ID: " + studentId, message);
    }
}