package com.zhangyao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zhangyao.entity.City;
import com.zhangyao.service.CityService;

/**
 * @author zhangyao:
 * @date 创建时间：Sep 19, 2018 2:27:37 PM
 */
@RestController
public class CityController {

	@Autowired
	private CityService cityService;

	@RequestMapping(value = "/api/city/{id}", method = RequestMethod.GET)
	public City findOneCity(@PathVariable("id") Integer id) {
		return cityService.findCityById(id);
	}

	@RequestMapping(value = "/api/city", method = RequestMethod.POST)

	public void createCity(@RequestBody City city) {
		cityService.saveCity(city);
	}

	@RequestMapping(value = "/api/city", method = RequestMethod.PUT)
	public void modifyCity(@RequestBody City city) {
		cityService.updateCity(city);
	}

	@RequestMapping(value = "/api/city/{id}", method = RequestMethod.DELETE)
	public void modifyCity(@PathVariable("id") Integer id) {
		cityService.deleteCity(id);
	}

}
