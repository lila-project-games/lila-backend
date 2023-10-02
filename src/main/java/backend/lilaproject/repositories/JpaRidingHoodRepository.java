package backend.lilaproject.repositories;

import backend.lilaproject.models.RidingHood;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RidingHoodRepository extends JpaRepository<RidingHood,Long> {
}
