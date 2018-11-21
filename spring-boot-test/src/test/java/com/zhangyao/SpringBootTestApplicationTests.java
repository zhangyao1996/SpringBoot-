package com.zhangyao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.zhangyao.service.PersonService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootTestApplicationTests {
	
	@Autowired
	private PersonService personService;
	@Test
	public void contextLoads() {
		System.out.println(personService.getPerson(1007));
	}
	@Test
	public void getAll() {
		System.out.println(personService.getPersons());
	}
}
