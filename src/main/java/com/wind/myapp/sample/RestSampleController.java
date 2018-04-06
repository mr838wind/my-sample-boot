package com.wind.myapp.sample;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestSampleController {

    private static final String template = "Hello, %s! --@RestSampleController";

    @RequestMapping("/rest/sample/hello")
    public String greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return String.format(template, name);
    }
}
