package com.developersstack.lms.entity;

import javax.persistence.*;

@Entity
public class Laptop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "laptop_id")
    private long id;
    private String brand;

    @OneToOne
    @JoinColumn(
            name = "student_id",
            unique = true
    )
    private Student student;

    public Laptop() {
    }

    public Laptop(long id, String brand, Student student) {
        this.id = id;
        this.brand = brand;
        this.student = student;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
