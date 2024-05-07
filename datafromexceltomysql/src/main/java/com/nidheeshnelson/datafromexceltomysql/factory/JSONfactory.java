package com.nidheeshnelson.datafromexceltomysql.factory;

import org.springframework.stereotype.Component;

import com.nidheeshnelson.datafromexceltomysql.product.JSON;
@Component
public interface JSONfactory 
	{
		public JSON createJSON();
	}
