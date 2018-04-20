package com.wind.myapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * configuration : .../framework/config/*
 * 
 * @author wind
 *
 */
@SpringBootApplication
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
