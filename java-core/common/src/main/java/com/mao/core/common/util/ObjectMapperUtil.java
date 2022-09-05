package com.mao.core.common.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * objectMapper单例工具类
 * @author myseital
 * @date 2022/9/5
 */
public class ObjectMapperUtil {

    private static ObjectMapper objectMapper;

    private static synchronized void init() {
        if (objectMapper == null) {
            objectMapper = new ObjectMapper();
        }
    }

    /**
     * 字符串转换为指定数据类型
     *
     * @param content   原字符串
     * @param valueType 目标数据类型
     * @param <T>       目标数据类型
     * @return 转换后对象
     * @throws JsonProcessingException
     */
    public static <T> T readValue(String content, Class<T> valueType) throws JsonProcessingException {
        init();
        return objectMapper.readValue(content, valueType);
    }

    /**
     * 字符串转换为指定数据类型
     *
     * @param content      原字符串
     * @param valueTypeRef 目标数据类型
     * @param <T>          目标数据类型
     * @return 转换后对象
     * @throws JsonProcessingException
     */
    public static <T> T readValue(String content, TypeReference<T> valueTypeRef) throws JsonProcessingException {
        init();
        return objectMapper.readValue(content, valueTypeRef);
    }

    public static <T> T convertValue(Object fromValue, Class<T> toValueType) {
        init();
        return objectMapper.convertValue(fromValue, toValueType);
    }
}
