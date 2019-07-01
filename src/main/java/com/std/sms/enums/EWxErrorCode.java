package com.std.sms.enums;

/**
 * @author: xieyj 
 * @since: 2016年12月1日 上午9:41:22 
 * @history:
 */
public enum EWxErrorCode {
    EXPIRE("45009", "过期");

    EWxErrorCode(String code, String value) {
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
