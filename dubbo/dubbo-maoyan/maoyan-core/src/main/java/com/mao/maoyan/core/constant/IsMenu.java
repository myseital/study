package com.mao.maoyan.core.constant;

import lombok.Getter;

/**
 * 是否是菜单的枚举
 *
 * @author maojiawei
 */
@Getter
public enum IsMenu {

    YES(1, "是"),

    /**
     *  //不是菜单的是按钮
     */
    NO(0, "不是");

    Integer code;
    String message;

    IsMenu(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public static String valueOf(Integer status) {
        if (status == null) {
            return "";
        } else {
            for (IsMenu s : IsMenu.values()) {
                if (s.getCode().equals(status)) {
                    return s.getMessage();
                }
            }
            return "";
        }
    }
}
