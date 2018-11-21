package com.oa.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oa.entity.ClaimVoucher;
import com.oa.entity.ClaimVoucherItem;
import com.oa.entity.DealRecord;
import com.oa.global.Contant;
import com.oa.mapper.ClaimVoucherItemMapper;
import com.oa.mapper.ClaimVoucherMapper;
import com.oa.mapper.DealRecordMapper;

/**
* @author zhangyao:
* @date 创建时间：Sep 28, 2018 5:15:02 PM
*/
@Service
public class ClaimVoucherService {
	@Autowired
	private ClaimVoucherMapper claimVoucherMapper;
	
	@Autowired
	private ClaimVoucherItemMapper claimVoucherItemMapper;
	
	@Autowired
	private DealRecordMapper dealRecordMapper;
	
	//保存报销单
	public void saveClaimVoucher(ClaimVoucher claimVoucher,List<ClaimVoucherItem> items) {
		claimVoucher.setCreateTime(new Date());
		claimVoucher.setNextDealSn(claimVoucher.getCreateSn());
		claimVoucher.setStatus(Contant.CLAIMVOUCHER_CREATED);
		claimVoucherMapper.insert(claimVoucher);
		System.out.println(claimVoucher);
		for (ClaimVoucherItem claimVoucherItem : items) {
			claimVoucherItem.setClaimVoucherId(claimVoucher.getId());
			System.out.println("id:"+claimVoucher.getId());
			claimVoucherItemMapper.insert(claimVoucherItem);
			System.out.println(claimVoucherItem);
		}
		
	}
	
	public ClaimVoucher getById(Integer id) {
		return claimVoucherMapper.selectByPrimaryKey(id);
	}
	
	public List<ClaimVoucherItem> getItemByCvid(Integer cvid){
		return claimVoucherItemMapper.selectByClaimVoucherId(cvid);
	}
	
	public List<DealRecord> getDrByCvid(Integer cvid){
		return dealRecordMapper.selectByClaimVoucherId(cvid);
	}
	//个人报销单
	public List<ClaimVoucher> getByCreaterSn(String csn){
		return claimVoucherMapper.selectByCreateSn(csn);
	}
	//待处理人报销单
	public List<ClaimVoucher> getByDealSn(String ndsn){
		return claimVoucherMapper.selectByNextDealSn(ndsn);
	}
	//修改报销单
	public void updateClaimVoucher(ClaimVoucher claimVoucher,List<ClaimVoucherItem> items) {
		
		claimVoucher.setNextDealSn(claimVoucher.getCreateSn());
		claimVoucher.setStatus(Contant.CLAIMVOUCHER_CREATED);
		claimVoucherMapper.updateByPrimaryKey(claimVoucher);
		
		List<ClaimVoucherItem> olds=claimVoucherItemMapper.selectByClaimVoucherId(claimVoucher.getId());
		
		for (ClaimVoucherItem old : olds) {
			boolean isHave=false;
			for (ClaimVoucherItem item : items) {
				
				if(old.getId()==item.getId()) {
					isHave=true;
					break;
				}
			}
			if(!isHave) {
				claimVoucherItemMapper.deleteByPrimaryKey(old.getId());
			}
		}
		 for(ClaimVoucherItem item:items){
	            item.setClaimVoucherId(claimVoucher.getId());
	            if(item.getId()>0){
	              claimVoucherItemMapper.updateByPrimaryKey(item);
	            }else{
	              System.out.println(item.getId());
	              claimVoucherItemMapper.insert(item);
	            }
	        }
	}
	
	
	

}
