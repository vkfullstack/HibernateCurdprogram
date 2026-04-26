package com.vk.hiber;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.Session;
import com.vk.hiber.entity.Student;
import com.vk.hiber.util.Connectionprovider;

public class App {
    public static void main(String[] args) {
       // System.out.println("Hello World!");

        // Create student object
        Student student = new Student();
        student.setName("Vijay");   // if using @GeneratedValue, no need for setId()
        student.setTech("MCA");

        // Get SessionFactory
        SessionFactory sessionFactory = Connectionprovider.getSessionFactory();

        // Open Hibernate session
     Session session = sessionFactory.openSession();

     
        // Begin transaction
        Transaction tx = session.beginTransaction();

        // Save student object
        session.persist(student);

        // Commit transaction
        tx.commit();

        // Close session
        session.close();

        System.out.println("Student saved successfully!");
    }
}