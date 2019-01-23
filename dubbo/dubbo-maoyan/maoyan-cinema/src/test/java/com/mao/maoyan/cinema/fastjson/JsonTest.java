package com.mao.maoyan.cinema.fastjson;

import com.alibaba.fastjson.JSON;
import com.mao.maoyan.cinema.common.SimpleObject;
import com.mao.maoyan.cinema.modular.auth.converter.BaseTransferEntity;
import com.mao.maoyan.core.util.MD5Util;

/**
 * json测试
 *
 * @author fengshuonan
 * @date 2017-08-25 16:11
 */


public class JsonTest {

    public static void main(String[] args) {
        String randomKey = "1xm7hw";

        BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
        SimpleObject simpleObject = new SimpleObject();
        simpleObject.setUser("fsn");
        baseTransferEntity.setObject("123123");

        String json = JSON.toJSONString(simpleObject);

        //md5签名
        String encrypt = MD5Util.encrypt(json + randomKey);
        baseTransferEntity.setSign(encrypt);

        System.out.println(JSON.toJSONString(baseTransferEntity));
    }
}
