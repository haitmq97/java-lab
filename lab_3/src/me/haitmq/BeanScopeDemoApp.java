package me.haitmq;



import org.springframework.context.support.ClassPathXmlApplicationContext;


public class BeanScopeDemoApp {
	public static void main(String[] args) {
		// create spring container from config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");
		
		// get bean from sc
		Coach theCoach = context.getBean("myCoach", Coach.class);
		
		// get another Coach
		Coach alphaCoach = context.getBean("myCoach", Coach.class);
		
		// check ì they are the same
		boolean result = (theCoach == alphaCoach);
		
		//print out the results
		System.out.println("\nPointing to the same object: "+result);
		
		System.out.println("\nMemorey location for theCoach: "+ theCoach);
		
		System.out.println("\nMemorey location for alphaCoach: "+ alphaCoach);
		
		
		
		
		
		// close context
		context.close();
	}
}
