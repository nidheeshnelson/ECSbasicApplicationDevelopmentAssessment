package com.nidheeshnelson.datafromexceltomysql.factory;

import org.springframework.stereotype.Component;

import com.nidheeshnelson.datafromexceltomysql.product.JSON;
import com.nidheeshnelson.datafromexceltomysql.product.JSONfromExcelSheet;
@Component
public class ExcelSheetFactory implements JSONfactory 
{
	@Override
	public JSON createJSON() 
	{
		return new JSONfromExcelSheet();
	}
}
