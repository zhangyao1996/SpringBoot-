package com.zhangyao.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class User {
	@Id
    private Integer id;

    private String username;

    private String password;

    private String nickname;

 
}