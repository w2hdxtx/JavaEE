package com.lv.test;


import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DataSourceTest {

	private ApplicationContext context;
	
	{
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	
	
	@Test
	public void testDataSource() throws Exception {
		
		DataSource dataSource = context.getBean(DataSource.class);
		System.out.println(dataSource.getConnection());
		
	}
	
}
