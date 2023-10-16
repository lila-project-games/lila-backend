package backend.lilaproject.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RidingHoodTest {

    @Test
    void getId() {
        RidingHood ridingHood = new RidingHood();
        Long expectedId = 12L;
        ridingHood.setId(expectedId);
        Long actualId = ridingHood.getId();
        assertEquals(12,actualId);
    }

    @Test
    void setId() {
        RidingHood ridingHood = new RidingHood();
        Long expectedId = 12L;
        ridingHood.setId(expectedId);
        Long actualId = ridingHood.getId();
        assertEquals(12,actualId);
    }

    @Test
    void getRidingHoodHow() {
        RidingHood ridingHood = new RidingHood();
        String expectedRidingHoodHow = "Caperucita";
        ridingHood.setRidingHoodHow(expectedRidingHoodHow);
        String actualRidingHoodHow = ridingHood.getRidingHoodHow();
        assertEquals("Caperucita", actualRidingHoodHow);
    }

    @Test
    void setRidingHoodHow() {
        RidingHood ridingHood = new RidingHood();
        String expectedRidingHoodHow = "Caperucita";
        ridingHood.setRidingHoodHow(expectedRidingHoodHow);
        String actualRidingHoodHow = ridingHood.getRidingHoodHow();
        assertEquals("Caperucita", actualRidingHoodHow);
    }

    @Test
    void getRidingHoodObj() {
        RidingHood ridingHood = new RidingHood();
        String expectedRidingHoodObj = "Capa Roja";
        ridingHood.setRidingHoodObj(expectedRidingHoodObj);
        String actualRidingHoodObj = ridingHood.getRidingHoodObj();
        assertEquals("Capa Roja", actualRidingHoodObj);
    }

    @Test
    void setRidingHoodObj() {
        RidingHood ridingHood = new RidingHood();
        String expectedRidingHoodObj = "Capa Roja";
        ridingHood.setRidingHoodObj(expectedRidingHoodObj);
        String actualRidingHoodObj = ridingHood.getRidingHoodObj();
        assertEquals("Capa Roja", actualRidingHoodObj);
    }

    @Test
    void getWolfHow() {
        RidingHood ridingHood = new RidingHood();
        String expectedWolfHow = "Whiskers";
        ridingHood.setWolfHow(expectedWolfHow);
        String actualWolfHow = ridingHood.getWolfHow();
        assertEquals("Whiskers",actualWolfHow);
    }

    @Test
    void setWolfHow() {
        RidingHood ridingHood = new RidingHood();
        String expectedWolfHow = "Whiskers";
        ridingHood.setWolfHow(expectedWolfHow);
        String actualWolfHow = ridingHood.getWolfHow();
        assertEquals("Whiskers", actualWolfHow);
    }

    @Test
    void getWolfObj() {
        RidingHood ridingHood = new RidingHood();
        String expectedWolfObj = "Dogtooth";
        ridingHood.setWolfObj(expectedWolfObj);
        String actualWolfObj = ridingHood.getWolfObj();
        assertEquals("Dogtooth",actualWolfObj);
    }

    @Test
    void setWolfObj() {
        RidingHood ridingHood = new RidingHood();
        String expectedWolfObj = "Claws";
        ridingHood.setWolfObj(expectedWolfObj);
        String actualWolfObj = ridingHood.getWolfObj();
        assertEquals("Claws", actualWolfObj);
    }

    @Test
    void getGrannyHow() {
        RidingHood ridingHood = new RidingHood();
        String expectedGrannyHow = "Glasses";
        ridingHood.setGrannyHow(expectedGrannyHow);
        String actualGrannyHow = ridingHood.getGrannyHow();
        assertEquals("Glasses", actualGrannyHow);
    }

    @Test
    void setGrannyHow() {
        RidingHood ridingHood = new RidingHood();
        String expectedGrannyHow = "Glasses";
        ridingHood.setGrannyHow(expectedGrannyHow);
        String actualGrannyHow = ridingHood.getGrannyHow();
        assertEquals("Glasses", actualGrannyHow);
    }

    @Test
    void getGrannyObj() {
        RidingHood ridingHood = new RidingHood();
        String expectedGrannyHow = "Silver Hair";
        ridingHood.setGrannyObj(expectedGrannyHow);
        String actualGrannyObj = ridingHood.getGrannyObj();
        assertEquals("Silver Hair", actualGrannyObj);
    }

    @Test
    void setGrannyObj() {
        RidingHood ridingHood = new RidingHood();
        String expectedGrannyObj = "Silver Hair";
        ridingHood.setGrannyObj(expectedGrannyObj);
        String actualGrannyObj = ridingHood.getGrannyObj();
        assertEquals("Silver Hair", actualGrannyObj);
    }

    @Test
    void getHunterHow() {
        RidingHood ridingHood = new RidingHood();
        String expectedHunterHow = "Boots";
        ridingHood.setHunterHow(expectedHunterHow);
        String actualHunterHow = ridingHood.getHunterHow();
        assertEquals("Boots", actualHunterHow);
    }

    @Test
    void setHunterHow() {
        RidingHood ridingHood = new RidingHood();
        String expectedHunterHow = "Boots";
        ridingHood.setHunterHow(expectedHunterHow);
        String actualHunterHow = ridingHood.getHunterHow();
        assertEquals("Boots", actualHunterHow);
    }

    @Test
    void getHunterObj() {
        RidingHood ridingHood = new RidingHood();
        String expectedHunterObj = "Shotgun";
        ridingHood.setHunterObj(expectedHunterObj);
        String actualHunterObj = ridingHood.getHunterObj();
        assertEquals("Shotgun", actualHunterObj);
    }

    @Test
    void setHunterObj() {
        RidingHood ridingHood = new RidingHood();
        String expectedHunterObj = "Shotgun";
        ridingHood.setHunterObj(expectedHunterObj);
        String actualHunterObj = ridingHood.getHunterObj();
        assertEquals("Shotgun", actualHunterObj);
    }

    @Test
    void getDrawRidingHood() {
        RidingHood ridingHood = new RidingHood();
        String expectedDrawRidingHood = "My Draw";
        ridingHood.setDrawRidingHood(expectedDrawRidingHood);
        String actualDrawRidingHood = ridingHood.getDrawRidingHood();
        assertEquals("My Draw", actualDrawRidingHood);
    }

    @Test
    void setDrawRidingHood() {
        RidingHood ridingHood = new RidingHood();
        String expectedDrawRidingHood = "My Draw";
        ridingHood.setDrawRidingHood(expectedDrawRidingHood);
        String actualDrawRidingHood = ridingHood.getDrawRidingHood();
        assertEquals("My Draw", actualDrawRidingHood);
    }

    @Test
    void getStory() {
        RidingHood ridingHood = new RidingHood();
        String expectedStory = "My Story";
        ridingHood.setStory(expectedStory);
        String actualStory = ridingHood.getStory();
        assertEquals("My Story", actualStory);
    }

    @Test
    void setStory() {
        RidingHood ridingHood = new RidingHood();
        String expectedStory = "Once upon a time...";
        ridingHood.setStory(expectedStory);
        String actualStory = ridingHood.getStory();
        assertEquals("Once upon a time...", actualStory);

    }

    @Test
    void getStudent() {
        RidingHood ridingHood = new RidingHood();

        Student expectedStudent = new Student();
        expectedStudent.setStudentName("Santiago Cardenas Torres");

        ridingHood.setStudent(expectedStudent);
        Student actualStudent = ridingHood.getStudent();

        assertEquals(expectedStudent,actualStudent);

    }
    @Test
    void getStudentWhenNotSet(){
        RidingHood ridingHood = new RidingHood();
        Student actualStudent = ridingHood.getStudent();
        assertNull(actualStudent);

    }

    @Test
    void setStudent() {
        RidingHood ridingHood = new RidingHood();
        Student student = new Student();
        student.setStudentName("Santiago Cardenas Torres");
        ridingHood.setStudent(student);
        Student actualStudent =ridingHood.getStudent();
        assertNotNull(actualStudent);
    }
}