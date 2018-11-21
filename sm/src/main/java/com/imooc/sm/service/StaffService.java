package com.imooc.sm.service;

import java.util.List;

import com.imooc.sm.entity.Staff;

/**
* @author zhangyao:
* @date 创建时间：Aug 28, 2018 4:43:28 PM
*/
public interface StaffService {
	public void add(Staff staff);
	public void remove(Integer id);
	public void edit(Staff staff);
	public Staff getById(Integer id);
	public List<Staff> getAll();
}
