package me.haitmq.springdemo.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import me.haitmq.springdemo.service.FortuneService;

@Component
public class KickBoxingCoach implements Coach {
	// define fortuneService field
	private FortuneService fortuneService;
	
	// create constructor with no-args
	public KickBoxingCoach() {
		
	}
	
	// define setter and getter
	
	public FortuneService getFortuneService() {
		return fortuneService;
	}

	// use @Autowired for setter injection
	@Autowired
	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	
	
	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Practice high kick 20 times";
	}


	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		System.out.println("Start your new day with dynamism");
		return fortuneService.getFortune();
	}

}
