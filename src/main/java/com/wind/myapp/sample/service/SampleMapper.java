package com.wind.myapp.sample.service;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface SampleMapper {

	@Select(" select * from tb_sample ")
	public List<SampleVO> selectSampleList();
	
	@Select(" select * from tb_sample where id = #{id} ")
	public SampleVO selectSampleById(@Param("id") String id);
	
	
	
	//=== include example
	public static final String INCLUDE_WHERE =
			 "	WHERE id IN									" 
			+"		<foreach item='item' collection='ids'	"
			+"			open='(' separator=',' close=')'>	"
			+"		#{item}									"
			+"	</foreach>									"
	;
	
	//=== xml script version
	@Select({"<script>"
	,"	SELECT *									" 
	,"	FROM tb_sample								"
	,INCLUDE_WHERE
    ,"</script>"})
	public List<SampleVO> selectSampleListForScript(@Param("ids") String[] ids);
	
	
	
	//=== selectProvider ...
	@SelectProvider(type = SqlBuilder.class, method = "build")
	List<SampleVO> selectSampleListForSelectProvider(String name);

	class SqlBuilder {
	  public static String build(final String name) {
	    return new SQL(){{
	      SELECT("*");
	      FROM("tb_sample");
	      if (name != null) {
	        WHERE("name like #{value} || '%'");
	      }
	      ORDER_BY("id");
	    }}.toString();
	  }
	}
	
	
	
}
