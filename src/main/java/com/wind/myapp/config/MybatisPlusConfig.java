package com.wind.myapp.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.wind.myapp.*.service")
public class MybatisPlusConfig {


}
