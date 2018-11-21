package com.oa.dto;
/**
* @author zhangyao:
* @date 创建时间：Sep 29, 2018 9:04:21 AM
*/

import java.util.List;

import org.springframework.stereotype.Component;

import com.oa.entity.ClaimVoucher;
import com.oa.entity.ClaimVoucherItem;

import lombok.Data;
@Data
@Component
public class ClaimVoucherInfo {
	private ClaimVoucher claimVoucher;
	
	private List<ClaimVoucherItem> items;

	//private ClaimVoucherItem item;
}
