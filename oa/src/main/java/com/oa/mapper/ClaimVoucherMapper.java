package com.oa.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.oa.entity.ClaimVoucher;
@Mapper
public interface ClaimVoucherMapper {


	int deleteByPrimaryKey(Integer id);

    int insert(ClaimVoucher record);

    int insertSelective(ClaimVoucher record);

    ClaimVoucher selectByPrimaryKey(Integer id);
    
    //创建�?
    List<ClaimVoucher> selectByCreateSn(String csn);
    
    //处理�?
    List<ClaimVoucher> selectByNextDealSn(String ndsn);

    int updateByPrimaryKeySelective(ClaimVoucher record);

    int updateByPrimaryKey(ClaimVoucher record);
}