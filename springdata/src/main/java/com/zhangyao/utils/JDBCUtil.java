package com.zhangyao.utils;
/**
* @author zhangyao:
* @date 创建时间：Nov 20, 2018 10:30:32 AM
*/
/*
 * JDBC工具类
 * 获取Connection
 * 释放资源
 */

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtil {
	/*
	 * 获取JDBC的connection
	 */
	public static Connection getConnection() throws ClassNotFoundException, SQLException, IOException {
		/*
		 * 不建议把配置硬编码到代码中，应该写在配置文件中
		 */
		/*
		 * String driver = "com.mysql.jdbc.Driver"; 
		 * String url ="jdbc:mysql:///spring_data"; 
		 * String username = "root";
		 *  String password ="123456";
		 */
		InputStream inputStream=JDBCUtil.class.getClassLoader().getResourceAsStream("db.properties");
		Properties properties=new Properties();
		properties.load(inputStream);
		String driver = properties.getProperty("jdbc.driver");
		String url = properties.getProperty("jdbc.url");
		String username = properties.getProperty("jdbc.username");
		String password = properties.getProperty("jdbc.password");
		Class.forName(driver);
		Connection connection = DriverManager.getConnection(url, username, password);
		return connection;
	}
	/*
	 * 释放资源
	 */
	public static void release(Connection connection,Statement statement,ResultSet resultSet) {
		if(resultSet!=null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(statement!=null) {
			try {
				statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(connection!=null) {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
