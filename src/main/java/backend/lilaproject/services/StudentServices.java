package backend.lilaproject.services;

import backend.lilaproject.models.Student;
import backend.lilaproject.repositories.JpaStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServices {

    @Autowired
    private JpaStudentRepository studentRepository;

    public Student save(Student student) {
        return studentRepository.save(student);
    }

    public Optional<Student> getById(Long id) {
        return studentRepository.findById(id);
    }

    public List<Student> getAll() {
        return (List<Student>) studentRepository.findAll();
    }

    public void delete(Long id) {
        studentRepository.deleteById(id);
    }

    public Student update(Student updatedStudent) {
        try {
            if (studentRepository.existsById(updatedStudent.getId())) {
                return studentRepository.save(updatedStudent);
            } else {
                throw new IllegalArgumentException("Record with ID " + updatedStudent.getId() + " does not exist");
            }
        } catch (Exception e) {
            // Manejo de excepciones en caso de un error
            throw new RuntimeException("Student not updated: " + e.getMessage(), e);
        }
    }
    public List<Student> getStudentsBySchoolId(Long schoolId) {
        return studentRepository.getBySchoolId(schoolId);
    }
}
