package com.zhangyao.service;
/**
* @author zhangyao:
* @date 创建时间：Nov 20, 2018 11:15:35 AM
*/

import java.util.List;

import org.junit.Test;

import com.zhangyao.entity.Student;

public class StudentServiceTest {
	@Test
	public void getStudentsTest() {
		StudentService service=new StudentService();
		List<Student> students=service.getStudents();
		for (Student student : students) {
			System.out.println(student);
		}
	}
	
	@Test
	public void insertOneStudentTest() {
		StudentService service=new StudentService();
		service.saveOneStudent();
	}
	
	
}
