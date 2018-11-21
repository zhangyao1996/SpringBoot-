package com.zhangyao.aspect;


import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;



/**
* @author zhangyao:
* @date 创建时间：Sep 10, 2018 4:59:54 PM
*/
@Component
@Aspect
public class HttpAspect {
	private static Logger logger= LoggerFactory.getLogger(HttpAspect.class);
	@Pointcut("execution(public * com.zhangyao.controller.GirlController.*(..))")
	public void log() {}
	
	@Before("log()")
	public void before(JoinPoint joinPoint) {
		 ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
	        HttpServletRequest request = attributes.getRequest();
	 
	        //url
	        logger.info("url={}", request.getRequestURL());

	        //method
	        logger.info("method={}", request.getMethod());

	        //ip
	        logger.info("ip={}", request.getRemoteAddr());

	        //类方法
	        logger.info("class_method={}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());

	        //参数
	        logger.info("args={}", joinPoint.getArgs());
	}
	
	@After("execution(public * com.zhangyao.controller.GirlController.*(..))")
	public void after() {
		logger.info("222222222");
	}
	
	@AfterReturning(returning = "object", pointcut = "log()")
    public void doAfterReturning(Object object) {
        logger.info("response={}", object.toString());
    }
}
