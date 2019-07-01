package com.std.sms.dto.req;

public class XN804051Req {
    // 编号(必填)
    private String code;

    // 更新人(必填)
    private String updater;

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
