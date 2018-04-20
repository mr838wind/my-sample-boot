package com.wind.myapp.sample.web;

import java.util.List;

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
	public ModelAndView list(ModelAndView mv) {
		mv.setViewName("sample/list");
		
		List<SampleVO> list = sampleService.selectList(null);
		
		mv.addObject("result", list);
		
		return mv;
	}
	
	/**
	 * custom sql 
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/sample/listBySql")
	public ModelAndView listBySql(ModelAndView mv) {
		mv.setViewName("sample/list");
		
		List<SampleVO> list = sampleService.selectListBySQL();
		
		mv.addObject("result", list);
	    
		return mv;
	}
	
	/**
	 * paging: 
	 * param: ?size=1&current=1
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/sample/paging")
	public ModelAndView paging(ModelAndView mv, Page<SampleVO> page) {
		mv.setViewName("sample/paging");
		
		Page<SampleVO> pageResult = sampleService.selectPage(page);
		
		mv.addObject("result", pageResult);
	    
		return mv;
	}
	
	/**
	 * custom paging
	 * param: ?size=1&current=1
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/sample/pageBySQL")
	public ModelAndView selectPageBySQL(ModelAndView mv, Page<SampleVO> page) {
		mv.setViewName("sample/paging");
		
		Page<SampleVO> pageResult = sampleService.selectPageBySQL(page);
		
		mv.addObject("result", pageResult);
	    
		return mv;
	}
	
	
	/**
	 * detail
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/sample/detail/{id}")
	public ModelAndView detail(ModelAndView mv, 
			@PathVariable(name = "id") String id ) {
		mv.setViewName("sample/detail");
		
		SampleVO result = sampleService.selectById(id);
		
		mv.addObject("result", result);
	    
		return mv;
	}
    
    
}
