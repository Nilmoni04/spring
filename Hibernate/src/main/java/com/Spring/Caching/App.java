package com.Spring.Caching;

import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {

//        Student a1 = new Student();
//        a1.setAid(101);
//        a1.setName("Nilu");
//        a1.setColor("Blue");
//
//        Student a2 = new Student();
//        a2.setAid(102);
//        a2.setName("Deep");
//        a2.setColor("Yellow");
//
//        Student a3 = new Student();
//        a3.setAid(103);
//        a3.setName("RamK");
//        a3.setColor("Green");

        Alien a = null;

        SessionFactory sf = new Configuration().
                addAnnotatedClass(Alien.class).
                configure("hibernate.cfg.xml").
                buildSessionFactory();

        Session session1 = sf.openSession();
        session1.beginTransaction();

//        session1.persist(a1);
//        session1.persist(a2);
//        session1.persist(a3);
//        System.out.println("Data saved successfully!");

       //First level cache
        a = (Alien) session1.find(Alien.class, 101);
        System.out.println(a);

        session1.getTransaction().commit();
        session1.close();

        Session session2 = sf.openSession();
        session2.beginTransaction();

        a = (Alien) session2.find(Alien.class, 101);
        System.out.println(a);

        session2.getTransaction().commit();
        session2.close();
    }
}
