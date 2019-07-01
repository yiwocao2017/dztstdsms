package com.std.sms.dto.req;

import java.util.Map;

/**
 * 全渠道发送(短信、极光和微信，不包含公告)
 * @author: xieyj 
 * @since: 2016年11月29日 上午11:53:27 
 * @history:
 */
public class XN804030Req {
    // from系统编号(必填)
    private String fromSystemCode;

    // 渠道大类(必填)
    private String channelType;

    // 渠道小类(必填)
    private String pushType;

    // to系统编号(选填)
    private String toSystemCode;

    // to手机号(选填)
    private String toMobile;

    // 类别
    private String toKind;

    // 消息类型(必填)（1 即时发 2定时发）
    private String smsType;

    // 消息标题(选填)
    private String smsTitle;

    // 消息内容(必填)
    private String smsContent;

    // 拟发送时间(选填)
    private String topushDatetime;

    // 更新人(必填)
    private String updater;

    // 备注(选填)
    private String remark;

    // 微信消息内容(选填)
    private Map<String, String> wxContent;

    // 模板编号(选填)
    private String templateId;

    public String getToKind() {
        return toKind;
    }

    public void setToKind(String toKind) {
        this.toKind = toKind;
    }

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public Map<String, String> getWxContent() {
        return wxContent;
    }

    public void setWxContent(Map<String, String> wxContent) {
        this.wxContent = wxContent;
    }

    public String getFromSystemCode() {
        return fromSystemCode;
    }

    public void setFromSystemCode(String fromSystemCode) {
        this.fromSystemCode = fromSystemCode;
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

    public String getToSystemCode() {
        return toSystemCode;
    }

    public void setToSystemCode(String toSystemCode) {
        this.toSystemCode = toSystemCode;
    }

    public String getToMobile() {
        return toMobile;
    }

    public void setToMobile(String toMobile) {
        this.toMobile = toMobile;
    }

    public String getSmsType() {
        return smsType;
    }

    public void setSmsType(String smsType) {
        this.smsType = smsType;
    }

    public String getSmsTitle() {
        return smsTitle;
    }

    public void setSmsTitle(String smsTitle) {
        this.smsTitle = smsTitle;
    }

    public String getSmsContent() {
        return smsContent;
    }

    public void setSmsContent(String smsContent) {
        this.smsContent = smsContent;
    }

    public String getTopushDatetime() {
        return topushDatetime;
    }

    public void setTopushDatetime(String topushDatetime) {
        this.topushDatetime = topushDatetime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
