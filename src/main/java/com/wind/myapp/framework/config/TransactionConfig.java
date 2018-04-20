package com.wind.myapp.framework.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement(proxyTargetClass=true) // we have no service interface here: so set proxyTargetClass=true
public class TransactionConfig {

	
}
