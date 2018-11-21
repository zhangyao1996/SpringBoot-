package com.zhangyao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zhangyao.entity.Employee;

/**
* @author zhangyao:
* @date 创建时间：Nov 21, 2018 8:47:38 AM
*/
public interface EmployeeJpaRepository extends JpaRepository<Employee,Integer> {
	

}
