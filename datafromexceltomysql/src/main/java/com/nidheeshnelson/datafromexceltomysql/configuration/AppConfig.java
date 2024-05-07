package com.nidheeshnelson.datafromexceltomysql.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.nidheeshnelson.datafromexceltomysql.factory.DataBaseFactory;
import com.nidheeshnelson.datafromexceltomysql.factory.ExcelSheetFactory;
import com.nidheeshnelson.datafromexceltomysql.factory.JSONfactory;

@Configuration
public class AppConfig {
	@Bean
	public JSONfactory DataBaseFactoryBean() 
	{
		return new DataBaseFactory();
	}
	@Bean
	public JSONfactory ExcelSheetFactoryBean() 
	{
		return new ExcelSheetFactory();
	}
}
