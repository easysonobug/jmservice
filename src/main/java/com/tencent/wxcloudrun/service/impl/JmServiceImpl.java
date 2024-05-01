package com.tencent.wxcloudrun.service.impl;

import com.tencent.wxcloudrun.config.ApiResponse;
import com.tencent.wxcloudrun.dao.JmMapper;
import com.tencent.wxcloudrun.dto.JmLotteryResult;
import com.tencent.wxcloudrun.service.IJmService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class JmServiceImpl implements IJmService {

    @Resource
    private JmMapper jmMapper;

    @Override
    public Integer getValidCount(String openId) {
        return jmMapper.getValidCount(openId);
    }

    @Override
    public ApiResponse insertLottery(String openId) {
        Integer validCount = this.getValidCount(openId);
        if (validCount == 0) {
            return ApiResponse.error("抽奖次数不足");
        }
        double random = Math.random();
        // 0-免费助教， 1-免费一小时，2-免费红牛，3-免费雪糕， 4-免费可乐， 5-未中奖
        int lotteryCode = 5; // 未中奖
        String lotteryName = "未中奖";
        if (random > 0.9999) {
            lotteryCode = 0; // 免费助教，中奖率  万分之一
            lotteryName = "免费助教";
        } else if (random > 0.995) {
            lotteryCode = 1; // 免费一小时， 中奖率约 0.5%
            lotteryName = "免费一小时";
        } else if (random > 0.99) {
            lotteryCode = 2; // 免费红牛， 中奖率约 0.5%
            lotteryName = "免费红牛";
        } else if (random > 0.985) {
            lotteryCode = 3; // 免费雪糕， 中奖率约 0.5%
            lotteryName = "免费雪糕";
        } else if (random > 0.98) {
            lotteryCode = 4; // 免费可乐， 中奖率约 0.5%
            lotteryName = "免费可乐";
        }
        JmLotteryResult jmLotteryResult = new JmLotteryResult();
        jmLotteryResult.setLotteryCode(lotteryCode);
        jmLotteryResult.setLotteryName(lotteryName);
        jmLotteryResult.setOpenId(openId);
        jmMapper.insertLottery(jmLotteryResult);
        return ApiResponse.ok(lotteryCode);
    }

    @Override
    public ApiResponse myLotteryHistory(String openId) {
        List<JmLotteryResult> list = jmMapper.myLotteryHistory(openId);
        return ApiResponse.ok(list);
    }

    @Override
    public ApiResponse checkLottery(String openId, JmLotteryResult jmLotteryResult) {
        JmLotteryResult db = jmMapper.getJmLotteryById(jmLotteryResult);
        if ("未领取".equals(db.getStatus())) {
            jmMapper.checkedJmLotteryById(jmLotteryResult);
            return ApiResponse.ok();
        } else {
            return ApiResponse.error("无法核销");
        }
    }
}
