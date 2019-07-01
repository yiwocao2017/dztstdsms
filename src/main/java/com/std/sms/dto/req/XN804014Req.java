package com.std.sms.dto.req;

public class XN804014Req {
    // 手机号(必填)
    private String mobile;

    // 系统编号(必填)
    private String systemCode;

    // 微信ID(必填)
    private String wechatId;

    // 备注(选填)
    private String remark;

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

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

    public String getWechatId() {
        return wechatId;
    }

    public void setWechatId(String wechatId) {
        this.wechatId = wechatId;
    }
}
