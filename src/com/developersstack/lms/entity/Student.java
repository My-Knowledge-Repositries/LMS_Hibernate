package com.developersstack.lms.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private long id;
    private String name;
    private String contact;

    @OneToOne(
            cascade = CascadeType.ALL,
            mappedBy = "student",
            fetch = FetchType.EAGER)
    private Laptop laptop;

    @OneToMany(
            cascade = CascadeType.ALL,
            mappedBy = "student",
            fetch = FetchType.EAGER
    )
    private List<Book> books = new ArrayList<>();

    @ManyToMany(mappedBy = "students")
    private List<Program> programs =
            new ArrayList<>();

    public Student() {
    }

    public Student(long id, String name, String contact, Laptop laptop, List<Book> books, List<Program> programs) {
        this.id = id;
        this.name = name;
        this.contact = contact;
        this.laptop = laptop;
        this.books = books;
        this.programs = programs;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public List<Program> getPrograms() {
        return programs;
    }

    public void setPrograms(List<Program> programs) {
        this.programs = programs;
    }

    public Laptop getLaptop() {
        return laptop;
    }

    public void setLaptop(Laptop laptop) {
        this.laptop = laptop;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}