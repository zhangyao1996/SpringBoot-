package com.zhangyao.service;



import org.springframework.stereotype.Service;

import com.zhangyao.security.CurrentUserHolder;

/**
* @author zhangyao:
* @date 创建时间：Sep 18, 2018 11:19:04 AM
*/
@Service
public class AuthService {
	
	public void checkAccess() {
		String user=CurrentUserHolder.get();
		if(!"admin".equals(user)) {
			throw new RuntimeException("operation not allow");
		}
	}
}
