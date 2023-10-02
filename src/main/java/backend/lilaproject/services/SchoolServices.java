package backend.lilaproject.services;

import backend.lilaproject.models.School;
import backend.lilaproject.repositories.JpaSchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SchoolServices {
    @Autowired
    private JpaSchoolRepository schoolRepoRepository;

    public School save(School school) {
        return schoolRepoRepository.save(school);
    }

    public Optional<School> getById(Long id) {
        return schoolRepoRepository.findById(id);
    }

    public List<School> getAll() {
        return (List<School>) schoolRepoRepository.findAll();
    }

    public void delete(Long id) {
        schoolRepoRepository.deleteById(id);
    }

    public String update(School school) {
        try {
            if (schoolRepoRepository.existsById(school.getId())) {
                schoolRepoRepository.save(school);
                return "School updated: " + school.getSchoolName();
            } else {
                return "School not updated: Record with ID " + school.getId() + " does not exist";
            }
        } catch (Exception e) {
            return "School not updated: " + e.getMessage();
        }
    }

}
