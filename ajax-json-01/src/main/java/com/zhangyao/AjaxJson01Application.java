package com.zhangyao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class AjaxJson01Application {

	public static void main(String[] args) {
		SpringApplication.run(AjaxJson01Application.class, args);
	}
}
