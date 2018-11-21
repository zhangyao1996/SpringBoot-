package com.zhangyao;
/**
* @author zhangyao:
* @date 创建时间：Nov 20, 2018 1:50:38 PM
*/

import java.util.List;

import javax.sql.DataSource;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.zhangyao.dao.StudentDAO;
import com.zhangyao.entity.Student;
import com.zhangyao.service.StudentService;

public class DataSourceTest {
	private ApplicationContext context;
	private StudentDAO studentDAO;
	@Before
	public void setup() {
		context=new ClassPathXmlApplicationContext("beans.xml");
		studentDAO=(StudentDAO) context.getBean("studentDAO");
		System.out.println("setup");
	}
	
	@After
	public void shutdown() {
		context=null;
		System.out.println("shutdown");
	}
	
	@Test
	public void getStudentsTest() {
		List<Student> students=studentDAO.getStudents();
		for (Student student : students) {
			System.out.println(student);
		}
		studentDAO.saveOneStudent();
	}
	
	@Test
	public void testDataSource() {
	DataSource dataSource=(DataSource) context.getBean("datasource");
	Assert.assertNotNull(dataSource);
	}
	
	@Test
	public void testJdbcTemplate() {
	JdbcTemplate jdbcTemplate=(JdbcTemplate) context.getBean("jdbcTemplate");
	Assert.assertNotNull(jdbcTemplate);
	}
}
