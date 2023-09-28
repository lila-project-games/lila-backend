package backend.lilaproject.repositories;

import backend.lilaproject.models.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface SchoolRepo extends JpaRepository<School, Long> {

}
