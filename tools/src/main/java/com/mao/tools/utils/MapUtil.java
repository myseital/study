package com.mao.tools.utils;

import java.util.Map;

/**
 * @author myseital
 * @date 2021/5/25 16:07
 */
public class MapUtil {

    public static boolean isEmpty(Map map) {
        return map == null || map.isEmpty();
    }

    public static boolean isNotEmpty(Map map) {
        return !isEmpty(map);
    }
}
