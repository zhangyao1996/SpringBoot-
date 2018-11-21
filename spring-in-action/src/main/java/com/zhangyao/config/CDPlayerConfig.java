package com.zhangyao.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
* @author zhangyao:
* @date 创建时间：Nov 15, 2018 10:26:48 AM
*/
@Configuration
class CDPlayerConfig {
	@Bean
	public CdPlayer cdPlayer() {
		return new CdPlayer();
	}
}
