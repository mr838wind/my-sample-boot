package com.wind.myapp.sample.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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
	public String list(Model model) {
		
		List<SampleVO> list = sampleService.selectList(null);
		
		model.addAttribute("result", list);
	    
		return "sample/list";
	}
	
	/**
	 * custom sql 
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/sample/listBySql")
	public String listBySql(Model model) {
		
		List<SampleVO> list = sampleService.selectListBySQL();
		
		model.addAttribute("result", list);
	    
		return "sample/list";
	}
	
	/**
	 * paging: 
	 * param: ?size=1&current=1
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/sample/paging")
	public String paging(Model model, Page<SampleVO> page) {
		
		Page<SampleVO> pageResult = sampleService.selectPage(page);
		
		model.addAttribute("result", pageResult);
	    
		return "sample/paging";
	}
	
	/**
	 * custom paging
	 * param: ?size=1&current=1
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/sample/pageBySQL")
	public String selectPageBySQL(Model model, Page<SampleVO> page) {
		
		Page<SampleVO> pageResult = sampleService.selectPageBySQL(page);
		
		model.addAttribute("result", pageResult);
	    
		return "sample/paging";
	}
	
	
	/**
	 * 
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/sample/detail/{id}")
	public String detail(Model model, 
			@PathVariable(name = "id") String id ) {
		
		SampleVO result = sampleService.selectById(id);
		
		model.addAttribute("result", result);
	    
		return "sample/detail";
	}
    
    
}
