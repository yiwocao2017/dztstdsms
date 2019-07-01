package com.std.sms.domain;

import com.std.sms.dao.base.ABaseDO;

/**
 * 接收者
 * @author: xieyj 
 * @since: 2016年11月20日 15:28:47
 * @history:
 */
public class Receiver extends ABaseDO {

    private static final long serialVersionUID = 1L;

    // 手机号
    private String mobile;

    // 系统编号
    private String systemCode;

    // 姓名
    private String name;

    // 分类等级
    private String level;

    // 微信ID
    private String wechatId;

    // 推送ID
    private String jpushId;

    // 备注
    private String remark;

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getMobile() {
        return mobile;
    }

    public void setSystemCode(String systemCode) {
        this.systemCode = systemCode;
    }

    public String getSystemCode() {
        return systemCode;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getLevel() {
        return level;
    }

    public void setWechatId(String wechatId) {
        this.wechatId = wechatId;
    }

    public String getWechatId() {
        return wechatId;
    }

    public void setJpushId(String jpushId) {
        this.jpushId = jpushId;
    }

    public String getJpushId() {
        return jpushId;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRemark() {
        return remark;
    }

    @Override
    public String toString() {
        return "Receiver [mobile=" + mobile + ", systemCode=" + systemCode
                + ", name=" + name + ", level=" + level + ", wechatId="
                + wechatId + ", jpushId=" + jpushId + ", remark=" + remark
                + "]";
    }
}
