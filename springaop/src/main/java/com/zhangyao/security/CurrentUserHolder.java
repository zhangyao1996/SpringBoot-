package com.zhangyao.security;
/**
* @author zhangyao:
* @date 创建时间：Sep 18, 2018 11:13:33 AM
*/
public class CurrentUserHolder {
	public static final ThreadLocal<String> holder=new ThreadLocal<>();
	
	public static String get() {
		System.out.println(holder.get());
		return holder.get()==null?"unknow":holder.get();
	}
	public static void set(String user) {
		holder.set(user);
	}
	
}
