package com.zhangyao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhangyao.entity.Product;
import com.zhangyao.security.AdminOnly;

/**
* @author zhangyao:
* @date 创建时间：Sep 18, 2018 11:02:42 AM
*/
@Service
public class ProductService {
	/*@Autowired
	private AuthService authService;*/

	@AdminOnly
	public void insert(Product product) {
		//authService.checkAccess();
		System.out.println("insert操作");
	}
	@AdminOnly
	public void delete(Long id) {
		//authService.checkAccess();
		System.out.println("delete操作");
	}
}

