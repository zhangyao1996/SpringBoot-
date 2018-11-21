package com.imooc.hospital.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.imooc.hospital.entity.Dept;

/**
* @author zhangyao:
* @date 创建时间：Aug 30, 2018 9:46:42 AM
*/
@Repository("deptDao")
public interface DeptDao {
	List<Dept> selectAll();
	List<Dept> selectByCategoryId(Integer categoryId);
	void insert(Dept dept);
	Dept selectById(Integer id);
	void deleteById(Integer id);
	void update(Dept dept);
}
