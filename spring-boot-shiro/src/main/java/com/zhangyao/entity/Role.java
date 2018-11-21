package com.zhangyao.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
* @author zhangyao:
* @date 创建时间：Oct 17, 2018 11:04:33 AM
*/
@Entity
public class Role {
	@Id
	private Integer id;
	private String userName;
	private String roleName;
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
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	@Override
	public String toString() {
		return "Role [id=" + id + ", userName=" + userName + ", roleName=" + roleName + "]";
	}
	
}
