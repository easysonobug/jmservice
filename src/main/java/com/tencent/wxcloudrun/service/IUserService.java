package com.tencent.wxcloudrun.service;

import com.tencent.wxcloudrun.config.ApiResponse;
import com.tencent.wxcloudrun.dto.BaseUserInfo;

public interface IUserService {

    ApiResponse check(String openId);

    ApiResponse add(BaseUserInfo baseUserInfo);
}
