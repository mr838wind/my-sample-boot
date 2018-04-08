package com.wind.myapp.common;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test") 
public class TestAbstractBasicController {

    @Autowired
	protected WebApplicationContext context;

	protected MockHttpSession mockSession;

    protected void setUp() {
		mockSession = new MockHttpSession(context.getServletContext());
		//mockSession.setAttribute(SessionKey.USER_INFO, getLoginUser());
		
	}
  
    
    
    
}