package backend.lilaproject.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StudentTest {

    @Test
    void getId() {
        Student student = new Student();
        Long expectedId = 12L;
        student.setId(expectedId);
        long actualId = student.getId();
        assertEquals(expectedId, actualId);
    }

    @Test
    void setId() {
        Student student = new Student();
        Long expectedId = 12L;
        student.setId(expectedId);
        Long actualId = student.getId();
        assertEquals(12L, actualId );
    }

    @Test
    void getStudentName() {
        Student student = new Student();
        String expectedStudentName = "Santi";
        student.setStudentName(expectedStudentName);
        String actualStudentName = student.getStudentName();
        assertEquals("Santi", actualStudentName);
    }

    @Test
    void setStudentName() {
        Student student = new Student();
        String expectedStudentName = "Santiago";
        student.setStudentName(expectedStudentName);
        String actualStudentName = student.getStudentName();
        assertEquals("Santiago", actualStudentName);
    }

    @Test
    void getFirstSurname() {
        Student student = new Student();
        String expectedFirstSurname = "Cardenas";
        student.setFirstSurname(expectedFirstSurname);
        String actualFirstSurname = student.getFirstSurname();
        assertEquals("Cardenas", actualFirstSurname);
    }

    @Test
    void setFirstSurname() {
        Student student = new Student();
        String expectedFirstSurname = "Contreras";
        student.setFirstSurname(expectedFirstSurname);
        String actualFirstSurname = student.getFirstSurname();
        assertEquals("Contreras", actualFirstSurname);
    }

    @Test
    void getSecondSurname() {
        Student student = new Student();
        String expectedSecondSurname = "Torres";
        student.setSecondSurname(expectedSecondSurname);
        String actualSecondSurname = student.getSecondSurname();
        assertEquals("Torres", actualSecondSurname);

    }

    @Test
    void setSecondSurname() {
        Student student = new Student();
        String expectedSecondSurname = "Castillo";
        student.setSecondSurname(expectedSecondSurname);
        String actualSecondSurname = student.getSecondSurname();
        assertEquals("Castillo", actualSecondSurname);
    }

    @Test
    void getSchool() {
        Student student = new Student();
        School expedtedSchool = new School();
        student.setSchool(expedtedSchool);
        School actualSchool = student.getSchool();
        assertEquals(expedtedSchool, actualSchool);
    }

    @Test
    void setSchool() {
        Student student = new Student();
        School expectedSchool = new School();
        student.setSchool(expectedSchool);
        School actualSchool = student.getSchool();
        assertEquals(expectedSchool, actualSchool);
    }

    @Test
    void testToString() {
        Student student = new Student();
        student.setId(1L);
        student.setStudentName("Santiago");
        student.setFirstSurname("Contreras");
        student.setSecondSurname("Castillo");


        String expectedToString = "Student{id=1, studentName='Santiago', firstSurname='Contreras', secondSurname='Castillo', school=null}";
        String actualToString = student.toString();

        assertEquals(expectedToString, actualToString);
    }






}