package com.wind.myapp.sample.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class SampleHelloController {

    private static final String template = "Hello, %s! --@RestSampleController";

    //TODO: html and server page location thinking
    /**
     * visit /html/...
     * @param name
     * @param model
     * @return
     */
    @GetMapping("/html/**")
    public ModelAndView vueTest(HttpServletRequest request, ModelAndView mv) {
    	String url = request.getRequestURI();
    	log.info(">>>> url={}", url);
    	mv.setViewName(url);
    	
    	return mv;
    }
    
    
    /**
     * hello
     * @param name
     * @param model
     * @return
     */
    @GetMapping("/sample/hello")
    public ModelAndView greeting(@RequestParam(value="name", defaultValue="World") String name, ModelAndView mv) {
    	mv.setViewName("hello");
    	mv.addObject("name", name + " --@SampleController");
    	return mv;
    }
    
    /**
     * rest
     * @param name
     * @return
     */
    @RequestMapping("/rest/sample/hello")
    @ResponseBody
    public String greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return String.format(template, name);
    }
}
