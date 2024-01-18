package com.example.hibernate.demo;

import org.hibernate.cfg.Configuration;

import com.example.hibernate.demo.entity.Course;
import com.example.hibernate.demo.entity.Instructor;
import com.example.hibernate.demo.entity.InstructorDetails;
import com.example.hibernate.demo.entity.Student;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class EagerLazyDemo {

	public static void main(String[] args) {
		// create session factory


		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetails.class).addAnnotatedClass(Course.class).buildSessionFactory();

		// create session

		Session session = factory.getCurrentSession();

		// use the session obj to save java obj

		try {
			// create Instructor
			
			// start session
			session.beginTransaction();
			
			int theId = 1;

			// save instructor obj
			Instructor tempInstructor = session.get(Instructor.class,theId);

			// instructor id after add instructor into database

			System.out.println("======>>> Instructor: " + tempInstructor);
			
//			session.getTransaction().commit();
//			session.close();

			System.out.println("======>>> Courses: " + tempInstructor.getCourses());
			
			// commit session
			session.getTransaction().commit();

			System.out.println("Done!");

		} finally {

			session.close();

			factory.close();
		}

	}

}
