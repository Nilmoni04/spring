package com.Spring.JPA;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {

        Student s6 = new Student();
        s6.setRollNo(6);
        s6.setName("Tanu");
        s6.setTech("Cyber Security");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myJPA");
        EntityManager em = emf.createEntityManager();
        Student s = em.find(Student.class, 3);
        System.out.println(s);
        em.getTransaction().begin();
        em.persist(s6);
        em.getTransaction().commit();
        System.out.println("Data Saved!");

        em.close();
        emf.close();
    }
}
