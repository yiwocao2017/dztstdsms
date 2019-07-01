package com.std.sms.dto.req;

public class XN804012Req {
    // 手机号(必填)
    private String mobile;

    // 系统编号(必填)
    private String systemCode;

    // 姓名(必填)
    private String name;

    // 等级(选填)
    private String level;

    // 微信ID(选填)
    private String wechatId;

    // 推送ID(选填)
    private String jpushId;

    // 备注(选填)
    private String remark;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getSystemCode() {
        return systemCode;
    }

    public void setSystemCode(String systemCode) {
        this.systemCode = systemCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getWechatId() {
        return wechatId;
    }

    public void setWechatId(String wechatId) {
        this.wechatId = wechatId;
    }

    public String getJpushId() {
        return jpushId;
    }

    public void setJpushId(String jpushId) {
        this.jpushId = jpushId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
