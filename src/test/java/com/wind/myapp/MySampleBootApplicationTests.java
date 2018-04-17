package com.wind.myapp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.wind.myapp.framework.profiletest.ApplicatonPropertyProvider.SpringAppProp;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class MySampleBootApplicationTests {

	@Autowired
	SpringAppProp prop;
	
	@Test
	public void contextLoads() {
		log.info(">>>> SpringAppProp >> name = {}",prop.getName());
	}
	
}
