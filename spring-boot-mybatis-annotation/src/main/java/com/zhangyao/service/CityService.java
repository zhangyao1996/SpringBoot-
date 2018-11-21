package com.zhangyao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhangyao.entity.City;
import com.zhangyao.mapper.CityMapper;

/**
* @author zhangyao:
* @date 创建时间：Sep 19, 2018 3:11:29 PM
*/
@Service
public class CityService {

	@Autowired
	private CityMapper cityMapper;
	
	public City getCityByName(String name) {
		return cityMapper.findCityByName(name);
	}
}
