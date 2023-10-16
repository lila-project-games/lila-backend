package backend.lilaproject.services;

import backend.lilaproject.models.RidingHood;
import backend.lilaproject.repositories.JpaRidingHoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RidingHoodServices {

    @Autowired
    private JpaRidingHoodRepository ridingHoodRepository;

    public RidingHood saveRidingHood(RidingHood ridingHood) {
        return ridingHoodRepository.save(ridingHood);
    }

    public Optional<RidingHood> getRidingHoodById(Long id) {
        return ridingHoodRepository.findById(id);
    }

    public List<RidingHood> getAllRidingHoods() {
        return (List<RidingHood>) ridingHoodRepository.findAll();
    }

    public void deleteRidingHoodById(Long id) {
        ridingHoodRepository.deleteById(id);
    }

    public RidingHood updateRidingHood(RidingHood updatedRidingHood) {
        try {
            if (ridingHoodRepository.existsById(updatedRidingHood.getId())) {
                return ridingHoodRepository.save(updatedRidingHood);
            } else {
                throw new IllegalArgumentException("RidingHood not updated: Record with ID " + updatedRidingHood.getId() + " does not exist");
            }
        } catch (Exception e) {
            throw new RuntimeException("RidingHood not updated: " + e.getMessage(), e);
        }
    }

}
