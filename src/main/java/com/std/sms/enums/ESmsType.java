package com.std.sms.enums;

/**
 * @author: xieyj 
 * @since: 2016年11月21日 下午6:27:58 
 * @history:
 */
public enum ESmsType {
    NOW_SEND("1", "立即发"), WAIT_SEND("2", "定时发");

    ESmsType(String code, String value) {
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
