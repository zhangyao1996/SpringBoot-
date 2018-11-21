package com.imooc.sm.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.imooc.sm.entity.Staff;

/**
* @author zhangyao:
* @date 创建时间：Aug 28, 2018 4:31:09 PM
*/
@Repository("staffDao")
public interface StaffDao {
	void insert(Staff staff);
	void delete(Integer id);
	void update(Staff staff);
	Staff selectById(Integer id);
	List<Staff> selectAll();
}
