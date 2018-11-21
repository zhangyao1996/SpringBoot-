package com.zhangyao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.zhangyao.entity.Area;

/**
* @author zhangyao:
* @date 创建时间：Sep 11, 2018 11:18:52 AM
*/
@Mapper
public interface AreaMapper {
	/**
	 * 列出区域列表
	 * 
	 * @return areaList
	 */
	List<Area> queryArea();

	/**
	 * 根据Id列出具体区域
	 * 
	 * @return area
	 */
	Area queryAreaById(int areaId);

	/**
	 * 插入区域信息
	 * 
	 * @param area
	 * @return
	 */
	int insertArea(Area area);

	/**
	 * 更新区域信息
	 * 
	 * @param area
	 * @return
	 */
	int updateArea(Area area);

	/**
	 * 删除区域信息
	 * 
	 * @param areaId
	 * @return
	 */
	int deleteArea(int areaId);
}
