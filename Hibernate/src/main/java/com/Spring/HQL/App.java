package com.Spring.HQL;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import jakarta.persistence.Query;
import org.hibernate.query.sql.internal.SQLQueryParser;

import java.util.List;
import java.util.Random;

public class App {
    public static void main(String[] args) {

        SessionFactory sf = new Configuration().
                addAnnotatedClass(com.Spring.HQL.Student.class).
                configure("hibernate.cfg.xml").
                buildSessionFactory();

        Session session1 = sf.openSession();
        session1.beginTransaction();

//        Random r = new Random();
//
//        for(int i=0; i<50; i++) {
//            Student s = new Student();
//            s.setRollNo(i);
//            s.setName("Name" + i);
//            s.setMarks(r.nextInt(100));
//            session1.persist(s);
//        }

        //Obtain marks of all students
        Query q = session1.createQuery("from Student where marks > 96");
        List<Student> students = q.getResultList();

        System.out.println("Marks greater than 96 : ");
        for(Student s : students) {
            System.out.println(s);
        }

        //Obtain marks of specific roll no
        Query q1 = session1.createQuery("from Student where rollNo=14");
        Student stud1 = (Student) q1.getSingleResultOrNull();

        System.out.println("Marks of rollNo 14 is : ");
        System.out.println(stud1);

        //object array for student
        Query q2 = session1.createQuery("select rollNo, name, marks from Student where rollNo=20");
        Object[] stud2 = (Object[]) q2.getSingleResult();

        System.out.println("Marks of roll no 20 is : " + stud2[2]);

        //Obtain the sum of marks of students
        Query q3 = session1.createQuery("select sum(marks) from Student s where s.marks>60");
        Object total = (Object)q3.getSingleResult();
        System.out.println("Total marks : " + total);

        //Prepared Statement
        int b = 80;
        Query q4 = session1.createQuery("select sum(marks) from Student s where s.marks> : b");
        q4.setParameter("b", b);
        Object totalMarks = (Object)q4.getSingleResult();
        System.out.println("Total marks : " + totalMarks);

        //SQL Query in hibernate
        Query query = session1.createNativeQuery("SELECT * FROM alien_table_for_hql");
        List<Object[]> resultList = query.getResultList();

        for (Object[] row : resultList) {
            System.out.println("ID: " + row[0] + ", Name: " + row[2] + ", Marks: " + row[1]);
        }


        session1.getTransaction().commit();
        session1.close();
    }
}
