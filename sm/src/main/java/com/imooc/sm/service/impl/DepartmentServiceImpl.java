package com.imooc.sm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imooc.sm.dao.DepartmentDao;
import com.imooc.sm.entity.Department;
import com.imooc.sm.service.DepartmentService;

/**
* @author zhangyao:
* @date 创建时间：Aug 28, 2018 1:46:38 PM
*/
@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService {
	@Autowired
	private DepartmentDao departmentDao;
	
	public void add(Department department) {
		// TODO Auto-generated method stub
		departmentDao.insert(department);
	}

	public void remove(Integer id) {
		// TODO Auto-generated method stub
		departmentDao.delete(id);
	}

	public void edit(Department department) {
		// TODO Auto-generated method stub
		departmentDao.update(department);
	}

	public Department get(Integer id) {
		// TODO Auto-generated method stub
		 return departmentDao.selectById(id);
	}

	public List<Department> getAll() {
		// TODO Auto-generated method stub
		return departmentDao.selectAll();
	}

}
