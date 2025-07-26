package com.Spring.Caching;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "alien_table")
public class Alien {
    @Id
    private int aid;
    private String name;
    private String color;

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Student{" +
                "aid=" + aid +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
