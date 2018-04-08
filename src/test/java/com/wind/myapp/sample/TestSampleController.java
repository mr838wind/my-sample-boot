package com.wind.myapp.sample;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.web.servlet.ModelAndView;

import com.wind.myapp.common.TestAbstractBasicController;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test") 
public class TestSampleController extends TestAbstractBasicController {

    @Autowired
    private MockMvc mvc;
    
	@Before
	public void setUp() {
		super.setUp(); 
	}

    @Test
    public void hello() throws Exception {
	    mvc.perform(
	    			get("/sample/list")
	    		)
	    		.andDo(print())
	    		.andExpect(status().isOk())
	            .andExpect(view().name("/sample/list"))
	            .andExpect(new ResultMatcher() {
					@Override
					public void match(MvcResult result) throws Exception {
						ModelAndView mv = result.getModelAndView();
						assertTrue("/sample/list".equals(mv.getViewName()));
					}
	            })
	            ;
    }
  
    
    
    
}