package com.imooc.sm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imooc.sm.dao.SelfDao;
import com.imooc.sm.dao.StaffDao;
import com.imooc.sm.entity.Staff;
import com.imooc.sm.service.SelfService;

/**
* @author zhangyao:
* @date 创建时间：Aug 29, 2018 10:51:19 AM
*/
@Service("selfService")
public class SelfServiceImpl implements SelfService {
	@Autowired
	private SelfDao selfDao;
	@Autowired
	private StaffDao staffDao;
	public Staff login(String account, String password) {
		// TODO Auto-generated method stub
		Staff staff=selfDao.getStaffByAccount(account);
		if(staff==null) {
			return null;
		}
		if(password.equals(staff.getPassword())) {
			return staff;
		}
		return null;
	}

	public void changePassword(Integer id, String password) {
		Staff staff=staffDao.selectById(id);
		staff.setPassword(password);
		staffDao.update(staff);
	}

}
