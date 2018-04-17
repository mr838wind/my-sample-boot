package com.wind.myapp.framework.profiletest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class ApplicatonPropertyProvider {

	// ==== by @Value 
	
	@Value("${spring.profiles.active}")
	private String profileActive;
	
	@Value("${spring.application.name}")
	private String appName;
	
	
	//==== by @ConfigurationProperties
	@Component
	@ConfigurationProperties(prefix="spring.application")
	@Data
	public static class SpringAppProp {
		private String name;
	}
	
	
}
