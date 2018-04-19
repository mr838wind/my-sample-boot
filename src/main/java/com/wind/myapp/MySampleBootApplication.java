package com.wind.myapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

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
	
	// fix “Circular view path” exception
	@Bean
	public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/jsp/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(MySampleBootApplication.class, args);
	}
	
	
	
}
