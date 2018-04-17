package com.wind.myapp.sample.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public ModelAndView list() {
		
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
	public ModelAndView listBySql() {
		
		List<SampleVO> list = sampleService.selectListBySQL();
		
		Map<String,Object> resultMap = new HashMap<>();
		resultMap.put("result", list);
	    
		return new ModelAndView("/sample/list", resultMap);
	}
	
	/**
	 * paging: 
	 * param: ?size=1&current=1
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/sample/paging")
	public ModelAndView paging(Page<SampleVO> page) {
		
		Page<SampleVO> pageResult = sampleService.selectPage(page);
		
		Map<String,Object> resultMap = new HashMap<>();
		resultMap.put("result", pageResult);
	    
		return new ModelAndView("/sample/paging", resultMap);
	}
	
	/**
	 * custom paging
	 * param: ?size=1&current=1
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/sample/pageBySQL")
	public ModelAndView selectPageBySQL(Page<SampleVO> page) {
		
		Page<SampleVO> pageResult = sampleService.selectPageBySQL(page);
		
		Map<String,Object> resultMap = new HashMap<>();
		resultMap.put("result", pageResult);
	    
		return new ModelAndView("/sample/paging", resultMap);
	}
	
	
	/**
	 * 
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/sample/detail/{id}")
	public ModelAndView detail(
			@PathVariable(name = "id") String id ) {
		
		SampleVO result = sampleService.selectById(id);
		
		Map<String,Object> resultMap = new HashMap<>();
		resultMap.put("result", result);
	    
		return new ModelAndView("/sample/detail", resultMap);
	}
    
    
}
