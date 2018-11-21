package com.imooc.sm.dao;

import org.springframework.stereotype.Repository;

import com.imooc.sm.entity.Staff;

/**
* @author zhangyao:
* @date 创建时间：Aug 29, 2018 10:42:21 AM
*/
@Repository("selfDao")
public interface SelfDao {
	Staff getStaffByAccount(String account);

}
