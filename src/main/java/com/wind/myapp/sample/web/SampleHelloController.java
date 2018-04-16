package com.wind.myapp.sample.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SampleHelloController {

    private static final String template = "Hello, %s! --@RestSampleController";

    /**
     * hello
     * @param name
     * @param model
     * @return
     */
    @GetMapping("/sample/hello")
    public String greeting(@RequestParam(value="name", defaultValue="World") String name, Model model) {
    	model.addAttribute("name", name + " --@SampleController");
    	return "hello";
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
