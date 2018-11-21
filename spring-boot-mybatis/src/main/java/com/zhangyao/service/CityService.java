package com.zhangyao.service;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;


import com.zhangyao.entity.City;
import com.zhangyao.mapper.CityMapper;

/**
 * @author zhangyao:
 * @date 创建时间：Sep 19, 2018 2:26:56 PM
 */
@Service
public class CityService {

	private static final Logger LOGGER = LoggerFactory.getLogger(CityService.class);
	
	@Autowired
	private CityMapper cityMapper;

	@Autowired
	private RedisTemplate redisTemplate;
	
	/**
     * 获取城市逻辑：
     * 如果缓存存在，从缓存中获取城市信息
     * 如果缓存不存在，从 DB 中获取城市信息，然后插入缓存
     */
    public City findCityById(Integer id) {
        // 从缓存中获取城市信息
        String key = ""+ id;
        ValueOperations<String, City> operations = redisTemplate.opsForValue();

        // 缓存存在
        boolean hasKey = redisTemplate.hasKey(key);
        if (hasKey) {
            City city = operations.get(key);

            LOGGER.info("CityServiceImpl.findCityById() : 从缓存中获取了城市 >> " + city.toString());
            return city;
        }

        // 从 DB 中获取城市信息
        City city = cityMapper.selectByPrimaryKey(id);

        // 插入缓存
        operations.set(key, city, 10, TimeUnit.SECONDS);
        LOGGER.info("CityServiceImpl.findCityById() : 城市插入缓存 >> " + city.toString());

        return city;
    }

   
    public Integer saveCity(City city) {
        return cityMapper.insert(city);
    }

    /**
     * 更新城市逻辑：
     * 如果缓存存在，删除
     * 如果缓存不存在，不操作
     */
  
    public Integer updateCity(City city) {
        Integer ret = cityMapper.updateByPrimaryKey(city);

        // 缓存存在，删除缓存
        String key = "" + city.getId();
        boolean hasKey = redisTemplate.hasKey(key);
        if (hasKey) {
            redisTemplate.delete(key);

            LOGGER.info("CityServiceImpl.updateCity() : 从缓存中删除城市 >> " + city.toString());
        }

        return ret;
    }

  
    public Integer deleteCity(Integer id) {

    	Integer ret = cityMapper.deleteByPrimaryKey(id);

        // 缓存存在，删除缓存
        String key = "" + id;
        boolean hasKey = redisTemplate.hasKey(key);
        if (hasKey) {
            redisTemplate.delete(key);

            LOGGER.info("CityServiceImpl.deleteCity() : 从缓存中删除城市 ID >> " + id);
        }
        return ret;
    }

}
