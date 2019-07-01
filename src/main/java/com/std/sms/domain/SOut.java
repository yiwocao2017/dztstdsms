package com.std.sms.domain;

import java.util.Date;

import com.std.sms.dao.base.ABaseDO;

/** 
 * @author: zuixian 
 * @since: 2016年7月6日 下午8:32:22 
 * @history:
 */
public class SOut extends ABaseDO {

    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = 2299385736952404070L;

    // ********* 查询字段 ***********
    Date sendDatetimeStart;

    Date sendDatetimeEnd;

    // 编号
    private String code;

    // 系统编号
    private String systemCode;

    // 公司编号
    private String companyCode;

    // 短信服务商
    private String channel;

    // 手机号码
    private String mobile;

    // 要发送的内容
    private String content;

    // 状态码
    private String errorCode;

    // 状态信息
    private String errorInfo;

    // 发送时间
    private Date sendDatetime;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
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

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String error_code) {
        this.errorCode = error_code;
    }

    public String getErrorInfo() {
        return errorInfo;
    }

    public void setErrorInfo(String error_info) {
        this.errorInfo = error_info;
    }

    public Date getSendDatetime() {
        return sendDatetime;
    }

    public void setSendDatetime(Date sendDatetime) {
        this.sendDatetime = sendDatetime;
    }

    public Date getSendDatetimeStart() {
        return sendDatetimeStart;
    }

    public void setSendDatetimeStart(Date sendDatetimeStart) {
        this.sendDatetimeStart = sendDatetimeStart;
    }

    public Date getSendDatetimeEnd() {
        return sendDatetimeEnd;
    }

    public void setSendDatetimeEnd(Date sendDatetimeEnd) {
        this.sendDatetimeEnd = sendDatetimeEnd;
    }

    public String getSystemCode() {
        return systemCode;
    }

    public void setSystemCode(String systemCode) {
        this.systemCode = systemCode;
    }
}
