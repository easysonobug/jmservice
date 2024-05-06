package com.tencent.wxcloudrun.service.impl;

import com.tencent.wxcloudrun.config.ApiResponse;
import com.tencent.wxcloudrun.dao.UserMapper;
import com.tencent.wxcloudrun.dto.BaseUserInfo;
import com.tencent.wxcloudrun.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements IUserService {

    @Resource
    private UserMapper userMapper;


    @Override
    public ApiResponse check(String openId) {
        BaseUserInfo baseUserInfo = userMapper.check(openId);
        return ApiResponse.ok(baseUserInfo);
    }

    @Override
    synchronized public ApiResponse add(BaseUserInfo baseUserInfo) {
        BaseUserInfo check = userMapper.check(baseUserInfo.getOpenId());
        if (check == null) {
            userMapper.insert(baseUserInfo);
        }
        return ApiResponse.ok(baseUserInfo);
    }

}
