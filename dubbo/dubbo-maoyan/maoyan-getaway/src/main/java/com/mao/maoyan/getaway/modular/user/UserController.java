package com.mao.maoyan.getaway.modular.user;

import com.alibaba.dubbo.config.annotation.Reference;
import com.mao.maoyan.api.user.UserApi;
import com.mao.maoyan.api.user.vo.UserInfoModel;
import com.mao.maoyan.api.user.vo.UserModel;
import com.mao.maoyan.getaway.common.CurrentUser;
import com.mao.maoyan.getaway.modular.vo.ResponseVO;
import org.springframework.web.bind.annotation.*;

/**
 * @author maojiawei
 */
@RestController
@RequestMapping("/user/")
public class UserController {

    @Reference(interfaceClass = UserApi.class, check = false)
    private UserApi userApi;

    @PostMapping(value = "register")
    public ResponseVO register(UserModel userModel) {
        if (userModel.getUserName() == null || userModel.getUserName().trim().length() == 0) {
            return ResponseVO.serviceFail("用户名不能为空");
        }
        if (userModel.getPassword() == null || userModel.getPassword().trim().length() == 0) {
            return ResponseVO.serviceFail("密码不能为空");
        }

        boolean isSuccess = userApi.register(userModel);
        return isSuccess ? ResponseVO.success("注册成功") : ResponseVO.serviceFail("注册失败");
    }

    @PostMapping(value = "check")
    public ResponseVO check(String userName) {
        if (userName != null && userName.trim().length() > 0) {
            // 当返回true的时候，表示用户名可用
            boolean notExists = userApi.checkUsername(userName);
            if (notExists) {
                return ResponseVO.success("用户名不存在");
            } else {
                return ResponseVO.serviceFail("用户名已存在");
            }
        } else {
            return ResponseVO.serviceFail("用户名不能为空");
        }
    }

    @GetMapping(value = "logout")
    public ResponseVO logout() {
        /*
            应用：
                1、前端存储JWT 【七天】 ： JWT的刷新
                2、服务器端会存储活动用户信息【30分钟】
                3、JWT里的userId为key，查找活跃用户
            退出：
                1、前端删除掉JWT
                2、后端服务器删除活跃用户缓存
            现状：
                1、前端删除掉JWT
         */
        return ResponseVO.success("用户退出成功");
    }


    @GetMapping(value = "getUserInfo")
    public ResponseVO getUserInfo() {
        // 获取当前登陆用户
        String userId = CurrentUser.getCurrentUser();
        if (userId != null && userId.trim().length() > 0) {
            // 将用户ID传入后端进行查询
            Integer uuid = Integer.parseInt(userId);
            UserInfoModel userInfo = userApi.getUserInfo(uuid);
            if (userInfo != null) {
                return ResponseVO.success(userInfo);
            } else {
                return ResponseVO.appFail("用户信息查询失败");
            }
        } else {
            return ResponseVO.serviceFail("用户未登陆");
        }
    }

    @PostMapping(value = "updateUserInfo")
    public ResponseVO updateUserInfo(UserInfoModel userInfoModel) {
        // 获取当前登陆用户
        String userId = CurrentUser.getCurrentUser();
        if (userId != null && userId.trim().length() > 0) {
            // 将用户ID传入后端进行查询
            int uuid = Integer.parseInt(userId);
            // 判断当前登陆人员的ID与修改的结果ID是否一致
            if (uuid != userInfoModel.getUuid()) {
                return ResponseVO.serviceFail("请修改您个人的信息");
            }

            UserInfoModel userInfo = userApi.updateUserInfo(userInfoModel);
            if (userInfo != null) {
                return ResponseVO.success(userInfo);
            } else {
                return ResponseVO.appFail("用户信息修改失败");
            }
        } else {
            return ResponseVO.serviceFail("用户未登陆");
        }
    }
}
