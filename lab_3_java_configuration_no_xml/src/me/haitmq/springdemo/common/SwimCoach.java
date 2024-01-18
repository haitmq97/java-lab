package me.haitmq.springdemo.common;

import me.haitmq.springdemo.service.FortuneService;

public class SwimCoach implements Coach {
	
	//fields
	private FortuneService fortuneService;
	
	// contructor
	public SwimCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Swim 1000 meters as a warm up";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

}
