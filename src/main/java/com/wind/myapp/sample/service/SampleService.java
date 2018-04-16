package com.wind.myapp.sample.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

@Service
public class SampleService extends ServiceImpl<SampleMapper, SampleVO>{

	// custom sql 
	public List<SampleVO> selectListBySQL() {
		return this.baseMapper.selectListBySQL();
	}
	
	// custom page sql 
	public Page<SampleVO> selectPageBySQL(Page<SampleVO> page) {
		return page.setRecords(this.baseMapper.selectPageBySQL(page));
	}
	
}
