package com.zhangyao;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan("com.zhangyao.mapper")
@ComponentScan
public class SpringBootAjaxServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAjaxServerApplication.class, args);
	}
}
