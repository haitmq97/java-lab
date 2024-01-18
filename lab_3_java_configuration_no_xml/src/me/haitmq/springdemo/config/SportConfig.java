package me.haitmq.springdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import me.haitmq.springdemo.common.Coach;
import me.haitmq.springdemo.common.SwimCoach;
import me.haitmq.springdemo.service.FortuneService;
import me.haitmq.springdemo.service.SadFortuneService;

@Configuration
// comment CommentScan for lab 3.15 purpose
//@ComponentScan("me.haitmq.springdemo")
public class SportConfig {
	
	@Bean
	public FortuneService sadFortuneService() {
		return new SadFortuneService();
	}
	
	@Bean
	public Coach swimCoach() {
		SwimCoach swimCoach = new SwimCoach(sadFortuneService());
		return swimCoach;
	}
	
}
