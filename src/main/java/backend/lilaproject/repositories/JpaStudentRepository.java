package backend.lilaproject.repositories;

import backend.lilaproject.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaStudentRepository extends JpaRepository<Student, Long> {
    @Query("SELECT s FROM Student s WHERE s.school.id = :schoolId")
    List<Student> getBySchoolId(@Param("schoolId") Long schoolId);
}
