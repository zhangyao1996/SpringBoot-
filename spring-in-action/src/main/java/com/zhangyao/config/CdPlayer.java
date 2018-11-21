package com.zhangyao.config;
/**
* @author zhangyao:
* @date 创建时间：Nov 15, 2018 9:46:35 AM
*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zhangyao.service.CompactDisc;

public class CdPlayer {
	@Autowired
	CompactDisc cDisc;
	public void player() {
		cDisc.play();
	}
}
