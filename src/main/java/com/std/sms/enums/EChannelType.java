package com.std.sms.enums;

/**
 * 渠道大类
 * @author: xieyj 
 * @since: 2016年11月21日 下午6:42:43 
 * @history:
 */
public enum EChannelType {
    // 渠道大类(1短信 2 APP 3 微信 4系统)
    SMS("1", "短信"), APP("2", "APP"), WECHAT("3", "微信"), NOTICE("4", "系统");

    EChannelType(String code, String value) {
        this.code = code;
        this.value = value;
    }

    private String code;

    private String value;

    public String getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }
}
