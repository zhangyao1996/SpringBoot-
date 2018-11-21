package com.zhangyao.utils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import junit.framework.Assert;

/**
* @author zhangyao:
* @date 创建时间：Nov 20, 2018 10:38:59 AM
*/
public class JDBCUtilTest {
	@Test
	public void getConnectionTset() throws ClassNotFoundException, SQLException, IOException {
		Connection connection=JDBCUtil.getConnection();
		Assert.assertNotNull(connection);
		
	}
	
	
}
