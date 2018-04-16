package com.wind.myapp.sample.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.baomidou.mybatisplus.plugins.Page;
import com.wind.myapp.sample.service.SampleService;
import com.wind.myapp.sample.service.SampleVO;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class SampleController {

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
	 * paging
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/sample/paging")
	public ModelAndView paging( HttpServletRequest req ) {
		
		Page<SampleVO> page = sampleService.selectPage(new Page<SampleVO>(2, 2));
		List<SampleVO> list = page.getRecords();
		log.info(">>>> select paging: {}", list.size()); 
		
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
