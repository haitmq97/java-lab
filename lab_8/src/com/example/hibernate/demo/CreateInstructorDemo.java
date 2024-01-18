package com.example.hibernate.demo;

import org.hibernate.cfg.Configuration;

import com.example.hibernate.demo.entity.Course;
import com.example.hibernate.demo.entity.Instructor;
import com.example.hibernate.demo.entity.InstructorDetails;
import com.example.hibernate.demo.entity.Student;
import com.vividsolutions.jts.awt.ShapeCollectionPathIterator;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class CreateInstructorDemo {

	public static void main(String[] args) {
		// create session factory

		System.out.println("test 1");

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetails.class).addAnnotatedClass(Course.class).buildSessionFactory();

		System.out.println("test 2");
		// create session

		try {
			// createInstructor(factory);

			//printOutInstructorById(factory);

			updateInstructor(factory);

//			deleteInstructorById(factory);

			 //createInstructor2(factory);
		} finally {
			factory.close();
		}

	}

	private static void deleteInstructorById(SessionFactory factory) {
		int theId = 1;
		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();

			Instructor tempInstructor = session.find(Instructor.class, theId);

			session.remove(tempInstructor);

			session.getTransaction().commit();

			System.out.println("Done!");
		} finally {
			session.close();
		}

	}

	public static void printOutInstructorById(SessionFactory factory) {
		int theId = 1;
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();

			Instructor tempInstructor = session.find(Instructor.class, theId);

		
			InstructorDetails tempDetails = tempInstructor.getInstructorDetails();

			
			System.out.println("======>>>>>Instructor Details: " + tempDetails);
			
			try {
				
			} catch (NullPointerException e) {
				System.out.println("have exception here:");
				System.out.println("instructor detain have not set up yet");
				//e.printStackTrace();
			}

			System.out.println("======>>>>>Instructor: " + tempInstructor);
			session.getTransaction().commit();
		} finally {
			session.close();
		}

	}

	public static void updateInstructor(SessionFactory factory) {
		Session session = factory.getCurrentSession();
		int theId = 1;
		try {
			session.beginTransaction();

			Instructor tempInstructor = session.find(Instructor.class, theId);

			tempInstructor.setFirstName("Kiliana");
			
		
			try {
			tempInstructor.getInstructorDetails().setHobby("playing basketBall");
			} catch (Exception e) {
				InstructorDetails temDetails = new InstructorDetails("youtube.com", "playing basketBall");
				tempInstructor.setInstructorDetails(temDetails);
			}
			
			session.saveOrUpdate(tempInstructor);

			session.getTransaction().commit();

			System.out.println("Done!");

		} finally {

			session.close();

		}

	}

	public static void createInstructor(SessionFactory factory) {
		Session session = factory.getCurrentSession();

		System.out.println("test 3");
		// use the session obj to save java obj

		try {
			// create Instructor
			Instructor tempInstructor = new Instructor("Susan", "Burble", "susan@example.com");

			// create Instructor Detail

			InstructorDetails tempInstructorDetails = new InstructorDetails("http://www.youtube.com/susano123",
					"Playing Video games");

			// set instructorDetails obj for instructor obj

			tempInstructor.setInstructorDetails(tempInstructorDetails);

			// start session
			session.beginTransaction();

			// save instructor obj

			session.save(tempInstructor);

			// commit session
			session.getTransaction().commit();

			System.out.println("Done!");

		} finally {

			session.close();

		}
	}

	public static void createInstructor2(SessionFactory factory) {
		Session session = factory.getCurrentSession();

		try {
			// create Instructor
			Instructor tempInstructor = new Instructor("Susan", "Burble", "susan@example.com");
			
			System.out.println("instructor details: " + tempInstructor.getInstructorDetails());

			// create Instructor Detail

			// start session
			session.beginTransaction();

			// save instructor obj

			session.save(tempInstructor);

			// commit session
			session.getTransaction().commit();

			System.out.println("Done!");

		} finally {

			session.close();

		}
	}

}
