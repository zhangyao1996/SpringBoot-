package com.imooc.hospital.entity;
/**
* @author zhangyao:
* @date 创建时间：Aug 29, 2018 3:57:38 PM
*/
public class Users {
	private	Integer id;
	private String username;
	private String password;
	public Users() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
