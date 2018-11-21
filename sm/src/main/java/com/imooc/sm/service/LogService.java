package com.imooc.sm.service;

import java.util.List;

import com.imooc.sm.entity.Log;

/**
* @author zhangyao:
* @date 创建时间：Aug 29, 2018 2:51:43 PM
*/
public interface LogService {
	 	void addSystemLog(Log log);
	    void addLoginLog(Log log);
	    void addOperationLog(Log log);

	    List<Log> getSystemLog();
	    List<Log> getLoginLog();
	    List<Log> getOperationLog(); 
}
