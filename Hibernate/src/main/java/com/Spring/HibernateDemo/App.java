package com.Spring.HibernateDemo;

import com.Spring.HibernateDemo.Laptop;
import com.Spring.HibernateDemo.Student;
import com.Spring.HibernateDemo.StudentName;
import org.hibernate.SessionFactory;
import org.hibernate.Session;

import org.hibernate.cfg.Configuration;


public class App {
    public static void main(String[] args) {
        StudentName sname = new StudentName();
        sname.setFname("Deep");
        sname.setLname("Dutta");

        Laptop lap1 = new Laptop();
        lap1.setLid(121);
        lap1.setLname("HP");


        Student s1 = new Student();
        s1.setId(103);
        s1.setName(sname);
        s1.setTech("Block Chain");
        s1.getLap().add(lap1);

        lap1.getStudent().add(s1);

//        Configuration config = new Configuration();
//        config.addAnnotatedClass(Student.class).configure("hibernate.cfg.xml");
        //Rewrite this in a single line

        SessionFactory sf = new Configuration()
                .addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class)
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        Session session = sf.openSession();
        session.beginTransaction(); //Transaction is needed when saving, updating and deleting

        //Saving the data
        session.persist(s1);
        System.out.println("Student saved successfully.");
        //Fetching the data
//        Student s2 = session.find(Student.class, 103);
//        System.out.println(s2);

        //Update data

//        session.merge(s3);
//        System.out.println("Updated Successfully");

        //Deleting data

//        Student s4 = session.find(Student.class, 103);
//        session.remove(s4);

        session.persist(lap1);
        System.out.println("Laptop saved successfully");

        session.getTransaction().commit();
        session.close();
        System.out.println("Transaction completed successfully");

    }
}