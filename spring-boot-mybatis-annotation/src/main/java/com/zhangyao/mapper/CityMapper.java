package com.zhangyao.mapper;


import org.apache.ibatis.annotations.*;

import com.zhangyao.entity.City;

public interface CityMapper {
  
	@Select("select * from city where city_name=#{name}")
	@Results({
     @Result(property = "id", column = "id"),
     @Result(property = "provinceId", column = "province_id"),
     @Result(property = "cityName", column = "city_name"),
     @Result(property = "description", column = "description"),
 	})
	City findCityByName(String name);
}