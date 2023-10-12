package backend.lilaproject.services;

import backend.lilaproject.models.Student;
import backend.lilaproject.repositories.JpaStudentRepository;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.mockito.Mock;
import org.mockito.InjectMocks;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.mockito.Mockito.verify;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class StudentServicesTest {

    @InjectMocks
    private StudentServices studentServices;
    @Mock
    private JpaStudentRepository jpaStudentRepository;

    @Test
    void save() {
        Student student = new Student();
        student.setStudentName("Juanito");

        when(jpaStudentRepository.save(student)).thenReturn(student);

        Student savedStudent = studentServices.save(student);

        assertNotNull(savedStudent);
        assertEquals(student, savedStudent);

    }


    @Test
    void getById() {
        Long studentId = 1L;
        Student student = new Student();
        student.setStudentName("Juanito");
        student.setId(studentId);

        when(jpaStudentRepository.findById(studentId)).thenReturn(Optional.of(student));

        Optional<Student> optionalStudent = studentServices.getById(studentId);

        assertTrue(optionalStudent.isPresent());

        Student retrievedStudent = optionalStudent.get();

        assertNotNull(retrievedStudent);
        assertEquals(studentId, retrievedStudent.getId());
        assertEquals("Juanito", retrievedStudent.getStudentName());

    }

    @Test
    void getAll() {
        List<Student> students = new ArrayList<>();
        Student student1 = new Student();
        student1.setStudentName("Maria");
        student1.setId(1L);
        students.add(student1);

        when(jpaStudentRepository.findAll()).thenReturn(students);

        List<Student> retrievedStudents = studentServices.getAll();

        assertNotNull(retrievedStudents);
        assertEquals(students.size(), retrievedStudents.size());
    }

    @Test
    void delete() {
        Long studentId = 1L;

        studentServices.delete(studentId);
        verify(jpaStudentRepository).deleteById(studentId);

    }
    @Test
    void updateStudent() {
        Long studentId = 1L;
        String updatedName = "UpdatedName";

        Student updatedStudent = new Student();
        updatedStudent.setId(studentId);
        updatedStudent.setStudentName(updatedName);

        when(jpaStudentRepository.existsById(studentId)).thenReturn(true);

        when(jpaStudentRepository.save(updatedStudent)).thenReturn(updatedStudent);

        Student result = studentServices.update(updatedStudent);

        assertEquals(updatedName, result.getStudentName());
    }
}