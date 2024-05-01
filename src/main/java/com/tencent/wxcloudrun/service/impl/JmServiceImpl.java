package com.tencent.wxcloudrun.service.impl;

import com.tencent.wxcloudrun.config.ApiResponse;
import com.tencent.wxcloudrun.dao.JmMapper;
import com.tencent.wxcloudrun.dto.JmLotteryResult;
import com.tencent.wxcloudrun.service.IJmService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class JmServiceImpl implements IJmService {

    @Resource
    private JmMapper jmMapper;

    @Override
    public Integer getValidCount(String openId) {
        return jmMapper.getValidCount(openId);
    }

    @Override
    public ApiResponse insertLottery(JmLotteryResult jmLotteryResult) {
        Integer validCount = this.getValidCount(jmLotteryResult.getOpenId());
        if (validCount == 0) {
            return ApiResponse.error("抽奖次数不足");
        }
        jmMapper.insertLottery(jmLotteryResult);
        return ApiResponse.ok();
    }
}
