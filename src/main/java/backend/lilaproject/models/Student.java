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

public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String studentName;

    @Column(nullable = false)
    private String firstSurname;

    @Column(nullable = false)
    private String secondSurname;

    @ManyToOne // Relación ManyToOne con la entidad School
    @JoinColumn(name = "school_id") // Nombre de la columna de la clave externa en la tabla Student
    private School school;
}

