package com.mao.maoyan.api.user;


import com.mao.maoyan.api.user.vo.UserInfoModel;
import com.mao.maoyan.api.user.vo.UserModel;

/**
 * 用户服务API
 *
 * @author maojiawei
 */
public interface UserApi {

    /**
     * 用户登录
     * @param username
     * @param password
     * @return
     */
    Integer login(String username, String password);

    /**
     * 用户注册
     * @param userModel
     * @return
     */
    Boolean register(UserModel userModel);

    /**
     * 验证用户名称
     * @param username
     * @return
     */
    Boolean checkUsername(String username);

    /**
     * 查询用户信息
     * @param uuid
     * @return
     */
    UserInfoModel getUserInfo(Integer uuid);

    /**
     * 更新用户信息
     * @param userInfoModel
     * @return
     */
    UserInfoModel updateUserInfo(UserInfoModel userInfoModel);
}
