package com.zhangyao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class AjaxJson02Application {

	public static void main(String[] args) {
		SpringApplication.run(AjaxJson02Application.class, args);
	}
}
