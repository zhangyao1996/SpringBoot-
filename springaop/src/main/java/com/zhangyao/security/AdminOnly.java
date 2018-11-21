package com.zhangyao.security;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
* @author zhangyao:
* @date 创建时间：Sep 18, 2018 2:01:05 PM
*/
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface AdminOnly {

}
