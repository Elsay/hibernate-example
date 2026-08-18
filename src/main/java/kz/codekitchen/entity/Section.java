package kz.codekitchen.entity;

import jakarta.persistence.*;
import kz.codekitchen.SectionType;

import java.util.List;

@Entity
@Table(name = "sections")
public class Section {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "section_type", nullable = false)
    private SectionType sectionType;

    @ManyToMany
    @JoinTable(name = "students_sections",
            joinColumns = @JoinColumn(name = "section_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private List<Student> students;

    public Section() {
    }

    public Section(SectionType sectionType) {
        this.sectionType = sectionType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public SectionType getSectionType() {
        return sectionType;
    }

    public void setSectionType(SectionType sectionType) {
        this.sectionType = sectionType;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Section{" +
                "id=" + id +
                ", sectionType=" + sectionType +
                '}';
    }
}
