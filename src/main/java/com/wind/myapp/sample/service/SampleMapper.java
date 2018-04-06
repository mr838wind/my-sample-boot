package com.wind.myapp.sample.service;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface SampleMapper {

	//public List<SampleVO> selectSampleList();
	
	@Select("select * from tb_sample")
	List<SampleVO> selectSampleList();
	
}
