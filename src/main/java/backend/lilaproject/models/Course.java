package backend.lilaproject.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCourse;

    @Column(nullable = false)
    private int level;
    @Column(nullable = false)
    private char courseClass;

    @ManyToOne
    @JoinColumn(name = "idSchool")
    School school;

}
