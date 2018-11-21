package com.zhangyao;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.zhangyao.mapper")
public class SpringBootTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootTestApplication.class, args);
	}
}
