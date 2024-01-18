package me.haitmq;



import org.springframework.context.support.ClassPathXmlApplicationContext;


public class BeanLifeCycleDemoApp {
	public static void main(String[] args) {
		// create spring container from config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanLifeCycle-applicationContext.xml");
		
		// get bean from sc
		Coach theCoach = context.getBean("myCoach", Coach.class);
		
		
		//use getDailyWorkout() method
		System.out.println(theCoach.getDailyWorkout());
		
		
		
		// close context
		context.close();
	}
}
