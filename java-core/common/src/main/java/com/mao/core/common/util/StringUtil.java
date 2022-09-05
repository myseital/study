package com.mao.core.common.util;


import cn.hutool.core.util.StrUtil;

import java.util.List;
import java.util.Random;

/**
 * @author myseital
 * @date 2022/9/5
 */
public class StringUtil {
    public static String empty = "";

    public static String getRandomString(int length) {
        String base = "1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }

    public static String replenishLike(Object obj) {
        StringBuilder builder = new StringBuilder();
        builder.append('%').append(obj).append('%');
        return builder.toString();
    }

    public static boolean isEmpty(String str) {
        return StrUtil.isEmpty(str);
    }

    public static boolean isNotEmpty(String str) {
        return StrUtil.isNotEmpty(str);
    }


    public static boolean isNotBlank(String paramsStr) {
        return StrUtil.isNotBlank(paramsStr);
    }

    /**
     * 字符串连接
     * @param strList 原集合
     * @param separator 分隔符
     * @return
     */
    public static String join(List<String> strList, String separator) {
        return StrUtil.join(separator, strList);
    }

    public static String one(String one, String two) {
        if (isNotEmpty(one)) {
            return one;
        }
        if (isNotEmpty(two)) {
            return two;
        }
        return null;
    }

    public static String toString(Object one) {
        if (null == one) {
            return empty;
        }
        return one.toString();
    }
}
