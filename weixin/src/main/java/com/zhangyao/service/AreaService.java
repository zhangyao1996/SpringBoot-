package com.zhangyao.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zhangyao.entity.Area;
import com.zhangyao.mapper.AreaMapper;

/**
* @author zhangyao:
* @date 创建时间：Sep 11, 2018 2:28:29 PM
*/
@Service
public class AreaService {
	/*
	 * 增删查复杂操作加入@Transactional
	 * 
	 */
	@Autowired
	private AreaMapper areaMapper;
	
	//获取全部area
	public List<Area> getAreaLists(){
		return areaMapper.queryArea();
	}
	
	public Area getAreaById(Integer areaId) {
		return areaMapper.queryAreaById(areaId);
	}
	
	@Transactional
	public boolean addArea(Area area) {
		if(area.getAreaName()!=null&&!"".equals(area.getAreaName())) {
			area.setCreateTime(new Date());
			area.setLastEditTime(new Date());
			try {
				int effectedNum = areaMapper.insertArea(area);
				if (effectedNum > 0) {
					return true;
				} else {
					throw new RuntimeException("添加区域信息失败!");
				}
			} catch (Exception e) {
				throw new RuntimeException("添加区域信息失败:" + e.toString());
			}
		}else {
			return false;
		}
		
	}
	
	@Transactional
	public boolean modifyArea(Area area) {
		// 空值判断，主要是areaId不为空
		if (area.getAreaId() != null && area.getAreaId() > 0) {
			// 设置默认值
			area.setLastEditTime(new Date());
			try {
				// 更新区域信息
				int effectedNum = areaMapper.updateArea(area);
				if (effectedNum > 0) {
					return true;
				} else {
					throw new RuntimeException("更新区域信息失败!");
				}
			} catch (Exception e) {
				throw new RuntimeException("更新区域信息失败:" + e.toString());
			}
		} else {
			throw new RuntimeException("区域信息不能为空！");
		}
	}

	@Transactional
	public boolean deleteArea(int areaId) {
		if (areaId > 0) {
			try {
				// 删除区域信息
				int effectedNum = areaMapper.deleteArea(areaId);
				if (effectedNum > 0) {
					return true;
				} else {
					throw new RuntimeException("删除区域信息失败!");
				}
			} catch (Exception e) {
				throw new RuntimeException("删除区域信息失败:" + e.toString());
			}
		} else {
			throw new RuntimeException("区域Id不能为空！");
		}
	}
	
}
