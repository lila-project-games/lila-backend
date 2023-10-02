package backend.lilaproject.controllers;

import backend.lilaproject.models.School;
import backend.lilaproject.services.SchoolServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.HashMap;

@RestController
@RequestMapping("/api/schools")
public class SchoolController {

    @Autowired
    private SchoolServices schoolServices;

    @PostMapping
    public ResponseEntity<Map<String, Object>> createSchool(@RequestBody School school) {
        Map<String, Object> response = new HashMap<>();
        try {
            School schoolCreated = schoolServices.save(school);
            response.put("success", true);
            response.put("message", "School created successfully");
            response.put("data", schoolCreated);
            return ResponseEntity.status(HttpStatus.CREATED).body(response); // 201 Created
        } catch (Exception e) { // If an error occurred, return a JSON with HTTP status 500 INTERNAL SERVER ERROR
            response.put("success", false);
            response.put("error", "Internal Server Error");
            response.put("message", "An error occurred while processing the request.");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response); // 500 Internal Server Error
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getSchoolById(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        try {
            Optional<School> school = schoolServices.getById(id);
            if (school.isPresent()) {
                response.put("success", true);
                response.put("data", school.get());
                return ResponseEntity.status(HttpStatus.OK).body(response); // 200 OK
            } else {
                response.put("success", false);
                response.put("error", "Not Found");
                response.put("message", "School with ID " + id + " not found.");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response); // 404 Not Found
            }
        } catch (Exception e) {
            response.put("success", false);
            response.put("error", "Internal Server Error");
            response.put("message", "An error occurred while processing the request.");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response); // 500 Internal Server Error
        }
    }

    @GetMapping
    public ResponseEntity<Map<String, Object>> getAllSchools() {
        Map<String, Object> response = new HashMap<>();
        try {
            List<School> schools = schoolServices.getAll();
            response.put("success", true);
            response.put("data", schools);
            return ResponseEntity.status(HttpStatus.OK).body(response); // 200 OK
        } catch (Exception e) {
            response.put("success", false);
            response.put("error", "Internal Server Error");
            response.put("message", "An error occurred while processing the request.");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response); // 500 Internal Server Error
        }
    }

    @PutMapping
    public ResponseEntity<Map<String, Object>> updateSchool(@RequestBody School updatedSchool) {
        Map<String, Object> response = new HashMap<>();
        try {
            String result = schoolServices.update(updatedSchool);
            if (result.startsWith("School updated")) {
                response.put("success", true);
                response.put("message", result);
                return ResponseEntity.status(HttpStatus.OK).body(response); // 200 OK
            } else {
                response.put("success", false);
                response.put("error", "Not Found");
                response.put("message", result);
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response); // 404 Not Found
            }
        } catch (Exception e) {
            response.put("success", false);
            response.put("error", "Internal Server Error");
            response.put("message", "An error occurred while processing the request.");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response); // 500 Internal Server Error
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deleteSchool(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        try {
            schoolServices.delete(id);
            response.put("success", true);
            response.put("message", "Deleted school with ID: " + id);
            return ResponseEntity.status(HttpStatus.OK).body(response); // 200 OK
        } catch (Exception e) {
            response.put("success", false);
            response.put("error", "Internal Server Error");
            response.put("message", "An error occurred while processing the request.");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response); // 500 Internal Server Error
        }
    }
}
