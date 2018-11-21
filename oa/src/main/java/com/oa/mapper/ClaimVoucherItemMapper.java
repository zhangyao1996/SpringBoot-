package com.oa.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.oa.entity.ClaimVoucherItem;
@Mapper
public interface ClaimVoucherItemMapper {
    

	int deleteByPrimaryKey(Integer id);

    int insert(ClaimVoucherItem record);

    int insertSelective(ClaimVoucherItem record);

    ClaimVoucherItem selectByPrimaryKey(Integer id);
    
    //根据报销单的id来查询报�?单条�?
    List<ClaimVoucherItem> selectByClaimVoucherId(Integer cvid);

    int updateByPrimaryKeySelective(ClaimVoucherItem record);

    int updateByPrimaryKey(ClaimVoucherItem record);
}