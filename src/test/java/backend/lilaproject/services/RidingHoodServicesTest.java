package backend.lilaproject.services;

import backend.lilaproject.models.RidingHood;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import backend.lilaproject.repositories.JpaRidingHoodRepository;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.*;


import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
@SpringBootTest


class RidingHoodServicesTest {
    @InjectMocks
    private RidingHoodServices ridingHoodServices;
    @Mock
    private JpaRidingHoodRepository jpaRidingHoodRepository;

    @Test
    void saveRidingHood() {
        RidingHood ridingHood = new RidingHood();
        when(jpaRidingHoodRepository.save(ridingHood)).thenReturn(ridingHood);

        RidingHood saveRidingHood = ridingHoodServices.saveRidingHood(ridingHood);

        assertNotNull(saveRidingHood);
        assertEquals(ridingHood, saveRidingHood);

    }

    @Test
    void getRidingHoodById() {
        Long ridingHoodId = 1L;

        RidingHood ridingHood = new RidingHood();
        ridingHood.setId(ridingHoodId);
        when(jpaRidingHoodRepository.findById(ridingHoodId)).thenReturn(Optional.of(ridingHood));

        Optional<RidingHood> result = ridingHoodServices.getRidingHoodById(ridingHoodId);

        assertTrue(result.isPresent());
        assertEquals(ridingHoodId,result.get().getId());
    }


    @Test
    void getAllRidingHoods() {
        List<RidingHood> ridingHoods = new ArrayList<>();
        ridingHoods.add(new RidingHood(1L, "riding hood"));
        ridingHoods.add(new RidingHood(1L, "crew riding hood"));
        ridingHoods.add(new RidingHood(1L, "story"));

        when(jpaRidingHoodRepository.findAll()).thenReturn(ridingHoods);
        List<RidingHood> result = ridingHoodServices.getAllRidingHoods();

        assertEquals(ridingHoods.size(), result.size());
        for (int i = 0; i < ridingHoods.size(); i++) {
            assertEquals(ridingHoods.get(i), result.get(i));
            assertEquals(ridingHoods.get(i).getRidingHoodHow(), result.get(i).getRidingHoodHow());

        }
    }

    @Test
    void deleteRidingHoodById() {
        Long ridingHoodId = 1L;

        ridingHoodServices.deleteRidingHoodById(ridingHoodId);

        verify(jpaRidingHoodRepository, times(1)).deleteById(ridingHoodId);
    }
    @Test
    void updateRidingHood() {
        RidingHood existingRidingHood = new RidingHood();
        existingRidingHood.setId(1L);

        RidingHood updatedRidingHood = new RidingHood();
        updatedRidingHood.setId(1L);

        when(jpaRidingHoodRepository.existsById(1L)).thenReturn(true);
        when(jpaRidingHoodRepository.save(updatedRidingHood)).thenReturn(updatedRidingHood);
        RidingHood result = ridingHoodServices.updateRidingHood(updatedRidingHood);

        assertNotNull(result);
        assertEquals(updatedRidingHood, result);

    }
}