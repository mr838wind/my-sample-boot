package com.wind.myapp.sample.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 */
@Repository
public interface SampleMapper extends BaseMapper<SampleVO>{

	// custom sql 
    List<SampleVO> selectListBySQL();
	
}
