package com.zhangyao.common.tree;

import java.io.Serializable;

/**
* @author zhangyao:
* @date 创建时间：Nov 21, 2018 3:06:10 PM
*/
public class NodeAttribute implements Serializable {
    private Long id;
    private String url;

    public NodeAttribute(Long id, String url) {
        this.id = id;
        this.url = url;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}