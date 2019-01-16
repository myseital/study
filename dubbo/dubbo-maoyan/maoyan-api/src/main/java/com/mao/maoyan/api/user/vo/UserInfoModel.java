package com.mao.maoyan.api.user.vo;

import lombok.Data;

import java.io.Serializable;
import java.sql.Date;

/**
 * @author maojiawei
 */
@Data
public class UserInfoModel implements Serializable{

    private static final long serialVersionUID = -8575925980616865640L;

    private Integer uuid;
    private String username;
    private String nickname;
    private String email;
    private String phone;
    private Integer sex;
    private String birthday;
    private String lifeState;
    private String biography;
    private String address;
    private String headAddress;
    private Long beginTime;
    private Long updateTime;
}
