package com.zhangyao.common;
/**
* @author zhangyao:
* @date 创建时间：Nov 21, 2018 3:25:08 PM
*/
public enum Whether {
	YES(1),
    NO(0);

    private int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    Whether(int value) {
        this.value = value;
    }
}
