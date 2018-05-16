package com.wind.myapp.sample.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.baomidou.mybatisplus.plugins.Page;
import com.wind.myapp.sample.service.SampleService;
import com.wind.myapp.sample.service.SampleVO;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class RestSampleController {

    @Autowired
    SampleService sampleService;
    
    /**
	 * 
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/ajax/sample/list")
	public List<SampleVO> list() {
		return sampleService.selectListBySQL();
	}
	
	
	/**
	 * paging: 
	 * param: ?size=1&current=1
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/ajax/sample/paging")
	public Page<SampleVO> paging(ModelAndView mv, Page<SampleVO> page) {
		
		Page<SampleVO> pageResult = sampleService.selectPageBySQL(page);
		
		return pageResult;
	}
    
}
