package com.imooc.hospital.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imooc.hospital.dao.DeptDao;
import com.imooc.hospital.entity.Dept;
import com.imooc.hospital.service.DeptService;

/**
* @author zhangyao:
* @date 创建时间：Aug 30, 2018 9:51:16 AM
*/
@Service("deptService")
public class DeptServiceImpl implements DeptService {
	
	@Autowired
	private DeptDao deptDao;
	public List<Dept> getAll() {
		// TODO Auto-generated method stub
		return deptDao.selectAll();
	}
	public List<Dept> getByCategoryId(Integer categoryId) {
		// TODO Auto-generated method stub
		return deptDao.selectByCategoryId(categoryId);
	}
	public void add(Dept dept) {
		// TODO Auto-generated method stub
		deptDao.insert(dept);
	}
	public Dept getById(Integer id) {
		// TODO Auto-generated method stub
		return deptDao.selectById(id);
	}
	public void remove(Integer id) {
		// TODO Auto-generated method stub
		deptDao.deleteById(id);
	}
	public void edit(Dept dept) {
		// TODO Auto-generated method stub
		deptDao.update(dept);
		
	}

}
