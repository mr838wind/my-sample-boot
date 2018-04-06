package com.wind.myapp.profiletest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class ApplicatonPropertyProvider {

	@Value("${spring.profiles.active}")
	private String profileActive;
	
	@Value("${app.name}")
	private String appName;
	
}
