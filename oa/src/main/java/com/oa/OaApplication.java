package com.oa;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
//事务注解
@EnableTransactionManagement
@ComponentScan/*(basePackages={"com.oa.controller","com.oa.service"})*/
@MapperScan("com.oa.mapper")
/*
 * 在 SpringBootApplication 上使用@ServletComponentScan 注解后，
 * Servlet、Filter、Listener 可以直接通过 @WebServlet、@WebFilter、@WebListener 注解自动注册，无需其他代码。
 */
@ServletComponentScan
public class OaApplication {

	public static void main(String[] args) {
		SpringApplication.run(OaApplication.class, args);
	}
}
