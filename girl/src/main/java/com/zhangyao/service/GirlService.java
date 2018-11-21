package com.zhangyao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zhangyao.entity.Girl;
import com.zhangyao.repository.GirlRepository;

/**
* @author zhangyao:
* @date 创建时间：Sep 10, 2018 3:59:24 PM
*/
@Service
public class GirlService {
	
	@Autowired
	private GirlRepository girlRepository;
	//事务管理
	@Transactional
	public void insertTwo() {
		Girl girl1=new Girl();
		girl1.setAge(21);
		girl1.setCupSize("C");
		Girl girl2=new Girl();
		girl2.setAge(22);
		girl2.setCupSize("C");
		girlRepository.save(girl1);
		girlRepository.save(girl2);

	}
}
