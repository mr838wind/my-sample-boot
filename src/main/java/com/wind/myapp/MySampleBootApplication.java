package com.wind.myapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.thymeleaf.spring5.ISpringTemplateEngine;
import org.thymeleaf.spring5.view.ThymeleafView;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

/**
 * configuration : .../framework/config/*
 * @author wind
 *
 */
@SpringBootApplication
@EnableTransactionManagement(proxyTargetClass=true) // we have no service interface here: so set proxyTargetClass=true
public class MySampleBootApplication extends SpringBootServletInitializer {

	// deployable 
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(MySampleBootApplication.class);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(MySampleBootApplication.class, args);
	}
	
	
	
}
