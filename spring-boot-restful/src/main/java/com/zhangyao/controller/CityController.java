package com.zhangyao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zhangyao.entity.City;
import com.zhangyao.service.CityService;

/**
* @author zhangyao:
* @date 创建时间：Sep 20, 2018 10:05:55 AM
*/
@RestController
public class CityController {

	
	@Autowired
	private CityService cityService;
	
	
	@PostMapping("/api/city")
	public int addCity(@RequestBody City city) {
		return cityService.insertCity(city);
	}
	
	
	@DeleteMapping("/api/city/{id}")
	public int deleteCity(@PathVariable("id")Integer id) {
		return cityService.deleteById(id);
	}
	
	
	@PutMapping("/api/city")
	public int updateCity(@RequestBody City city) {
		return cityService.updateCity(city);
	}
	
	@GetMapping("/api/city/{id}")
	public City selectCity(@PathVariable("id")Integer id) {
		return cityService.getCityById(id);
	}
}
