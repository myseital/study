package com.fengchuang.admin.dao.model;

import javax.persistence.*;
import java.util.Date;

@Table(name = "stock_info")
public class StockInfo {
    /**
     * 自增Id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 仓库Id
     */
    @Column(name = "warehouse_id")
    private Integer warehouseId;

    /**
     * 商品Id
     */
    @Column(name = "goods_id")
    private Integer goodsId;

    /**
     * skuId
     */
    @Column(name = "sku_id")
    private Integer skuId;

    /**
     * 库存数
     */
    @Column(name = "stock_number")
    private Integer stockNumber;

    /**
     * 创建人
     */
    private String creator;

    /**
     * 创建时间
     */
    @Column(name = "created_at")
    private Date createdAt;

    /**
     * 更新人
     */
    private String updator;

    /**
     * 更新时间
     */
    @Column(name = "updated_at")
    private Date updatedAt;

    /**
     * 获取自增Id
     *
     * @return id - 自增Id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置自增Id
     *
     * @param id 自增Id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取仓库Id
     *
     * @return warehouse_id - 仓库Id
     */
    public Integer getWarehouseId() {
        return warehouseId;
    }

    /**
     * 设置仓库Id
     *
     * @param warehouseId 仓库Id
     */
    public void setWarehouseId(Integer warehouseId) {
        this.warehouseId = warehouseId;
    }

    /**
     * 获取商品Id
     *
     * @return goods_id - 商品Id
     */
    public Integer getGoodsId() {
        return goodsId;
    }

    /**
     * 设置商品Id
     *
     * @param goodsId 商品Id
     */
    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    /**
     * 获取skuId
     *
     * @return sku_id - skuId
     */
    public Integer getSkuId() {
        return skuId;
    }

    /**
     * 设置skuId
     *
     * @param skuId skuId
     */
    public void setSkuId(Integer skuId) {
        this.skuId = skuId;
    }

    /**
     * 获取库存数
     *
     * @return stock_number - 库存数
     */
    public Integer getStockNumber() {
        return stockNumber;
    }

    /**
     * 设置库存数
     *
     * @param stockNumber 库存数
     */
    public void setStockNumber(Integer stockNumber) {
        this.stockNumber = stockNumber;
    }

    /**
     * 获取创建人
     *
     * @return creator - 创建人
     */
    public String getCreator() {
        return creator;
    }

    /**
     * 设置创建人
     *
     * @param creator 创建人
     */
    public void setCreator(String creator) {
        this.creator = creator;
    }

    /**
     * 获取创建时间
     *
     * @return created_at - 创建时间
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * 设置创建时间
     *
     * @param createdAt 创建时间
     */
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * 获取更新人
     *
     * @return updator - 更新人
     */
    public String getUpdator() {
        return updator;
    }

    /**
     * 设置更新人
     *
     * @param updator 更新人
     */
    public void setUpdator(String updator) {
        this.updator = updator;
    }

    /**
     * 获取更新时间
     *
     * @return updated_at - 更新时间
     */
    public Date getUpdatedAt() {
        return updatedAt;
    }

    /**
     * 设置更新时间
     *
     * @param updatedAt 更新时间
     */
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}