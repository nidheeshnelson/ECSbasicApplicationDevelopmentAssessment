package com.nidheeshnelson.datafromexceltomysql.factory;

import org.springframework.stereotype.Component;

import com.nidheeshnelson.datafromexceltomysql.product.JSON;
import com.nidheeshnelson.datafromexceltomysql.product.JSONfromDataBase;
@Component
public class DataBaseFactory implements JSONfactory 
{
	@Override
	public JSON createJSON() 
	{
		return new JSONfromDataBase();
	}
}
