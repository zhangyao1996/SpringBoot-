package com.zhangyao.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.zhangyao.component.LoginHandlerInterceptor;

/**
* @author zhangyao:
* @date 创建时间：Sep 26, 2018 10:33:41 AM
*/
/*使用WebMvcConfigurerAdapter可以扩展springMVC的功能*/
@Configuration
//全面接管springboot对springMVC的控制
//@EnableWebMvc
public class MyMvcConfig extends WebMvcConfigurerAdapter {
	
	/*
	 * (non-Javadoc)
	 * @see org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter#addViewControllers(org.springframework.web.servlet.config.annotation.ViewControllerRegistry)
	 * 设置默认登陆页面
	 */
/*	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		// TODO Auto-generated method stub
		registry.addViewController("/").setViewName("index");
		registry.addViewController("/main").setViewName("dashboard");
		//设置优先级最高
		registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
		System.out.println("设置登陆页面");
		super.addViewControllers(registry);
	}
	
	 * (non-Javadoc)
	 * @see org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter#addInterceptors(org.springframework.web.servlet.config.annotation.InterceptorRegistry)
	 * 是拦截器生效
	 
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		registry.addInterceptor(new LoginHandlerInterceptor())
		.addPathPatterns("/**")
		.excludePathPatterns("/","/dashboard");
		System.out.println("拦截器生效");
		super.addInterceptors(registry);
		
	}*/
	 //所有的WebMvcConfigurerAdapter组件都会一起起作用
    @Bean //将组件注册在容器
    public WebMvcConfigurerAdapter webMvcConfigurerAdapter(){
        WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("index");
             
                registry.addViewController("/main").setViewName("dashboard");
                System.out.println("设置登陆页面");
            }

            //注册拦截器
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                //super.addInterceptors(registry);
                //静态资源；  *.css , *.js
                //SpringBoot已经做好了静态资源映射
               registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                       .excludePathPatterns("/","/login");
               System.out.println("拦截器生效");
            }
        };
        return adapter;
    }

}
