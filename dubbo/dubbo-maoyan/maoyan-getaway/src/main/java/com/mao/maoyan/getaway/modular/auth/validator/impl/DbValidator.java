package com.mao.maoyan.getaway.modular.auth.validator.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.mao.maoyan.getaway.common.persistence.dao.UserMapper;
import com.mao.maoyan.getaway.common.persistence.model.User;
import com.mao.maoyan.getaway.modular.auth.validator.IReqValidator;
import com.mao.maoyan.getaway.modular.auth.validator.dto.Credence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 账号密码验证
 *
 * @author maojiawei
 */
@Service
public class DbValidator implements IReqValidator {

    @Autowired
    UserMapper userMapper;

    @Override
    public boolean validate(Credence credence) {
        List<User> users = userMapper.selectList(new EntityWrapper<User>().eq("userName", credence.getCredenceName()));
        if (users != null && users.size() > 0) {
            return true;
        } else {
            return false;
        }
    }
}