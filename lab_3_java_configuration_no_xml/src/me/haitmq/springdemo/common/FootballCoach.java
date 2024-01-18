package me.haitmq.springdemo.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import me.haitmq.springdemo.service.FortuneService;


@Component
public class FootballCoach implements Coach {

	// define fortuneservice field and autowiring
	@Autowired
	private FortuneService fortuneService;
	
	// constructor with no-args
	public FootballCoach() {
		
	}
	
	// no need setter
	
	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Practice shooting the ball in 30 minutes";
	}

	

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

}
