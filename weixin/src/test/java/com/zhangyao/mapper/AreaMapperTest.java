package com.zhangyao.mapper;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.zhangyao.entity.Area;

/**
* @author zhangyao:
* @date 创建时间：Sep 11, 2018 11:26:36 AM
*/


@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING) // 按方法名大小升序执行
public class AreaMapperTest {
	@Autowired
	private AreaMapper areaMapper;
	
	@Test
	@Ignore
	public void testAQueryArea() {
		List<Area> areaList = areaMapper.queryArea();
		// 验证预期值和实际值是否相符
		for (Area area : areaList) {
			System.out.println(area);
		}
	}
	
	@Test
	@Ignore
	public void testBQueryAreaById() {
		System.out.println(areaMapper.queryAreaById(1));
	}
	
	@Test
	@Ignore
	public void testBInsertArea() {
		//创建一个区域对象
		Area area = new Area();
		area.setAreaName("测试区域");
		area.setCreateTime(new Date());
		area.setPriority(1);
		//将该对象实例添加入库
		int effectedNum = areaMapper.insertArea(area);
		//检测影响行数
		assertEquals(1, effectedNum);
		//校验总数是否+1
		List<Area> areaList = areaMapper.queryArea();
		assertEquals(3, areaList.size());
	}

	@Test
	@Ignore
	public void testCQueryAreaById() {
		Area area = areaMapper.queryAreaById(2);
		assertEquals("东苑", area.getAreaName());
	}

	@Test
	@Ignore
	public void testDUpateArea() {
		List<Area> areaList = areaMapper.queryArea();
		for (Area area : areaList) {
			if ("测试区域".equals(area.getAreaName())) {
				// 对比之前的priority值
				assertEquals(1, area.getPriority().intValue());
				area.setPriority(2);
				int effectedNum = areaMapper.updateArea(area);
				assertEquals(1, effectedNum);
			}
		}
	}

	@Test
	@Ignore
	public void testEDeleteArea() {
		List<Area> areaList = areaMapper.queryArea();
		for (Area area : areaList) {
			if ("测试区域".equals(area.getAreaName())) {
				int effectedNum = areaMapper.deleteArea(area.getAreaId());
				assertEquals(1, effectedNum);
			}
		}
		// 重新获取一次列表，看看总数是否少1
		areaList = areaMapper.queryArea();
		assertEquals(2, areaList.size());
	}
}
