package com.zhangyao.test1;



import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

import com.zhangyao.config.Audience;
import com.zhangyao.config.CdPlayer;
import com.zhangyao.service.Dessert;
import com.zhangyao.service.Performance;
import com.zhangyao.service.impl.Cake;
import com.zhangyao.service.impl.Cookies;
import com.zhangyao.service.impl.PerformanceImpl;
import com.zhangyao.service.impl.SgtPeppers;


@RunWith(SpringRunner.class)
@SpringBootTest
@ComponentScan
@EnableAspectJAutoProxy//启用AspectJ代理
public class SpringInActionApplicationTests {


	@Autowired
	private SgtPeppers sgtPeppers;
	
	@Autowired
	private CdPlayer CdPlayer;
//	
	@Autowired
	private Cake cake;
	@Autowired
	private Cookies cookies;

	@Autowired
	private Audience audience;
	@Test
	public void test1() {
		
		sgtPeppers.play();
		CdPlayer.player();
	}
	@Autowired
	private Performance performance;
	@Test
	public void test2() {
		performance.perform();
	}
	

}
