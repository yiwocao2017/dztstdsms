/**
 * @Title Status.java 
 * @Package com.ibis.pz.enums 
 * @Description 
 * @author miyb  
 * @date 2015-3-7 上午8:41:50 
 * @version V1.0   
 */
package com.std.sms.enums;

/** 
 * @author: miyb 
 * @since: 2015-3-7 上午8:41:50 
 * @history:
 */
public enum ESmsStatus {
    TOSEND("0", "待发送"), SENT_YES("1", "已发送/使用中"), SENT_NO("2", "发送失败/过期"), CHECKED(
            "3", "已验证");

    // 公告 0 待发送 1使用中 2 过期
    // 短信/微信/极光 0 待发送 1已发送 2 发送失败

    ESmsStatus(String code, String value) {
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
