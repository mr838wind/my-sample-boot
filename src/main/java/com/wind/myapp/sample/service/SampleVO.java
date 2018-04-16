package com.wind.myapp.sample.service;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import lombok.Data;

@Data
@TableName("tb_sample") 
public class SampleVO  {

	@TableId
	private String id;
	private String name;
	
}
