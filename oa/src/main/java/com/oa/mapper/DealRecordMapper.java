package com.oa.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.oa.entity.DealRecord;
@Mapper
public interface DealRecordMapper {
    //int deleteByPrimaryKey(Integer id);

    DealRecord selectByPrimaryKey(Integer id);
    
    List<DealRecord> selectByClaimVoucherId(Integer cvid);

   // int updateByPrimaryKeySelective(DealRecord record);

   // int updateByPrimaryKey(DealRecord record);
}