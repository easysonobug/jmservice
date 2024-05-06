package com.tencent.wxcloudrun.dto;

import lombok.Data;

import java.util.Date;

@Data
public class BaseUserInfo {
    private String id;
    private String openId;
    private String nickName;
    private String avatarUrl;
    private Date fillDate;
}
