package com.zhangyao.entity;

import lombok.Data;

@Data
public class RoleFunction {
    private Long id;

    private Long roleId;

    private Long functionId;

    private Integer status;

}