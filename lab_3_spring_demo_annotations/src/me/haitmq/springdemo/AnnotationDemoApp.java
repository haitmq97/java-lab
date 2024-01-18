package me.haitmq.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import me.haitmq.springdemo.common.Coach;

public class AnnotationDemoApp {
	public static void main(String[] args) {
		//Create Spring container from config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// lab 3.8 -3.9
		
		//get bean from spring container
//		Coach theCoach = context.getBean("thatSillyCoach", Coach.class);

		// use default bean id
		Coach theCoach = context.getBean("tennisCoach", Coach.class);
		
		
		// call method on bean
		System.out.println(theCoach.getDailyWorkout());
		
		// call method on bean: getDailyFortune()
		System.out.println(theCoach.getDailyFortune());
		
		
		// lab 3.10
		
		// use setter injection
		// define another class impliment Coach: KickBoxingCoach
		// in this class we use setter injection
		
		
		System.out.println("\n\n");
		
		// get another bean from spring container (with default bean id)
		Coach myAnotherCoach = context.getBean("kickBoxingCoach", Coach.class);
		
		// call method from bean
		System.out.println(myAnotherCoach.getDailyWorkout());
		
		System.out.println(myAnotherCoach.getDailyFortune());
		
		
		System.out.println("\n\n");
		
		// lab 3.11

		// use Field injection
		// define another class impliment Coach: FootballCoach
		// in this class we use Field injection
		
		Coach myFootballCoach = context.getBean("footballCoach", Coach.class);
		
		// call method from bean
		System.out.println(myFootballCoach.getDailyWorkout());
		
		System.out.println(myFootballCoach.getDailyFortune());

		
		
		//close context
		context.close();
	}
}
