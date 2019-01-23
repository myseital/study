package com.mao.maoyan.cinema.common.persistence.model;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 影厅电影信息表
 * </p>
 *
 * @author jiangzh
 * @since 2018-09-15
 */
@Data
@TableName("mooc_hall_film_info_t")
public class MoocHallFilmInfoT extends Model<MoocHallFilmInfoT> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键编号
     */
    @TableId(value = "UUID", type = IdType.AUTO)
    private Integer uuid;
    /**
     * 电影编号
     */
    @TableField("film_id")
    private Integer filmId;
    /**
     * 电影名称
     */
    @TableField("film_name")
    private String filmName;
    /**
     * 电影时长
     */
    @TableField("film_length")
    private String filmLength;
    /**
     * 电影类型
     */
    @TableField("film_cats")
    private String filmCats;
    /**
     * 电影语言
     */
    @TableField("film_language")
    private String filmLanguage;
    /**
     * 演员列表
     */
    private String actors;
    /**
     * 图片地址
     */
    @TableField("img_address")
    private String imgAddress;

    @Override
    protected Serializable pkVal() {
        return this.uuid;
    }
}
