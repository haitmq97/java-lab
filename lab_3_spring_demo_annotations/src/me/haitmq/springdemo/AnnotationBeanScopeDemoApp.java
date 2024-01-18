package me.haitmq.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import me.haitmq.springdemo.common.Coach;

public class AnnotationBeanScopeDemoApp {
	// lab 3.12

	public static void main(String[] args) {
		// Create Spring container from config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		// get bean from sc
		Coach theCoach = context.getBean("tennisCoach", Coach.class);

		// get another Coach
		Coach alphaCoach = context.getBean("tennisCoach", Coach.class);

		// check if they are the same
		boolean result = (theCoach == alphaCoach);

		// print out the results
		System.out.println("\nPointing to the same object: " + result);

		System.out.println("\nMemorey location for theCoach: " + theCoach);

		System.out.println("\nMemorey location for alphaCoach: " + alphaCoach);
		
		
		//close context
		context.close();

	}

}
