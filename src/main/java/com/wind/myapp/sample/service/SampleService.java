package com.wind.myapp.sample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SampleService {

	@Autowired
	SampleMapper sampleMapper;
	
	public List<SampleVO> selectSampleList() { 
		return sampleMapper.selectSampleList();
	}
	
	public SampleVO selectSampleById(String id) { 
		return sampleMapper.selectSampleById(id);
	}
	
}
