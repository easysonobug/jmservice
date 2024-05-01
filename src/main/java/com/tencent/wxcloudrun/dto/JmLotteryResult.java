package com.tencent.wxcloudrun.dto;
import lombok.Data;

import java.util.Date;
@Data
public class JmLotteryResult {
    private String id;
    private String openId;
    private Integer lotteryCode;
    private String lotteryName;
    private Date fillDate;
}
