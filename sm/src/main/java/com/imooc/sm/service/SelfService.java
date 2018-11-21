package com.imooc.sm.service;
/**
* @author zhangyao:
* @date 创建时间：Aug 29, 2018 10:48:37 AM
*/


import com.imooc.sm.entity.Staff;

public interface SelfService {
	Staff login(String account,String password);
	void changePassword(Integer id,String password);
}
