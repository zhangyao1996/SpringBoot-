package com.zhangyao.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
* @author zhangyao:
* @date 创建时间：Sep 13, 2018 10:49:47 AM
*/
@Configuration
public class WebMvcConfigurer extends WebMvcConfigurerAdapter {
	@Autowired
	private MyConfig myconfig;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		registry.addInterceptor(myconfig).addPathPatterns("/th/**");
		super.addInterceptors(registry);
	}
	

}
