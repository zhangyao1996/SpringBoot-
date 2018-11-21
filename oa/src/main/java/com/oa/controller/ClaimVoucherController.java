package com.oa.controller;

import static org.hamcrest.CoreMatchers.nullValue;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oa.dto.ClaimVoucherInfo;
import com.oa.entity.ClaimVoucher;
import com.oa.entity.Employee;
import com.oa.global.Contant;
import com.oa.service.ClaimVoucherService;

/**
* @author zhangyao:
* @date 创建时间：Sep 28, 2018 5:17:42 PM
*/
@Controller
@RequestMapping("/claim_voucher")
public class ClaimVoucherController {
	@Autowired
	private ClaimVoucherService claimVoucherService;
	
	@Autowired
	private ClaimVoucherInfo claimVoucherInfo;
	
	@RequestMapping("/to_add")
	public String gotoClaimVoucherPage(ModelMap map) {
		map.addAttribute("items", Contant.getItems());
		map.addAttribute("info", claimVoucherInfo);

		return "claim_voucher_add";
	}
	
	@RequestMapping("/add")
	private String addClaimVoucher(HttpSession session,@ModelAttribute ClaimVoucherInfo info) {
		Employee employee=(Employee) session.getAttribute("emp");
		
		info.getClaimVoucher().setCreateSn(employee.getSn());
		System.out.println(info);
		claimVoucherService.saveClaimVoucher(info.getClaimVoucher(), info.getItems());
		return "redirect:detail?id="+info.getClaimVoucher().getId();
	
	}
	
	@RequestMapping("/detail")
	private String toDetail(Integer id,ModelMap map) {
		map.addAttribute("claimVoucher", claimVoucherService.getById(id));
		map.addAttribute("items", claimVoucherService.getItemByCvid(id));
		map.addAttribute("records", claimVoucherService.getDrByCvid(id));
		return "claim_voucher_detail";
	}
	
	@RequestMapping("/self")
	private String toSelfPage(HttpSession session,ModelMap map) {
		Employee employee=(Employee) session.getAttribute("emp");
		String csn=employee.getSn();
		
		map.addAttribute("lists", claimVoucherService.getByCreaterSn(csn));
		return "claim_voucher_self";
	}
	
	@RequestMapping("/deal")
	private String toDealPage(HttpSession session,ModelMap map) {
		Employee employee=(Employee) session.getAttribute("emp");
		String ndsn=employee.getSn();
		map.addAttribute("Contant",  new Contant());
		map.addAttribute("lists", claimVoucherService.getByDealSn(ndsn));
		return "claim_voucher_deal";
	}
	
	@RequestMapping("/to_update")
	public String toUpdatePage(@RequestParam("id")  Integer id,ModelMap map) {
		map.addAttribute("items", Contant.getItems());
		System.out.println(Contant.getItems());
		claimVoucherInfo.setClaimVoucher(claimVoucherService.getById(id));
		claimVoucherInfo.setItems(claimVoucherService.getItemByCvid(id));
		map.addAttribute("info", claimVoucherInfo);
		System.out.println("修改前id:"+claimVoucherInfo.getClaimVoucher().getId());
		System.out.println(claimVoucherInfo);
		return "claim_voucher_update";
	}
	
	@RequestMapping("/update")
	@ResponseBody
	private String update(HttpSession session,@ModelAttribute("info") ClaimVoucherInfo info) {
		Employee employee=(Employee) session.getAttribute("emp");
		
		info.getClaimVoucher().setCreateSn(employee.getSn());
		System.out.println("修改后id:"+info.getClaimVoucher().getId());
		System.out.println("修改后的info:"+info);
		//System.out.println(info.getItem().getId());
		//claimVoucherService.updateClaimVoucher(info.getClaimVoucher(), info.getItems());
		//return "redirect:detail?id="+info.getClaimVoucher().getId();
		return null;
	}
}
