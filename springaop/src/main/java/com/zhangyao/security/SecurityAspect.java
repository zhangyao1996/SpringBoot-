package com.zhangyao.security;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zhangyao.service.AuthService;

/**
* @author zhangyao:
* @date 创建时间：Sep 18, 2018 1:43:39 PM
*/
@Aspect
@Component
public class SecurityAspect {
	@Autowired
	private AuthService authService;
	@Pointcut("@annotation(AdminOnly)")
	public void admin() {
		
	}
	
	@Before("admin()")
	public void beforeAdvice(){
		authService.checkAccess();
	}
}
