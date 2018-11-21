package com.zhangyao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhangyao.entity.Person;
import com.zhangyao.mapper.PersonMapper;

/**
* @author zhangyao:
* @date 创建时间：Sep 19, 2018 11:04:06 AM
*/
@Service
public class PersonService {
	@Autowired
	private PersonMapper personMapper;
	
	public Person getPerson(Integer id) {
		return personMapper.selectByPrimaryKey(id);
	}

	public List<Person> getPersons(){
		return personMapper.selectAll();
	}
}
