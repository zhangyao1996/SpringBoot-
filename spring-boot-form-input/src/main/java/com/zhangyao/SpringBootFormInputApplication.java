package com.zhangyao;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.zhangyao.mapper")
public class SpringBootFormInputApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootFormInputApplication.class, args);
	}
}
