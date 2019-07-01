package com.std.sms.enums;

/**
 * 渠道小类
 * @author: xieyj 
 * @since: 2016年11月21日 下午6:42:43 
 * @history:
 */
public enum EPushType {
    // 渠道小类(11 创世漫道 12 汇合 21 极光推送 31 微信 41 公告)
    CSMD("11", "创世漫道"), HHXX("12", "汇禾信息"), SYKJ("13", "示远科技"), Z253("14",
            "Z253"), JIGUANG("21", "极光推送"), WEIXIN("31", "微信"), NOTICE("41",
            "公告");

    EPushType(String code, String value) {
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
