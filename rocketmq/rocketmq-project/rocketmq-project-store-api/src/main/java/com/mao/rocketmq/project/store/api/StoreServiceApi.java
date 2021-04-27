package com.mao.rocketmq.project.store.api;

import java.util.Date;

/**
 * @author myseital
 * @date 2021/4/27 17:56
 */
public interface StoreServiceApi {
    int selectVersion(String supplierId, String goodsId);

    int updateStoreCountByVersion(int currentVersion, String supplierId, String goodsId, String admin, Date currentTime);

    int selectStoreCount(String supplierId, String goodsId);
}
