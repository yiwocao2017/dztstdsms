package com.std.sms.dto.req;

import java.util.Map;

/**
 * 微信发送(填手机号单发，不填群发)
 * @author: xieyj 
 * @since: 2016年11月29日 上午11:53:27 
 * @history:
 */
public class XN804033Req {
    // from系统编号(必填)
    private String fromSystemCode;

    // to系统编号(选填)
    private String toSystemCode;

    // to手机号(选填)
    private String toMobile;

    // 消息类型(必填)（1 即时发 2定时发）
    private String smsType;

    // 消息内容(必填)
    private Map<String, String> smsContent;

    // 模板编号(选填)
    private String templateId;

    // 拟发送时间(选填，定时发必填)
    private String topushDatetime;

    // 更新人(必填)
    private String updater;

    // 备注(选填)
    private String remark;

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

    public String getFromSystemCode() {
        return fromSystemCode;
    }

    public void setFromSystemCode(String fromSystemCode) {
        this.fromSystemCode = fromSystemCode;
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

    public Map<String, String> getSmsContent() {
        return smsContent;
    }

    public void setSmsContent(Map<String, String> smsContent) {
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
