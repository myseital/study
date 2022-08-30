package com.fengchuang.admin.dao.model;

import javax.persistence.*;
import java.util.Date;

@Table(name = "sku_info")
public class SkuInfo {
    /**
     * 自增主键ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 姓名
     */
    @Column(name = "goods_id")
    private Integer goodsId;

    /**
     * sku编码
     */
    private String code;

    /**
     * sku名称
     */
    private String name;

    /**
     * 规格信息
     */
    private String spec;

    /**
     * sku图片
     */
    private String url;

    /**
     * 供应商id
     */
    @Column(name = "supplier_id")
    private Integer supplierId;

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
     * 获取自增主键ID
     *
     * @return id - 自增主键ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置自增主键ID
     *
     * @param id 自增主键ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取姓名
     *
     * @return goods_id - 姓名
     */
    public Integer getGoodsId() {
        return goodsId;
    }

    /**
     * 设置姓名
     *
     * @param goodsId 姓名
     */
    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    /**
     * 获取sku编码
     *
     * @return code - sku编码
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置sku编码
     *
     * @param code sku编码
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 获取sku名称
     *
     * @return name - sku名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置sku名称
     *
     * @param name sku名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取规格信息
     *
     * @return spec - 规格信息
     */
    public String getSpec() {
        return spec;
    }

    /**
     * 设置规格信息
     *
     * @param spec 规格信息
     */
    public void setSpec(String spec) {
        this.spec = spec;
    }

    /**
     * 获取sku图片
     *
     * @return url - sku图片
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置sku图片
     *
     * @param url sku图片
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 获取供应商id
     *
     * @return supplier_id - 供应商id
     */
    public Integer getSupplierId() {
        return supplierId;
    }

    /**
     * 设置供应商id
     *
     * @param supplierId 供应商id
     */
    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
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