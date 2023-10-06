package backend.lilaproject.models;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SchoolTest {

    @Test
    void GetId() {
        School school = new School();
        Long expectedId = 1L;
        school.setId(expectedId);
        Long actualId = school.getId();
        assertEquals(expectedId, actualId);
    }

    @Test
    void setId() {
        School school = new School();
        Long expectedId = 456L;
        school.setId(expectedId);
        Long actualId = school.getId();
        assertEquals(expectedId, actualId);
    }

    @Test
    void getSchoolName() {
        School school = new School();
        String expectedName = "La Escuelona";
        school.setSchoolName(expectedName);
        String actualName = school.getSchoolName();
        assertEquals(expectedName, actualName);
    }

    @Test
    void setSchoolName() {
        School school = new School();
        String expectedName = "La Escuelita";
        school.setSchoolName(expectedName);
        String actualName = school.getSchoolName();
        assertEquals(expectedName, actualName);

    }
}