package kz.codekitchen.entity;

import jakarta.persistence.*;
import kz.codekitchen.FacultyType;

import java.util.List;

@Entity
@Table(name = "groups")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "number", nullable = false, length = 10)
    private String number;

    @Column(name = "faculty_type", nullable = false)
    private FacultyType facultyType;

    public Group() {
    }

    public Group(String number, FacultyType facultyType) {
        this.number = number;
        this.facultyType = facultyType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public FacultyType getFacultyType() {
        return facultyType;
    }

    public void setFacultyType(FacultyType facultyType) {
        this.facultyType = facultyType;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", facultyType=" + facultyType +
                '}';
    }
}
