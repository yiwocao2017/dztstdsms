package com.std.sms.enums;

public enum EContentType {
    YZM("10", "平台主账户-验证码");
    EContentType(String code, String value) {
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
