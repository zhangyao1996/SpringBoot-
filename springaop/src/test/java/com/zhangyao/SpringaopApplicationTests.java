package com.zhangyao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.zhangyao.entity.Product;
import com.zhangyao.security.CurrentUserHolder;
import com.zhangyao.service.ProductService;
import com.zhangyao.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringaopApplicationTests {

	@Autowired
	 private ProductService productService;
	@Autowired
	private UserService userService;
	
	@Test
	public void test1() {
		CurrentUserHolder.set("tom");
		Product product=new Product();
		productService.insert(product);
	}
	@Test
	public void test2() {
		CurrentUserHolder.set("admin");
		Product product=new Product();
		productService.insert(product);
	}
	
	@Test
	public void userServiceTest() {
		userService.insert();
		userService.delete();
	}

}
