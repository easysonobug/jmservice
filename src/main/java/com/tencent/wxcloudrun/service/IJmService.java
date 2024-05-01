package com.tencent.wxcloudrun.service;

import com.tencent.wxcloudrun.config.ApiResponse;
import com.tencent.wxcloudrun.dto.JmLotteryResult;

public interface IJmService {
    Integer getValidCount(String openId);

    ApiResponse insertLottery(JmLotteryResult jmLotteryResult);
}
