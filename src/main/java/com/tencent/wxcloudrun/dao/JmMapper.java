package com.tencent.wxcloudrun.dao;

import com.tencent.wxcloudrun.dto.JmLotteryResult;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface JmMapper {
    Integer getValidCount(String openId);

    void insertLottery(JmLotteryResult jmLotteryResult);
}
