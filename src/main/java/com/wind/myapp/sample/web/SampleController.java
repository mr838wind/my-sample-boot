package com.wind.myapp.sample.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.wind.myapp.sample.service.SampleService;
import com.wind.myapp.sample.service.SampleVO;

@Controller
public class SampleController {

    @GetMapping("/sample/hello")
    public String greeting(@RequestParam(value="name", defaultValue="World") String name, Model model) {
    	model.addAttribute("name", name + " --@SampleController");
    	return "hello";
    }
    
    
    @Autowired
    SampleService sampleService;
    
    /**
	 * 
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/sample/list")
	public ModelAndView list( HttpServletRequest req ) {
		
		List<SampleVO> list = sampleService.selectList(null);
		
		Map<String,Object> resultMap = new HashMap<>();
		resultMap.put("result", list);
	    
		return new ModelAndView("/sample/list", resultMap);
	}
	
	/**
	 * custom sql 
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/sample/listBySql")
	public ModelAndView listBySql( HttpServletRequest req ) {
		
		List<SampleVO> list = sampleService.selectListBySQL();
		
		Map<String,Object> resultMap = new HashMap<>();
		resultMap.put("result", list);
	    
		return new ModelAndView("/sample/list", resultMap);
	}
	
	/**
	 * 
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/sample/detail/{id}")
	public ModelAndView detail( HttpServletRequest req,
			@PathVariable(name = "id") String id ) {
		
		SampleVO result = sampleService.selectById(id);
		
		Map<String,Object> resultMap = new HashMap<>();
		resultMap.put("result", result);
	    
		return new ModelAndView("/sample/detail", resultMap);
	}
    
    
}
