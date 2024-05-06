package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.config.ApiResponse;
import com.tencent.wxcloudrun.dto.BaseUserInfo;
import com.tencent.wxcloudrun.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private IUserService userService;

    @PostMapping("/user/check")
    public ApiResponse check(@RequestHeader("x-wx-openid")String openId) {
        logger.info(openId);
        if (StringUtils.hasText(openId)) {
            return ApiResponse.ok(userService.check(openId));
        }
        return ApiResponse.error("获取用户信息失败");
    }

    @PostMapping("/user/add")
    public ApiResponse add(@RequestHeader("x-wx-openid")String openId, BaseUserInfo baseUserInfo) {
        logger.info(openId);
        if (StringUtils.hasText(openId)) {
            baseUserInfo.setId(openId);
            baseUserInfo.setOpenId(openId);
            return ApiResponse.ok(userService.add(baseUserInfo));
        }
        return ApiResponse.error("新增用户信息失败");
    }
}
