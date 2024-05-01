package com.tencent.wxcloudrun.dao;

import com.tencent.wxcloudrun.dto.JmLotteryResult;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface JmMapper {
    Integer getValidCount(String openId);

    void insertLottery(JmLotteryResult jmLotteryResult);

    List<JmLotteryResult> myLotteryHistory(String openId);

    JmLotteryResult getJmLotteryById(JmLotteryResult jmLotteryResult);

    void checkedJmLotteryById(JmLotteryResult jmLotteryResult);
}
