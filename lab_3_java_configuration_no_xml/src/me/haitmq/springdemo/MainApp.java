package me.haitmq.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import me.haitmq.springdemo.common.Coach;
import me.haitmq.springdemo.config.SportConfig;

public class MainApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
		
		
		//get bean from spring contaner
		/*
		Coach theCoach = context.getBean("tennisCoach", Coach.class);
		
		// call method from bean
		System.out.println(theCoach.getDailyWorkout());
		
		System.out.println(theCoach.getDailyFortune());
		*/
		
		// lab 3.15
		
		// i turned off @ComponentScan in SportConfig class
		// get bean
		Coach swimCoach = context.getBean("swimCoach", Coach.class);
		// call method on bean
		
		System.out.println(swimCoach.getDailyWorkout());
		
		System.out.println(swimCoach.getDailyFortune());
		
		
		
		//close context
		
		context.close();
	}
}
