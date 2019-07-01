package com.std.sms.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: xieyj 
 * @since: 2016年11月27日 下午1:21:24 
 * @history:
 */
public enum EHandleStatus {
    TO_HANDLE("0", "待处理"), HANDLE_ING("1", "正在处理"), HANDLED("2", "已完成");
    public static Map<String, EHandleStatus> getHandleStatusResultMap() {
        Map<String, EHandleStatus> map = new HashMap<String, EHandleStatus>();
        for (EHandleStatus status : EHandleStatus.values()) {
            map.put(status.getCode(), status);
        }
        return map;
    }

    EHandleStatus(String code, String value) {
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
