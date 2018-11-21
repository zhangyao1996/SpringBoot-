package com.zhangyao.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zhangyao.dao.StudentDAO;
import com.zhangyao.entity.Student;
import com.zhangyao.utils.JDBCUtil;

/**
* @author zhangyao:
* @date 创建时间：Nov 20, 2018 11:00:25 AM
*/
/*
 * 通过最原始的JDBC的方式操作
 */
public class StudentService implements StudentDAO{

	public List<Student> getStudents() {
		List<Student> students=new ArrayList<Student>();
		Connection connection=null;
		PreparedStatement statement=null;
		ResultSet resultSet=null;
		String sql="SELECT * FROM student";
		try {
			connection=JDBCUtil.getConnection();
			statement=connection.prepareStatement(sql);
			resultSet=statement.executeQuery();
			Student student=null;
			while (resultSet.next()) {
				int id=resultSet.getInt("id");
				String name=resultSet.getString("name");
				int age=resultSet.getInt("age");
				student=new Student();
				student.setId(id);
				student.setName(name);
				student.setAge(age);
				System.out.println(student);
				students.add(student);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.release(connection, statement, resultSet);
		}
		return students;
	}

	public void saveOneStudent() {
		// TODO Auto-generated method stub
		Connection connection=null;
		PreparedStatement statement=null;
		ResultSet resultSet=null;
		String sql="insert into student(name,age) values(?,?)";
		try {
			connection=JDBCUtil.getConnection();
			statement=connection.prepareStatement(sql);
			statement.setString(1, "张三");
			statement.setInt(2, 23);
			statement.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.release(connection, statement, resultSet);
		}
	}

}
