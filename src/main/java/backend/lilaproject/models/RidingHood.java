package backend.lilaproject.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRidingHoodHow() {
        return ridingHoodHow;
    }

    public void setRidingHoodHow(String ridingHoodHow) {
        this.ridingHoodHow = ridingHoodHow;
    }

    public String getRidingHoodObj() {
        return ridingHoodObj;
    }

    public void setRidingHoodObj(String ridingHoodObj) {
        this.ridingHoodObj = ridingHoodObj;
    }

    public String getWolfHow() {
        return wolfHow;
    }

    public void setWolfHow(String wolfHow) {
        this.wolfHow = wolfHow;
    }

    public String getWolfObj() {
        return wolfObj;
    }

    public void setWolfObj(String wolfObj) {
        this.wolfObj = wolfObj;
    }

    public String getGrannyHow() {
        return grannyHow;
    }

    public void setGrannyHow(String grannyHow) {
        this.grannyHow = grannyHow;
    }

    public String getGrannyObj() {
        return grannyObj;
    }

    public void setGrannyObj(String grannyObj) {
        this.grannyObj = grannyObj;
    }

    public String getHunterHow() {
        return hunterHow;
    }

    public void setHunterHow(String hunterHow) {
        this.hunterHow = hunterHow;
    }

    public String getHunterObj() {
        return hunterObj;
    }

    public void setHunterObj(String hunterObj) {
        this.hunterObj = hunterObj;
    }

    public String getDrawRidingHood() {
        return drawRidingHood;
    }

    public void setDrawRidingHood(String drawRidingHood) {
        this.drawRidingHood = drawRidingHood;
    }

    public String getStory() {
        return story;
    }

    public void setStory(String story) {
        this.story = story;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "RidingHood{" +
                "id=" + id +
                ", ridingHoodHow='" + ridingHoodHow + '\'' +
                ", ridingHoodObj='" + ridingHoodObj + '\'' +
                ", wolfHow='" + wolfHow + '\'' +
                ", wolfObj='" + wolfObj + '\'' +
                ", grannyHow='" + grannyHow + '\'' +
                ", grannyObj='" + grannyObj + '\'' +
                ", hunterHow='" + hunterHow + '\'' +
                ", hunterObj='" + hunterObj + '\'' +
                ", drawRidingHood='" + drawRidingHood + '\'' +
                ", story='" + story + '\'' +
                ", student=" + student +
                '}';
    }
}


