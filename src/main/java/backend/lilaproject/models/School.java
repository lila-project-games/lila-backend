package backend.lilaproject.models;

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
    private Long idSchool;
    @Column(nullable = false)
    private String schoolName;
}
