package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.config.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@Controller
public class JmController {

    final Logger logger = LoggerFactory.getLogger(CounterController.class);

    @PostMapping("/jm/getValidCount")
    public ApiResponse getValidCount(@RequestHeader("x-wx-openid")String openId) {
        logger.info(openId);
        return ApiResponse.ok();
    }
}
