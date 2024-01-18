package com.example.hibernate.demo;

import org.hibernate.cfg.Configuration;

import com.example.hibernate.demo.entity.Student;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class ReadStudentDemo {

	public static void main(String[] args) {
		// create session factory
		
		System.out.println("test 1");
	
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		System.out.println("test 2");
		// create session
		
		Session session = factory.getCurrentSession();
		
		System.out.println("test 3");
		// use the session obj to save java obj
		
		try {
			// create student obj
			System.out.println("Creating new student object ...");
			Student tempStudent = new Student("John", "Nash", "johnnash@example.com");
			
			// start session
			session.beginTransaction();
		
			// save student obj
			System.out.println("Saving the student...");
			session.save(tempStudent);
			
			System.out.println("===> student id before session commit: " + tempStudent.getId());
			// commit session
			session.getTransaction().commit();
			
			System.out.println("===> student id after session commit: " + tempStudent.getId());
			System.out.println("Done!");
			
			
			
			// create new session
			
			Session session2 = factory.getCurrentSession();
			
			session2.beginTransaction();
			
			System.out.println("Get student with id: " + tempStudent.getId());
			
			Student myStudent = session2.get(Student.class, tempStudent.getId());
			
			System.out.println("===> the Student: " + myStudent);
			
			session2.getTransaction().commit();
			
			System.out.println("Done");
			
		} finally {
			factory.close();
		}

	}

}
