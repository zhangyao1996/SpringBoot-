package com.imooc.sm.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imooc.sm.dao.StaffDao;
import com.imooc.sm.entity.Staff;
import com.imooc.sm.service.StaffService;

/**
* @author zhangyao:
* @date 创建时间：Aug 28, 2018 4:45:43 PM
*/
@Service("staffService")
public class StaffServiceImpl implements StaffService {
	@Autowired
	private StaffDao staffDao;
	public void add(Staff staff) {
		// TODO Auto-generated method stub
		staff.setPassword("123456");
		staff.setWorkTime(new Date());
		staff.setStatus("normal");
		 staffDao.insert(staff);
	}

	public void remove(Integer id) {
		// TODO Auto-generated method stub
		staffDao.delete(id);
	}

	public void  edit(Staff staff) {
		// TODO Auto-generated method stub
		 staffDao.update(staff);
		 System.out.println("修改员工信息");
	}

	public Staff getById(Integer id) {
		// TODO Auto-generated method stub
		return staffDao.selectById(id);
	}

	public List<Staff> getAll() {
		// TODO Auto-generated method stub
		return staffDao.selectAll();
	}

}
