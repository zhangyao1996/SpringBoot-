package com.zhangyao.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
* @author zhangyao:
* @date 创建时间：Oct 17, 2018 11:04:33 AM
*/
@Entity
public class User {
	@Id
	private Integer id;
	private String userName;
	private String password;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", password=" + password + "]";
	}
	
	
	
}
