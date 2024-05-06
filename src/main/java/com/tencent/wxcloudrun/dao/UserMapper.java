package com.tencent.wxcloudrun.dao;

import com.tencent.wxcloudrun.dto.BaseUserInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    BaseUserInfo check(String openId);

    void insert(BaseUserInfo baseUserInfo);
}
