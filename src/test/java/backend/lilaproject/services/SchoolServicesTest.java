package backend.lilaproject.services;

import backend.lilaproject.models.School;
import backend.lilaproject.repositories.JpaSchoolRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.junit.jupiter.api.extension.ExtendWith;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest

@ExtendWith({SpringExtension.class, MockitoExtension.class})
class SchoolServicesTest {


    @InjectMocks
    private SchoolServices schoolServices;

    @Mock
    private JpaSchoolRepository schoolRepository;

    @Test
    void saveSchoolTest() {
        School schoolToSave = new School();
        schoolToSave.setId(1L);
        schoolToSave.setSchoolName("Escuela");

        Mockito.when(schoolRepository.save(Mockito.any(School.class))).thenReturn(schoolToSave);

        School savedSchool = schoolServices.save(schoolToSave);

        assertNotNull(savedSchool);
        assertNotNull(savedSchool.getId());
    }
    @Test
    void getById() {
        School school = new School();
        school.setId(1L);
        school.setSchoolName("Escuela");

        Mockito.when(schoolRepository.findById(1L)).thenReturn(Optional.of(school));
        Optional<School> retrievedSchool = schoolServices.getById(1L);
        assertNotNull(retrievedSchool);

        if (retrievedSchool.isPresent()) {
            assertEquals(1L,retrievedSchool.get().getId());
        }
    }
    @Test
    void getAll() {
        List<School> schools = new ArrayList<>();

        School school1 = new School();
        school1.setId(1L);
        school1.setSchoolName("Escuela 1");

        School school2 = new School();
        school2.setId(2L);
        school2.setSchoolName("Escuela 2");
        schools.add(school2);

        Mockito.when(schoolRepository.findAll()).thenReturn(schools);

        List<School> retrievedSchools = schoolServices.getAll();

        assertNotNull(retrievedSchools);
        assertEquals(1, retrievedSchools.size());

    }
    @Test
    void delete() {
        School schoolToDelete = new School();
        schoolToDelete.setId(1L);

        Mockito.doNothing().when(schoolRepository).deleteById(schoolToDelete.getId());

        schoolServices.delete(schoolToDelete.getId());

        Mockito.verify(schoolRepository, Mockito.times(1)).deleteById(schoolToDelete.getId());
    }
    @Test
    void update() {
        School schoolToUpdate = new School();
        schoolToUpdate.setId(1L);
        schoolToUpdate.setSchoolName("Nueva escuela");

        Mockito.when(schoolRepository.existsById(schoolToUpdate.getId())).thenReturn(true);
        Mockito.when(schoolRepository.save(schoolToUpdate)).thenReturn(schoolToUpdate);

        String result = schoolServices.update(schoolToUpdate);

        Mockito.verify(schoolRepository, Mockito.times(1)).existsById(schoolToUpdate.getId());
        Mockito.verify(schoolRepository, Mockito.times(1)).save(schoolToUpdate);

        assertEquals("School updated: Nueva escuela", result);

    }
}









