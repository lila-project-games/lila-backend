package backend.lilaproject.controllers;

import backend.lilaproject.models.RidingHood;
import backend.lilaproject.services.RidingHoodServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.HashMap;

@RestController
@RequestMapping("/api/ridinghoods")
@CrossOrigin(origins = "*")
public class RidingHoodController {

    @Autowired
    private RidingHoodServices ridingHoodServices;

    @PostMapping
    public ResponseEntity<Map<String, Object>> createRidingHood(@RequestBody RidingHood ridingHood) {
        Map<String, Object> response = new HashMap<>();
        try {
            RidingHood ridingHoodCreated = ridingHoodServices.saveRidingHood(ridingHood);
            response.put("success", true);
            response.put("message", "RidingHood created successfully");
            response.put("data", ridingHoodCreated);
            return ResponseEntity.status(HttpStatus.CREATED).body(response); // 201 Created
        } catch (Exception e) {
            response.put("success", false);
            response.put("error", "Internal Server Error");
            response.put("message", "An error occurred while processing the request.");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response); // 500 Internal Server Error
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getRidingHoodById(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        try {
            Optional<RidingHood> ridingHood = ridingHoodServices.getRidingHoodById(id);
            if (ridingHood.isPresent()) {
                response.put("success", true);
                response.put("data", ridingHood.get());
                return ResponseEntity.status(HttpStatus.OK).body(response); // 200 OK
            } else {
                response.put("success", false);
                response.put("error", "Not Found");
                response.put("message", "RidingHood with ID " + id + " not found.");
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
    public ResponseEntity<Map<String, Object>> getAllRidingHoods() {
        Map<String, Object> response = new HashMap<>();
        try {
            List<RidingHood> ridingHoods = ridingHoodServices.getAllRidingHoods();
            response.put("success", true);
            response.put("data", ridingHoods);
            return ResponseEntity.status(HttpStatus.OK).body(response); // 200 OK
        } catch (Exception e) {
            response.put("success", false);
            response.put("error", "Internal Server Error");
            response.put("message", "An error occurred while processing the request.");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response); // 500 Internal Server Error
        }
    }

    @PutMapping
    public ResponseEntity<Map<String, Object>> updateRidingHood(@RequestBody RidingHood updatedRidingHood) {
        Map<String, Object> response = new HashMap<>();
        try {
            RidingHood result = ridingHoodServices.updateRidingHood(updatedRidingHood);
            if (result != null) {
                response.put("success", true);
                response.put("message", "RidingHood updated successfully");
                response.put("data", result);
                return ResponseEntity.status(HttpStatus.OK).body(response); // 200 OK
            } else {
                response.put("success", false);
                response.put("error", "Not Found");
                response.put("message", "RidingHood not updated: Record with ID " + updatedRidingHood.getId() + " does not exist");
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
    public ResponseEntity<Map<String, Object>> deleteRidingHood(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        try {
            ridingHoodServices.deleteRidingHoodById(id);
            response.put("success", true);
            response.put("message", "Deleted RidingHood with ID: " + id);
            return ResponseEntity.status(HttpStatus.OK).body(response); // 200 OK
        } catch (Exception e) {
            response.put("success", false);
            response.put("error", "Internal Server Error");
            response.put("message", "An error occurred while processing the request.");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response); // 500 Internal Server Error
        }
    }
}
