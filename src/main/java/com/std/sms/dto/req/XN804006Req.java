package com.std.sms.dto.req;

public class XN804006Req {
    // 系统编号(选填)
    private String systemCode;

    // 渠道大类(1短信 2 APP 3 微信 4 系统)(选填)
    private String channelType;

    // 渠道小类(11 创世漫道 12 汇禾 21 极光推送 31 微信 41 公告)(选填)
    private String pushType;

    // 状态(1 启用 0 不启用)(选填)
    private String status;

    public String getSystemCode() {
        return systemCode;
    }

    public void setSystemCode(String systemCode) {
        this.systemCode = systemCode;
    }

    public String getChannelType() {
        return channelType;
    }

    public void setChannelType(String channelType) {
        this.channelType = channelType;
    }

    public String getPushType() {
        return pushType;
    }

    public void setPushType(String pushType) {
        this.pushType = pushType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
