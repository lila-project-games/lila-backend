package backend.lilaproject.controllers;

import backend.lilaproject.models.School;
import backend.lilaproject.services.SchoolServices;
import org.springframework.http.ResponseEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;import org.springframework.http.ResponseEntity;

import org.springframework.http.HttpStatus;



import java.util.Map;
import java.util.List;
import java.util.Optional;

class SchoolControllerTest {

    @InjectMocks
    private SchoolController schoolController;
    @Mock
    private SchoolServices schoolServices;

    @BeforeEach
    void setUp () {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createSchool() {
        School school = new School();
        school.setId(1L);
        school.setSchoolName("Colegio");

        when(schoolServices.save(any(School.class))).thenReturn(school);

        ResponseEntity<Map<String, Object>> responseEntity = schoolController.createSchool(school);

        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        School createdSchool = (School) responseEntity.getBody().get("data");
        assertEquals(school.getId(), createdSchool.getId());
        assertEquals(school.getSchoolName(), createdSchool.getSchoolName());
    }

    @Test
    void getSchoolById() {
        School school = new School();
        school.setId(1L);
        school.setSchoolName("Colegio Uno");

        when(schoolServices.getById(1L)).thenReturn(Optional.of(school));

        ResponseEntity<Map<String, Object>> responseEntity = schoolController.getSchoolById(1L);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

        assertNotNull(responseEntity.getBody());

        assertTrue((Boolean) responseEntity.getBody().get("success"));

        School retrievedSchool = (School) responseEntity.getBody().get("data");
        assertEquals(school.getId(), retrievedSchool.getId());
        assertEquals(school.getSchoolName(), retrievedSchool.getSchoolName());

        assertFalse(responseEntity.getBody().containsKey("error"));
    }

    @Test
    void getAllSchools() {

        School school1 = new School();
        school1.setId(1L);
        school1.setSchoolName("Colegio Uno");

        School school2 = new School();
        school2.setId(2L);
        school2.setSchoolName("Colegio Dos");

        List<School> schoolList = List.of(school1, school2);
        when(schoolServices.getAll()).thenReturn(schoolList);
        ResponseEntity<Map<String, Object>> responseEntity = schoolController.getAllSchools();

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
        assertTrue((Boolean) responseEntity.getBody().get("success"));

        List<School> retrievedSchools = (List<School>) responseEntity.getBody().get("data");
        assertEquals(schoolList.size(), retrievedSchools.size());
        assertFalse(responseEntity.getBody().containsKey("error"));
    }

    @Test
    void updateSchool() {

        School updatedSchool = new School();
        updatedSchool.setId(1L);
        updatedSchool.setSchoolName("Nueva Escuela");

        when(schoolServices.update(updatedSchool)).thenReturn("School updated successfully");
        ResponseEntity<Map<String, Object>> responseEntity = schoolController.updateSchool(updatedSchool);


        assertEquals(HttpStatus.OK, responseEntity.getStatusCode()); // Debe ser un 200 OK
        assertTrue(responseEntity.getBody().containsKey("success"));
        assertTrue(responseEntity.getBody().containsKey("message"));
        assertTrue((Boolean) responseEntity.getBody().get("success"));
        assertEquals("School updated successfully", responseEntity.getBody().get("message"));
    }




    @Test
    void deleteSchool() {
        Long schoolIdToDelete = 1L;
        ResponseEntity<Map<String, Object>> responseEntity = schoolController.deleteSchool(schoolIdToDelete);

        assertNotNull(responseEntity);

        Object body = responseEntity.getBody();

        assertTrue(body instanceof Map);

        Map<String, Object> responseBody = (Map<String, Object>) body;

        assertTrue(responseBody.containsKey("success"));
        assertTrue((boolean) responseBody.get("success"));

        assertTrue(responseBody.containsKey("message"));
        assertEquals("Deleted school with ID: " + schoolIdToDelete, responseBody.get("message"));
    }
}