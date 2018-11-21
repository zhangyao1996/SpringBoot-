package com.imooc;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.imooc.controller.MyController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyspringbootApplicationTests {
	@Value("${com.didispace.blog.number}")
	Integer num;
	
	@Test
	public void contextLoads() {
		System.out.println(num);
	}
	
	@Test
	public void test() {
		MyController myController=new MyController();
		assertEquals("home", myController.out());
	}

}
