package com.zhangyao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan("com.zhangyao.web.servlet")
public class DiveInSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiveInSpringBootApplication.class, args);
	}
}
