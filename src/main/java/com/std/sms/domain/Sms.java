package com.std.sms.domain;

import java.util.Date;
import java.util.Map;

import com.std.sms.dao.base.ABaseDO;

/**
* 消息
* @author: xieyj 
* @since: 2016年11月20日 16:03:07
* @history:
*/
public class Sms extends ABaseDO {

    private static final long serialVersionUID = 1L;

    // 序号
    private Long id;

    // from系统编号
    private String fromSystemCode;

    // 渠道大类(0 全渠道 1短信 2 APP 3 微信 4 公告)
    private String channelType;

    // 渠道小类(11 创世漫道 12 汇禾 21 极光推送 31 微信 41 公告)
    private String pushType;

    // to系统编号
    private String toSystemCode;

    // to分组(1 C端，2 B端，3 平台)
    private String toKind;

    // to手机号
    private String toMobile;

    // 消息类型（1 即时发 2定时发）
    private String smsType;

    // 消息标题
    private String smsTitle;

    // 消息内容
    private String smsContent;

    // 状态（0 未发送，1 已发送）
    private String status;

    // 生成时间
    private Date createDatetime;

    // 拟发送时间
    private Date topushDatetime;

    // 发送时间
    private Date pushedDatetime;

    // 更新人
    private String updater;

    // 更新时间
    private Date updateDatetime;

    // 备注
    private String remark;

    // ****************db properties ***********************
    // 名称
    private String name;

    // 微信ID
    private String wechatId;

    // 推送ID
    private String jpushId;

    // 消息内容
    private Map<String, String> wxSmsContent;

    // 模板编号
    private String templateId;

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public String getToKind() {
        return toKind;
    }

    public void setToKind(String toKind) {
        this.toKind = toKind;
    }

    public Map<String, String> getWxSmsContent() {
        return wxSmsContent;
    }

    public void setWxSmsContent(Map<String, String> wxSmsContent) {
        this.wxSmsContent = wxSmsContent;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public Date getUpdateDatetime() {
        return updateDatetime;
    }

    public void setUpdateDatetime(Date updateDatetime) {
        this.updateDatetime = updateDatetime;
    }

    public Long getId() {
        return id;
    }

    public void setFromSystemCode(String fromSystemCode) {
        this.fromSystemCode = fromSystemCode;
    }

    public String getFromSystemCode() {
        return fromSystemCode;
    }

    public void setChannelType(String channelType) {
        this.channelType = channelType;
    }

    public String getChannelType() {
        return channelType;
    }

    public void setPushType(String pushType) {
        this.pushType = pushType;
    }

    public String getPushType() {
        return pushType;
    }

    public void setToSystemCode(String toSystemCode) {
        this.toSystemCode = toSystemCode;
    }

    public String getToSystemCode() {
        return toSystemCode;
    }

    public void setToMobile(String toMobile) {
        this.toMobile = toMobile;
    }

    public String getToMobile() {
        return toMobile;
    }

    public void setSmsType(String smsType) {
        this.smsType = smsType;
    }

    public String getSmsType() {
        return smsType;
    }

    public void setSmsTitle(String smsTitle) {
        this.smsTitle = smsTitle;
    }

    public String getSmsTitle() {
        return smsTitle;
    }

    public void setSmsContent(String smsContent) {
        this.smsContent = smsContent;
    }

    public String getSmsContent() {
        return smsContent;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public Date getCreateDatetime() {
        return createDatetime;
    }

    public void setCreateDatetime(Date createDatetime) {
        this.createDatetime = createDatetime;
    }

    public Date getTopushDatetime() {
        return topushDatetime;
    }

    public void setTopushDatetime(Date topushDatetime) {
        this.topushDatetime = topushDatetime;
    }

    public Date getPushedDatetime() {
        return pushedDatetime;
    }

    public void setPushedDatetime(Date pushedDatetime) {
        this.pushedDatetime = pushedDatetime;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRemark() {
        return remark;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
