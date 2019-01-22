package com.mao.maoyan.film.common.persistence.model;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 演员表
 * @author myseital
 */
@Data
@TableName("mooc_actor_t")
public class MoocActorT extends Model<MoocActorT> {

    /**
     * 主键编号
     */
    @TableId(value = "UUID", type = IdType.AUTO)
    private Integer uuid;
    /**
     * 演员名称
     */
    @TableField("actor_name")
    private String actorName;
    /**
     * 演员图片位置
     */
    @TableField("actor_img")
    private String actorImg;

    @Override
    protected Serializable pkVal() {
        return this.uuid;
    }
}
