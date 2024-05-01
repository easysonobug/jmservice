package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.config.ApiResponse;
import com.tencent.wxcloudrun.dto.JmLotteryResult;
import com.tencent.wxcloudrun.service.IJmService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JmController {

    final Logger logger = LoggerFactory.getLogger(JmController.class);

    @Autowired
    private IJmService jmService;

    @PostMapping("/jm/getValidCount")
    public ApiResponse getValidCount(@RequestHeader("x-wx-openid")String openId) {
        logger.info(openId);
        if (StringUtils.hasText(openId)) {
            return ApiResponse.ok(jmService.getValidCount(openId));
        }
        return ApiResponse.ok(0);
    }

    @PostMapping("/jm/insertLottery")
    public ApiResponse insertLottery(@RequestHeader("x-wx-openid")String openId, @RequestBody JmLotteryResult jmLotteryResult) {
        logger.info(openId);
        if (StringUtils.hasText(openId)) {
            jmLotteryResult.setOpenId(openId);
            return jmService.insertLottery(jmLotteryResult);
        }
        return ApiResponse.error("未知用户ID");
    }
}
