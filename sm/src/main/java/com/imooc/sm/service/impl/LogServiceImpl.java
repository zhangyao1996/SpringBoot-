package com.imooc.sm.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imooc.sm.dao.LogDao;
import com.imooc.sm.entity.Log;
import com.imooc.sm.service.LogService;

/**
* @author zhangyao:
* @date 创建时间：Aug 29, 2018 2:53:17 PM
*/
@Service("logService")
public class LogServiceImpl implements LogService {
	@Autowired
	private LogDao logDao;
	public void addSystemLog(Log log) {
		// TODO Auto-generated method stub
		log.setOprTime(new Date());
		log.setType("system");
		logDao.insert(log);
	}

	public void addLoginLog(Log log) {
		// TODO Auto-generated method stub
		log.setOprTime(new Date());
		log.setType("login");
		logDao.insert(log);

	}

	public void addOperationLog(Log log) {
		// TODO Auto-generated method stub
		log.setOprTime(new Date());
		log.setType("operation");
		logDao.insert(log);

	}

	public List<Log> getSystemLog() {
		// TODO Auto-generated method stub
		return logDao.selectByType("system");
	}

	public List<Log> getLoginLog() {
		// TODO Auto-generated method stub
		return logDao.selectByType("login");
	}

	public List<Log> getOperationLog() {
		// TODO Auto-generated method stub
		return logDao.selectByType("operation");
	}

}
