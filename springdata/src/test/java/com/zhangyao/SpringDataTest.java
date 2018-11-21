package com.zhangyao;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zhangyao.dao.StudentDAO;

/**
* @author zhangyao:
* @date 创建时间：Nov 20, 2018 2:56:39 PM
*/
public class SpringDataTest {
	private ApplicationContext context;
	
	@Before
	public void setup() {
		context=new ClassPathXmlApplicationContext("beans-new.xml");

		System.out.println("setup");
	}
	
	@After
	public void shutdown() {
		context=null;
		System.out.println("shutdown");
	}
	
	@Test
	public void test() {
		
	}
}
