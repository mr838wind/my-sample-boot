package com.wind.myapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * configuration : .../framework/config/*
 * @author windfall
 *
 */
@SpringBootApplication
@EnableTransactionManagement(proxyTargetClass=true) // we have no service interface here: so set proxyTargetClass=true
public class MySampleBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(MySampleBootApplication.class, args);
	}
	
	
	
}
