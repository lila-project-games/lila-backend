package backend.lilaproject.controllers;

import backend.lilaproject.models.RidingHood;
import backend.lilaproject.services.RidingHoodServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/ridinghoods")
public class RidingHoodController {

    @Autowired
    private RidingHoodServices ridingHoodServices;

    @PostMapping("/add")
    public RidingHood addRidingHood(@RequestBody RidingHood ridingHood) {
        return ridingHoodServices.saveRidingHood(ridingHood);
    }

    @GetMapping("/{id}")
    public Optional<RidingHood> getRidingHoodById(@PathVariable Long id) {
        return ridingHoodServices.getRidingHoodById(id);
    }

    @GetMapping("/all")
    public List<RidingHood> getAllRidingHoods() {
        return ridingHoodServices.getAllRidingHoods();
    }

    @PutMapping("/update")
    public RidingHood updateRidingHood(@RequestBody RidingHood updatedRidingHood) {
        return ridingHoodServices.updateRidingHood(updatedRidingHood);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteRidingHood(@PathVariable Long id) {
        ridingHoodServices.deleteRidingHoodById(id);
        return "Deleted RidingHood with ID: " + id;
    }
}
