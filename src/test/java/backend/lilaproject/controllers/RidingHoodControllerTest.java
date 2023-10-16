package backend.lilaproject.controllers;

import org.junit.jupiter.api.Test;

import backend.lilaproject.services.RidingHoodServices;
import backend.lilaproject.models.RidingHood;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Map;
import java.util.Optional;
import java.util.List;

@SpringBootTest
class RidingHoodControllerTest {
    @InjectMocks
    private RidingHoodController ridingHoodController;

    @Mock
    private RidingHoodServices ridingHoodServices;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    void createRidingHood() {
        RidingHood ridingHood = new RidingHood();
        Mockito.when(ridingHoodServices.saveRidingHood(Mockito.any(RidingHood.class))).thenReturn(ridingHood);

        ResponseEntity<Map<String, Object>> responseEntity = ridingHoodController.createRidingHood(ridingHood);

        assertEquals(HttpStatus.CREATED.value(), responseEntity.getStatusCodeValue());
        Map<String, Object> responseMap = responseEntity.getBody();
        assertEquals(true, responseMap.get("success"));
        assertEquals("RidingHood created successfully", responseMap.get("message"));
        assertEquals(ridingHood, responseMap.get("data"));
    }


    @Test
    void getRidingHoodById() {
        long ridingHoodId = 1L;
        RidingHood ridingHood = new RidingHood();
        ridingHood.setId(ridingHoodId);

        Mockito.when(ridingHoodServices.getRidingHoodById(ridingHoodId)).thenReturn(Optional.of(ridingHood));

        ResponseEntity<Map<String, Object>> responseEntity = ridingHoodController.getRidingHoodById(ridingHoodId);

        assertEquals(HttpStatus.OK.value(), responseEntity.getStatusCodeValue());
        Map<String, Object> responseMap = responseEntity.getBody();
        assertTrue((Boolean) responseMap.get("success"));
        assertEquals(ridingHood, responseMap.get("data"));
    }


    @Test
    void getAllRidingHoods() {
        List<RidingHood> ridingHoods = List.of(new RidingHood(), new RidingHood());

        Mockito.when(ridingHoodServices.getAllRidingHoods()).thenReturn(ridingHoods);

        ResponseEntity<Map<String, Object>> responseEntity = ridingHoodController.getAllRidingHoods();

        assertEquals(HttpStatus.OK.value(), responseEntity.getStatusCodeValue());
        Map<String, Object> responseMap = responseEntity.getBody();
        assertTrue((Boolean) responseMap.get("success"));
        assertEquals(ridingHoods, responseMap.get("data"));
    }

    @Test
    void updateRidingHood() {
        long ridingHoodId = 1L;
        RidingHood ridingHood = new RidingHood();
        ridingHood.setId(ridingHoodId);

        Mockito.when(ridingHoodServices.updateRidingHood(ridingHood)).thenReturn(ridingHood);

        ResponseEntity<Map<String, Object>> responseEntity = ridingHoodController.updateRidingHood(ridingHood);

        assertEquals(HttpStatus.OK.value(), responseEntity.getStatusCodeValue());
        Map<String, Object> responseMap = responseEntity.getBody();
        assertTrue((Boolean) responseMap.get("success"));
        assertEquals("RidingHood updated successfully", responseMap.get("message"));
        assertEquals(ridingHood, responseMap.get("data"));
    }
    @Test
    void deleteRidingHood() {
        long ridingHoodId = 1L;

        Mockito.doNothing().when(ridingHoodServices).deleteRidingHoodById(ridingHoodId);

        ResponseEntity<Map<String, Object>> responseEntity = ridingHoodController.deleteRidingHood(ridingHoodId);

        assertEquals(HttpStatus.OK.value(), responseEntity.getStatusCodeValue());
        Map<String, Object> responseMap = responseEntity.getBody();
        assertTrue((Boolean) responseMap.get("success"));
    }
}