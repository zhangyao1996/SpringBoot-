package com.imooc;
/**
* @author zhangyao:
* @date 创建时间：Nov 16, 2018 2:50:59 PM
*/

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.imooc.controller.MyController;

public class MyControllerTest {
	@Test
	public void test() {
		
		MyController myController=new MyController();
		MockMvc moMvc=MockMvcBuilders.standaloneSetup(myController).build();
		try {
			moMvc.perform(get("/")).andExpect(view().name("home"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//assertEquals("home", myController.out());

	}
}
