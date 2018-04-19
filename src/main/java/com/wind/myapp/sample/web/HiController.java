package com.wind.myapp.sample.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HiController {

    /**
     * hello
     * @param name
     * @param model
     * @return
     */
    @GetMapping("/hi")
    public String greeting(@RequestParam(value="name", defaultValue="World") String name, Model model) {
    	model.addAttribute("name", name + " --@SampleController");
    	return "hi";
    }
    
}
