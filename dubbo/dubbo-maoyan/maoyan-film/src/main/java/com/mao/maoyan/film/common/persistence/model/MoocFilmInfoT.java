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
 * 影片主表
 * </p>
 *
 * @author myseital
 */
@Data
@TableName("mooc_film_info_t")
public class MoocFilmInfoT extends Model<MoocFilmInfoT> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键编号
     */
    @TableId(value = "UUID", type = IdType.AUTO)
    private Integer uuid;
    /**
     * 影片编号
     */
    @TableField("film_id")
    private String filmId;
    /**
     * 影片英文名称
     */
    @TableField("film_en_name")
    private String filmEnName;
    /**
     * 影片评分
     */
    @TableField("film_score")
    private String filmScore;
    /**
     * 评分人数,以万为单位
     */
    @TableField("film_score_num")
    private Integer filmScoreNum;
    /**
     * 播放时长，以分钟为单位，不足取整
     */
    @TableField("film_length")
    private Integer filmLength;
    /**
     * 影片介绍
     */
    private String biography;
    /**
     * 导演编号
     */
    @TableField("director_id")
    private Integer directorId;
    /**
     * 影片图片集地址,多个图片以逗号分隔
     */
    @TableField("film_imgs")
    private String filmImgs;

    @Override
    protected Serializable pkVal() {
        return this.uuid;
    }
}
