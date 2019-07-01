package com.std.sms.dto.req;

public class XN804000Req {
    // 系统编号(必填)
    private String systemCode;

    // 渠道大类(1短信 2 APP 3 微信 4 系统)(必填)
    private String channelType;

    // 渠道小类(11 创世漫道 12 汇禾 21 极光推送 31 微信 41 公告)(必填)
    private String pushType;

    // 状态(1 启用 0 不启用)(必填)
    private String status;

    // 渠道给系统的代号(选填)
    private String pushSystem;

    // 秘钥1(选填)
    private String privateKey1;

    // 秘钥2(选填)
    private String privateKey2;

    // 秘钥3(选填)
    private String privateKey3;

    // 秘钥4(选填)
    private String privateKey4;

    // 秘钥5(选填)
    private String privateKey5;

    // 秘钥6(选填)
    private String privateKey6;

    // 备注(选填)
    private String remark;

    public String getPrivateKey4() {
        return privateKey4;
    }

    public void setPrivateKey4(String privateKey4) {
        this.privateKey4 = privateKey4;
    }

    public String getPrivateKey5() {
        return privateKey5;
    }

    public void setPrivateKey5(String privateKey5) {
        this.privateKey5 = privateKey5;
    }

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

    public String getPushSystem() {
        return pushSystem;
    }

    public void setPushSystem(String pushSystem) {
        this.pushSystem = pushSystem;
    }

    public String getPrivateKey1() {
        return privateKey1;
    }

    public void setPrivateKey1(String privateKey1) {
        this.privateKey1 = privateKey1;
    }

    public String getPrivateKey2() {
        return privateKey2;
    }

    public void setPrivateKey2(String privateKey2) {
        this.privateKey2 = privateKey2;
    }

    public String getPrivateKey3() {
        return privateKey3;
    }

    public void setPrivateKey3(String privateKey3) {
        this.privateKey3 = privateKey3;
    }

    public String getPrivateKey6() {
        return privateKey6;
    }

    public void setPrivateKey6(String privateKey6) {
        this.privateKey6 = privateKey6;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
