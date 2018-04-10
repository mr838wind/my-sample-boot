package com.wind.myapp.sample.service;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * SampleDAO: 
 * Mapper방식,SqlSession방식 모두 OK.
 * 		interface using @Mapper,
 * 		class  using @Autowired SqlSession .
 * @author windfall
 *
 */
@Repository
@Mapper
public interface SampleDAO {

	public List<SampleVO> selectSampleList();
	
	public SampleVO selectSampleById(@Param("id") String id);
	
	public List<SampleVO> selectSampleListForScript(@Param("ids") String[] ids);
	
	
}
