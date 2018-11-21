package com.zhangyao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zhangyao.entity.Girl;

/**
* @author zhangyao:
* @date 创建时间：Sep 10, 2018 2:44:01 PM
*/
public interface GirlRepository extends JpaRepository<Girl, Integer> {
	public List<Girl> getByAge(Integer age);
}
