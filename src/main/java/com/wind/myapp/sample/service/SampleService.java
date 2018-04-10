package com.wind.myapp.sample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SampleService {

	@Autowired
	SampleDAO sampleMapper;
	
	public List<SampleVO> selectSampleList() { 
		return sampleMapper.selectSampleList();
	}
	
	public SampleVO selectSampleById(String id) { 
		return sampleMapper.selectSampleById(id);
	}
	
	
	public List<SampleVO> selectSampleListForScript(String[] ids) { 
		return sampleMapper.selectSampleListForScript(ids);
	}
	
}
