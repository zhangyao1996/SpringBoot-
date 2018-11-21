package com.zhangyao.controller;

import static org.hamcrest.CoreMatchers.nullValue;

import java.util.List;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zhangyao.entity.Girl;
import com.zhangyao.entity.Result;
import com.zhangyao.repository.GirlRepository;
import com.zhangyao.service.GirlService;

/**
* @author zhangyao:
* @date 创建时间：Sep 10, 2018 2:45:21 PM
*/
@RestController
@RequestMapping("/girl")
public class GirlController {

	@Autowired
	private GirlRepository girlRepository;
	@Autowired
	private GirlService girlService;
	
	/*
	 * 获取girl数据并返回json类型
	 */
	@GetMapping("/list")
	public List<Girl> getGirls(){
		return girlRepository.findAll();
	}
	/*
	 * 增加girl
	 */
	@PostMapping("/list")
	public Object addGirl(@Valid Girl girl,BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			Result result=new Result();
			result.setCode(1);
			result.setMsg(bindingResult.getFieldError().getDefaultMessage());
			result.setDate(null);
			return result;
		}
		//girl.setAge(girl.getAge());
		//girl.setCupSize(girl.getCupSize());
		//girl.setMoney(girl.getMoney());
		Result result=new Result();
		result.setCode(0);
		result.setMsg("成功");
		result.setDate(girlRepository.save(girl));
		return result;
	}
	/*
	 * 通过id获取girl
	 */
	@GetMapping("/list/{id}")
	public Girl getById(@PathVariable("id") Integer id) {
		return girlRepository.findById(id).get();
	}
	/*
	 * 通过id修改girl
	 */
	@PutMapping("/list/{id}")
	public Girl updateById(@PathVariable("id") Integer id,@RequestParam("age")Integer 	age,@RequestParam("cupSize")String cupSize) {
		
		Girl girl=new Girl();
		girl.setId(id);
		girl.setAge(age);
		girl.setCupSize(cupSize);
		
		return girlRepository.save(girl);
		
	}
	@DeleteMapping("/list/{id}")
	public void deleteById(@PathVariable("id") Integer id) {
		girlRepository.deleteById(id);
	}
	
	@GetMapping("/list/age/{age}")
	public List<Girl> getByAge(@PathVariable("age") Integer age) {
		return girlRepository.getByAge(age);
		
	}
	
	@PostMapping("/list/two")
	public void insertTwo() {
		girlService.insertTwo();
	}
}
