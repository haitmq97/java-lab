package com.example.springdemo.config;

import java.util.jar.JarInputStream;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.example.springdemo.config")
public class MySpringConfiguration {
	
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver vR = new InternalResourceViewResolver();
		vR.setViewClass(JstlView.class);
		vR.setPrefix("/WEB-INF/view/");
		vR.setSuffix(".jsp");
		return vR;
	}

}
