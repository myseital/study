package com.mao.maoyan.user.modular.user;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.google.common.base.MoreObjects;
import com.mao.maoyan.api.user.UserApi;
import com.mao.maoyan.api.user.vo.UserInfoModel;
import com.mao.maoyan.api.user.vo.UserModel;
import com.mao.maoyan.core.util.MD5Util;
import com.mao.maoyan.user.common.persistence.dao.MoocUserTMapper;
import com.mao.maoyan.user.common.persistence.model.MoocUserT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Service(interfaceClass = UserApi.class, loadbalance = "roundrobin")
public class UserServiceImpl implements UserApi {

    @Autowired
    private MoocUserTMapper moocUserTMapper;

    @Override
    public Boolean register(UserModel userModel) {
        // 将注册信息实体转换为数据实体[mooc_user_t]
        MoocUserT moocUserT = new MoocUserT();
        moocUserT.setUserName(userModel.getUserName());
        moocUserT.setEmail(userModel.getEmail());
        moocUserT.setAddress(userModel.getAddress());
        moocUserT.setUserPhone(userModel.getPhone());
        // 创建时间和修改时间 -> current_timestamp

        // 数据加密 【MD5混淆加密 + 盐值 -> Shiro加密】
        String md5Password = MD5Util.encrypt(userModel.getPassword());
        // 注意
        moocUserT.setUserPwd(md5Password);

        // 将数据实体存入数据库
        Integer insert = MoreObjects.firstNonNull(moocUserTMapper.insert(moocUserT), 0);

        return insert > 0;
    }

    @Override
    public Integer login(String username, String password) {
        // 根据登陆账号获取数据库信息
        MoocUserT moocUserT = new MoocUserT();
        moocUserT.setUserName(username);

        MoocUserT result = moocUserTMapper.selectOne(moocUserT);

        // 获取到的结果，然后与加密以后的密码做匹配
        if (result != null && result.getUuid() > 0) {
            String md5Password = MD5Util.encrypt(password);
            if (result.getUserPwd().equals(md5Password)) {
                return result.getUuid();
            }
        }
        return 0;
    }

    @Override
    public Boolean checkUsername(String userName) {
        EntityWrapper<MoocUserT> entityWrapper = new EntityWrapper<>();
        entityWrapper.eq("user_name", userName);
        Integer result = moocUserTMapper.selectCount(entityWrapper);
        if (result != null && result > 0) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public UserInfoModel getUserInfo(Integer uuid) {
        // 根据主键查询用户信息 [MoocUserT]
        MoocUserT moocUserT = moocUserTMapper.selectById(uuid);
        // 将MoocUserT转换UserInfoModel
        UserInfoModel userInfoModel = do2UserInfo(moocUserT);
        // 返回UserInfoModel
        return userInfoModel;
    }

    @Override
    public UserInfoModel updateUserInfo(UserInfoModel userInfoModel) {
        // 将传入的参数转换为DO 【MoocUserT】
        MoocUserT moocUserT = new MoocUserT();
        moocUserT.setUuid(userInfoModel.getUuid());
        moocUserT.setNickName(userInfoModel.getNickName());
        moocUserT.setLifeState(Integer.parseInt(userInfoModel.getLifeState()));
        moocUserT.setBirthday(userInfoModel.getBirthday());
        moocUserT.setBiography(userInfoModel.getBiography());
        moocUserT.setBeginTime(null);
        moocUserT.setHeadUrl(userInfoModel.getHeadAddress());
        moocUserT.setEmail(userInfoModel.getEmail());
        moocUserT.setAddress(userInfoModel.getAddress());
        moocUserT.setUserPhone(userInfoModel.getPhone());
        moocUserT.setUserSex(userInfoModel.getSex());
        moocUserT.setUpdateTime(null);

        // DO存入数据库
        Integer integer = moocUserTMapper.updateById(moocUserT);
        if (integer > 0) {
            // 将数据从数据库中读取出来
            UserInfoModel userInfo = getUserInfo(moocUserT.getUuid());
            // 将结果返回给前端
            return userInfo;
        } else {
            return null;
        }
    }

    private UserInfoModel do2UserInfo(MoocUserT moocUserT) {
        UserInfoModel userInfoModel = new UserInfoModel();

        userInfoModel.setUuid(moocUserT.getUuid());
        userInfoModel.setHeadAddress(moocUserT.getHeadUrl());
        userInfoModel.setPhone(moocUserT.getUserPhone());
        userInfoModel.setUpdateTime(moocUserT.getUpdateTime().getTime());
        userInfoModel.setEmail(moocUserT.getEmail());
        userInfoModel.setUserName(moocUserT.getUserName());
        userInfoModel.setNickName(moocUserT.getNickName());
        userInfoModel.setLifeState("" + moocUserT.getLifeState());
        userInfoModel.setBirthday(moocUserT.getBirthday());
        userInfoModel.setAddress(moocUserT.getAddress());
        userInfoModel.setSex(moocUserT.getUserSex());
        userInfoModel.setBeginTime(moocUserT.getBeginTime().getTime());
        userInfoModel.setBiography(moocUserT.getBiography());

        return userInfoModel;
    }
}
