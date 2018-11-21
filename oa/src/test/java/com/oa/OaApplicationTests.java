package com.oa;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.oa.mapper.EmployeeMapper;
import com.oa.service.ClaimVoucherService;
import com.oa.service.EmployeeService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OaApplicationTests {
 @Autowired
 private EmployeeService emp;
	@Autowired
	private EmployeeMapper employeeMapper;
	@Autowired
	private ClaimVoucherService claimVoucherService;
 
	@Test
	public void contextLoads() {
		System.out.println(claimVoucherService.getDrByCvid(13));
	}

}
