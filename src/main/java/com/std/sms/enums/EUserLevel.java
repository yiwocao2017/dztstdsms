package com.std.sms.enums;

/**
 * @author: xieyj 
 * @since: 2016年12月11日 下午4:36:35 
 * @history:
 */
public enum EUserLevel {
    CUser("1", "C端用户"), BUser("2", "B端用户"), PlatUser("3", "平台用户");

    EUserLevel(String code, String value) {
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
