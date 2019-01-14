package com.mao.maoyan.api.user;


import com.mao.maoyan.api.user.vo.UserInfoModel;
import com.mao.maoyan.api.user.vo.UserModel;

/**
 * @author maojiawei
 */
public interface UserApi {

    int login(String username, String password);

    boolean register(UserModel userModel);

    boolean checkUsername(String username);

    UserInfoModel getUserInfo(int uuid);

    UserInfoModel updateUserInfo(UserInfoModel userInfoModel);

}
