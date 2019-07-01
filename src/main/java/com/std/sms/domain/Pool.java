package com.std.sms.domain;

import java.util.Date;

import com.std.sms.dao.base.ABaseDO;

public class Pool extends ABaseDO {

    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = 4468644359656135672L;

    // 编号
    private String code;

    // 短信服务商
    private String channel;

    // 手机号码
    private String mobile;

    // 要发送的内容
    private String content;

    // 什么时间发送
    private Date toSendDatetime;

    // 公司编号
    private String companyCode;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public Date getToSendDatetime() {
        return toSendDatetime;
    }

    public void setToSendDatetime(Date toSendDatetime) {
        this.toSendDatetime = toSendDatetime;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

}
