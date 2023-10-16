package backend.lilaproject.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import backend.lilaproject.models.School;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaSchoolRepository extends JpaRepository<School, Long>{

}
