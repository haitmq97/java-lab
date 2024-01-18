package me.haitmq.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import me.haitmq.springdemo.common.Coach;

public class Lab_3_13_AnnotationBeanLifeCycleDemoApp {
	// lab 3.13

	public static void main(String[] args) {
		// Create Spring container from config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		// get bean from sc
		Coach theCoach = context.getBean("tennisCoach", Coach.class);

		//call method
		System.out.println(theCoach.getDailyWorkout());
		
		System.out.println(theCoach.getDailyFortune());
		
		//close context
		context.close();

	}

}
