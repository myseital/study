package com.mao.maoyan.getaway.common.persistence.model;

import com.baomidou.mybatisplus.activerecord.Model;
import lombok.Data;

import java.io.Serializable;

/**
 * @author maojiawei
 */
@Data
public class User extends Model<User> {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String userName;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName=" + userName +
                "}";
    }
}
