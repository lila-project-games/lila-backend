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

public class RidingHood {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String ridingHoodHow;

    @Column(nullable = false)
    private String ridingHoodObj;

    @Column(nullable = false)
    private String wolfHow;

    @Column(nullable = false)
    private String wolfObj;

    @Column(nullable = false)
    private String grannyHow;

    @Column(nullable = false)
    private String grannyObj;

    @Column(nullable = false)
    private String hunterHow;

    @Column(nullable = false)
    private String hunterObj;

    @Column(nullable = false)
    private String drawRidingHood;

    @Column(nullable = false)
    private String story;

    @OneToOne
    @JoinColumn(name = "student_id")
    Student student;

}


