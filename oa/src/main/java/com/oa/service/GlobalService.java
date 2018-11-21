package com.oa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oa.entity.Employee;
import com.oa.mapper.EmployeeMapper;

/**
* @author zhangyao:
* @date 创建时间：Sep 28, 2018 10:26:36 AM
*/
@Service
public class GlobalService {
	
	@Autowired
	private EmployeeMapper employeeMapper;
	public Employee login(String sn,String password) {
		Employee employee=employeeMapper.selectByPrimaryKey(sn);
		System.out.println("service的"+employee);
		if(employee!=null&&employee.getPassword().equals(password)) {
			return employee;
		}
		return null;
	}

}
