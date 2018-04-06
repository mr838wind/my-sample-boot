package com.wind.myapp.sample.service;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SampleDAO {

	@Autowired
	SqlSession sqlSession;
	
	private final String NS = this.getClass().getSimpleName() + ".";

	public List<SampleVO> selectSampleList() {
		return sqlSession.selectList(NS + "selectSampleList", new HashMap<>());
	}
	
	
}
