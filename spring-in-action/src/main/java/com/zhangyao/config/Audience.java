package com.zhangyao.config;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
* @author zhangyao:
* @date 创建时间：Nov 15, 2018 4:12:50 PM
*/
/*
 * 切面
 */
@Aspect
@Component
public class Audience {
	@Pointcut("execution(* com.zhangyao.service.Performance.perform(..))")
	public void performance() {}
	
	@Before("performance()")
	public void takeSeates() {
		System.out.println("Taking seats");
	}

	@After("performance()")
	public void applause() {
		System.out.println("CLAP CLAP CLAP!!!");
	}
}
