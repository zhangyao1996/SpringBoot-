package com.imooc.sm.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.imooc.sm.entity.Log;

/**
* @author zhangyao:
* @date 创建时间：Aug 29, 2018 2:43:44 PM
*/
@Repository("logDao")
public interface LogDao {
	void insert(Log log);
	List<Log> selectByType(String type);
}
