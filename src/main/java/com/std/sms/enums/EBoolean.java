package com.std.sms.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: xieyj 
 * @since: 2016年11月27日 下午1:21:24 
 * @history:
 */
public enum EBoolean {
    // 0表示错；1表示对
    YES("1", "对"), NO("0", "错");
    public static Map<String, EBoolean> getBooleanResultMap() {
        Map<String, EBoolean> map = new HashMap<String, EBoolean>();
        for (EBoolean status : EBoolean.values()) {
            map.put(status.getCode(), status);
        }
        return map;
    }

    EBoolean(String code, String value) {
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
