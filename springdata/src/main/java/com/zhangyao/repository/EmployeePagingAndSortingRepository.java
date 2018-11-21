package com.zhangyao.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.zhangyao.entity.Employee;

/**
* @author zhangyao:
* @date 创建时间：Nov 20, 2018 5:08:12 PM
*/
public interface EmployeePagingAndSortingRepository extends PagingAndSortingRepository<Employee, Integer> {

}
