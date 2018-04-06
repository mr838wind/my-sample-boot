package com.wind.myapp.framework.profiletest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class ProfileTestController {
	
	@Autowired
    private SayHello sayHello; 
	
	@Autowired
	ApplicatonPropertyProvider propertyProvider;
	
    
    @RequestMapping("/profile/test")
    public String hello(@RequestParam(value="name", defaultValue="World") String name) {
    	log.info(">> ProfileActive={}>>>>", propertyProvider.getProfileActive());  
    	log.info(">> LogLevel={}>>>>", propertyProvider.getAppName());  
    	return sayHello.sayHello(name); 
    }
	
    
    public static interface SayHello {
    	String sayHello(String msg);
	}

	@Component
	@Profile("dev")
	public static class SayHelloDev implements SayHello {
		public String sayHello(String msg) {
			String result = ">>> [dev] say hello >> " + msg;
			log.debug(result); 
			return result;
		}
	}
	
	@Component
	@Profile("prod")
	public static class SayHelloProd implements SayHello {
		public String sayHello(String msg) {
			String result = ">>> [prod] say hello >> " + msg;
			log.debug(result); 
			return result;
		}
	}
	
}
