package com.Spring.HibernateDemo;

import jakarta.persistence.*;

import java.util.*;

@Entity
public class Student {
    @Id
    private int id;

    @Embedded
    private StudentName name;

    @Column(name = "New Tech")
    private String tech;
    @ManyToMany(mappedBy = "student")
    private List<Laptop> lap = new ArrayList<Laptop>();

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public StudentName getName() {
        return name;
    }

    public void setName(StudentName name) {
        this.name = name;
    }

    public String getTech() {
        return tech;
    }

    public void setTech(String tech) {
        this.tech = tech;
    }

    public List<Laptop> getLap() {
        return lap;
    }

    public void setLap(List<Laptop> lap) {
        this.lap = lap;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name=" + name +
                ", tech='" + tech + '\'' +
                ", lap=" + lap +
                '}';
    }
}
