package com.zhangyao.repository;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;

import com.zhangyao.entity.Employee;
import com.zhangyao.service.EmployeeService;

/**
 * @author zhangyao:
 * @date 创建时间：Nov 20, 2018 3:12:22 PM
 */
public class EmployeeRepositoryTest {
	private ApplicationContext context;

	private EmployeeRepository empRepository;

	private EmployeeService employeeService;

	@Before
	public void setup() {
		context = new ClassPathXmlApplicationContext("beans-new.xml");
		empRepository = context.getBean(EmployeeRepository.class);
		employeeService = context.getBean(EmployeeService.class);
		System.out.println("setup");
	}

	@After
	public void shutdown() {
		context = null;
		System.out.println("shutdown");
	}

	@Test
	public void test() {
		/*
		 * List<Employee>
		 * employees=empRepository.findByNameStartingWithAndAgeLessThan("test",22); for
		 * (Employee employee : employees) { System.out.println(employee); }
		 */
		List<Employee> employees = new ArrayList<Employee>();
		Employee employee = null;
		for (int i = 0; i < 100; i++) {
			employee = new Employee();
			employee.setAge(i + 20);
			employee.setName("test0" + i);
			employees.add(employee);
		}

		employeeService.save(employees);
	}

	
	@Test
	public void test2() {
		
		Order orders=new Order(Direction.DESC,"id");
		Sort sort=new Sort(orders);
		
		Pageable pageable=new PageRequest(0, 5,sort);
		Page<Employee> page=employeeService.findAll(pageable);
		System.out.println("查询总页数"+page.getTotalPages());
		System.out.println("查询总记录数"+page.getTotalElements());

		
		System.out.println("查询的当前第几页"+page.getNumber());
		System.out.println("查询当前页面的集合"+page.getContent());
		System.out.println("查询当前页面的记录数"+page.getNumberOfElements());


	}
}
