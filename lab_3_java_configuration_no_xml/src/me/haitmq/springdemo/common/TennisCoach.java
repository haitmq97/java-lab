package me.haitmq.springdemo.common;


import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import me.haitmq.springdemo.service.FortuneService;


@Component
public class TennisCoach implements Coach {
	// create FortuneService field
	private FortuneService fortuneService;
	
	//create constructor with FortuneService field with @Autowired
	@Autowired
	public TennisCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {		
		// TODO Auto-generated method stub
		return "Practice your backhand volley";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}
	
	
	//add methods with @PostContruct and @PreDestroy
	@PostConstruct
	public void doMyStartupStuff() {
		System.out.println("====>>> TennisCoach: inside of doMyStartupStuff()");
	}
	
	@PreDestroy
	public void doMyCleanupStuff() {
		System.out.println("====>>> TennisCoach: inside of doMyCleanupStuff()");
	}
	
	
	

}
