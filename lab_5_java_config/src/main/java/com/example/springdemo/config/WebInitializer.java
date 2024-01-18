package com.example.springdemo.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;


import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebInitializer implements WebApplicationInitializer {
	
	public void onStartup(ServletContext container) throws ServletException {
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		context.register(MySpringConfiguration.class);
		context.setServletContext(container);
		ServletRegistration.Dynamic servletDynamic = container.addServlet("myDispatcher", new DispatcherServlet(context));
		servletDynamic.setLoadOnStartup(1);
		servletDynamic.addMapping("/");
	}

}
