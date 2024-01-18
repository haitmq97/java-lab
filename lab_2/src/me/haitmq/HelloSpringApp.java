package me.haitmq;



import org.springframework.context.support.ClassPathXmlApplicationContext;


public class HelloSpringApp {
	public static void main(String[] args) {
		// create spring container from config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// get bean from sc
		Coach theCoach = context.getBean("myCoach", Coach.class);
		// use method from obj
		System.out.println(theCoach.getDailyWorkout());
		
		// getfortune 
		System.out.println(theCoach.getDailyFortune());
		
		
		
		// close context
		context.close();
	}
}
