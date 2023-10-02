package backend.lilaproject.models;
import java.util.List;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.annotation.processing.Generated;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity

public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String schoolName;

    @OneToMany(mappedBy = "school") // Nombre del campo en la entidad Student que mapea esta relación
    private List<Student> students;
}
