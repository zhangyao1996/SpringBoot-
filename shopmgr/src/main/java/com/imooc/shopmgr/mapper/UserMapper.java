package com.imooc.shopmgr.mapper;
/**
 * UserMapper 数据访问类
 * @author xlei @qq 251425887 @tel 13352818008
 * @Email dlei0009@163.com
 * @date 2018-08-31 16:16:31
 * @version 1.0
 */

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.imooc.shopmgr.entity.User;

public interface UserMapper {
	@Select("select * from ec_user where LOGIN_NAME=#{userName}")
	User login(@Param("userName")String userName);

}