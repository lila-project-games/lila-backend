package backend.lilaproject.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import backend.lilaproject.models.School;
import java.util.ArrayList;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolRepoRepository extends JpaRepository<School, Long>{

}
