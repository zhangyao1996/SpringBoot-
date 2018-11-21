package com.zhangyao.config;

import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
* @author zhangyao:
* @date 创建时间：Sep 18, 2018 2:20:49 PM
*/

/**
 * //匹配ProductService类里头的所有方法
 * @Pointcut("within(com.imooc.service.ProductService)")
 * //匹配com.imooc包及子包下所有类的方法
 * @Pointcut("within(com.imooc..*)")
 * Created by cat on 2017-02-19.
 */
@Component
@Aspect
public class AspectConfig {
	
	
	
	@Pointcut("execution(* com.zhangyao.service.UserService.delete(..))")
	
	public void userServicePoint() {
		
	}
	@Around("userServicePoint()")
	public void beforAdvice() {
		System.out.println("beforAdvice()");
	}
}
