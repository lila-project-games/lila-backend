package backend.lilaproject.controllers;

import backend.lilaproject.models.Student;
import backend.lilaproject.services.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.HashMap;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class StudentController {

    @Autowired
    private StudentServices studentServices;

    @PostMapping("/students")
    public ResponseEntity<Map<String, Object>> createStudent(@RequestBody Student student) {
        Logger logger = Logger.getLogger("MyLogger");
        Map<String, Object> response = new HashMap<>();
        try {
            logger.info("Received Student object: " + student.toString());
            Student studentCreated = studentServices.save(student);
            response.put("success", true);
            response.put("message", "Student created successfully");
            response.put("data", studentCreated);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (Exception e) {
            response.put("success", false);
            response.put("error", "Internal Server Error");
            response.put("message", "An error occurred while processing the request. Error: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<Map<String, Object>> getStudentById(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        try {
            Optional<Student> student = studentServices.getById(id);
            if (student.isPresent()) {
                response.put("success", true);
                response.put("data", student.get());
                return ResponseEntity.status(HttpStatus.OK).body(response);
            } else {
                response.put("success", false);
                response.put("error", "Not Found");
                response.put("message", "Student with ID " + id + " not found.");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
            }
        } catch (Exception e) {
            response.put("success", false);
            response.put("error", "Internal Server Error");
            response.put("message", "An error occurred while processing the request.");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @GetMapping("/students")
    public ResponseEntity<Map<String, Object>> getAllStudents() {
        Map<String, Object> response = new HashMap<>();
        try {
            List<Student> students = studentServices.getAll();
            response.put("success", true);
            response.put("data", students);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            response.put("success", false);
            response.put("error", "Internal Server Error");
            response.put("message", "An error occurred while processing the request.");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @GetMapping("/students/by/school/{id}")
    public ResponseEntity<Map<String, Object>> getStudentsBySchoolId(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();

        List<Student> students = studentServices.getStudentsBySchoolId(id);

        if (students.isEmpty()) {
            response.put("success", false);
            response.put("error", "Not Found");
            response.put("message", "No students found for the specified school ID.");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        } else {
            response.put("success", true);
            response.put("message", "Students retrieved successfully");
            response.put("data", students);
            return ResponseEntity.ok(response);
        }
    }

    @PutMapping("/students")
    public ResponseEntity<Map<String, Object>> updateStudent(@RequestBody Student updatedStudent) {
        Map<String, Object> response = new HashMap<>();
        try {
            Student result = studentServices.update(updatedStudent);
            if (result != null) {
                response.put("success", true);
                response.put("message", "Student updated successfully");
                response.put("data", result);
                return ResponseEntity.status(HttpStatus.OK).body(response);
            } else {
                response.put("success", false);
                response.put("error", "Not Found");
                response.put("message", "Student not updated: Record with ID " + updatedStudent.getId() + " does not exist");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
            }
        } catch (Exception e) {
            response.put("success", false);
            response.put("error", e.getMessage());
            response.put("message", "An error occurred while processing the request.");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity<Map<String, Object>> deleteStudent(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        try {
            studentServices.delete(id);
            response.put("success", true);
            response.put("message", "Deleted student with ID: " + id);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            response.put("success", false);
            response.put("error", "Internal Server Error");
            response.put("message", "An error occurred while processing the request.");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
}
