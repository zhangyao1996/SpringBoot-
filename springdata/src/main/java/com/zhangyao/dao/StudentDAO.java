package com.zhangyao.dao;
/**
* @author zhangyao:
* @date 创建时间：Nov 20, 2018 10:59:15 AM
*/

import java.util.List;

import com.zhangyao.entity.Student;

public interface StudentDAO {
	List<Student> getStudents();
	
	void saveOneStudent();
}
