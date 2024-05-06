package com.tencent.wxcloudrun.service;

import com.tencent.wxcloudrun.dto.BaseUserInfo;

public interface IUserService {

    BaseUserInfo check(String openId);

    BaseUserInfo add(BaseUserInfo baseUserInfo);
}
