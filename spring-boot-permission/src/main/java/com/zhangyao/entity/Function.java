package com.zhangyao.entity;

import lombok.Data;

@Data
public class Function {

    private Long id;

    private String name;

    private Long parentId;

    private String url;

    private Integer serialNum;

    private Integer accordion;

}