package com.wind.myapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
//@EnableTransactionManagement
public class MySampleBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(MySampleBootApplication.class, args);
	}
}
