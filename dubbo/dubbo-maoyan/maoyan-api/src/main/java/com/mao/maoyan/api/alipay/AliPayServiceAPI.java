package com.mao.maoyan.api.alipay;

import com.mao.maoyan.api.alipay.vo.AliPayInfoVO;
import com.mao.maoyan.api.alipay.vo.AliPayResultVO;

public interface AliPayServiceAPI {

    AliPayInfoVO getQRCode(String orderId);

    AliPayResultVO getOrderStatus(String orderId);
}
