package com.zhangyao.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.zhangyao.service.Dessert;

/**
* @author zhangyao:
* @date 创建时间：Nov 15, 2018 11:18:40 AM
*/
@Component
@Primary
public class Cookies implements Dessert {
	

	private Dessert dessert;

	@Autowired
	public void setDessert(Dessert dessert) {
		this.dessert = dessert;
	}
}
