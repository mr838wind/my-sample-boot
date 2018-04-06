package com.wind.myapp.sample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SampleService {

	@Autowired
	SampleDAO sampleDAO;
	
	public List<SampleVO> selectSampleList() {
		return sampleDAO.selectSampleList();
	}
	
	
}
