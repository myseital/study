package com.mao.maoyan.film.common.persistence.model;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 区域信息表
 * </p>
 *
 * @author myseital
 */
@Data
@TableName("mooc_source_dict_t")
public class MoocSourceDictT extends Model<MoocSourceDictT> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键编号
     */
    @TableId(value = "UUID", type = IdType.AUTO)
    private Integer uuid;
    /**
     * 显示名称
     */
    @TableField("show_name")
    private String showName;

    @Override
    protected Serializable pkVal() {
        return this.uuid;
    }
}
