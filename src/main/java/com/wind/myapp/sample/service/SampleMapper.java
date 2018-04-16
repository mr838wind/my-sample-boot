package com.wind.myapp.sample.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

/**
 */
@Repository
public interface SampleMapper extends BaseMapper<SampleVO>{

	// custom sql 
    List<SampleVO> selectListBySQL();

    // custom page sql
	List<SampleVO> selectPageBySQL(Pagination page);
	
}
