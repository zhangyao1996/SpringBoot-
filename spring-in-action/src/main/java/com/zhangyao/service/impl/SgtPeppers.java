package com.zhangyao.service.impl;

import org.springframework.stereotype.Component;

import com.zhangyao.service.CompactDisc;

/**
* @author zhangyao:
* @date 创建时间：Nov 15, 2018 9:06:47 AM
*/
@Component
public class SgtPeppers implements CompactDisc {

	@Override
	public void play() {
		// TODO Auto-generated method stub
		System.out.println("play music by beatles");
	}

}
