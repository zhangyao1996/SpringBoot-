package com.zhangyao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhangyao.entity.City;
import com.zhangyao.mapper.CityMapper;

/**
 * @author zhangyao:
 * @date 创建时间：Sep 20, 2018 10:01:31 AM
 */
@Service
public class CityService {

	@Autowired
	private CityMapper cityMapper;

	public int insertCity(City city) {
		return cityMapper.insert(city);
	}

	public int deleteById(Integer id) {
		return cityMapper.deleteByPrimaryKey(id);
	}

	public int updateCity(City city) {

		return cityMapper.updateByPrimaryKey(city);

	}
	
	public City getCityById(Integer id) {
		return cityMapper.selectByPrimaryKey(id);
	}
}
