package com.zhangyao.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;

import com.zhangyao.dao.StudentDAO;
import com.zhangyao.entity.Student;

/**
 * @author zhangyao:
 * @date 创建时间：Nov 20, 2018 2:02:44 PM
 */
/*
 * 通过Spring的JdbcTemplate模版的方式操作
 */
public class StudentJdbcTemplateService implements StudentDAO {
	private JdbcTemplate jdbcTemplate;

	public List<Student> getStudents() {
		final List<Student> students = new ArrayList<Student>();
        String sql = "select id, name , age from student";

        jdbcTemplate.query(sql, new RowCallbackHandler(){

            public void processRow(ResultSet rs) throws SQLException {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");

                Student student = new Student();
                student.setId(id);
                student.setName(name);
                student.setAge(age);

                students.add(student);
            }
        });

        return students;
	}

	public void saveOneStudent() {
		String sql="insert into student(name,age) values(?,?)";
		jdbcTemplate.update(sql,new Object[] {"李四",25});
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}
