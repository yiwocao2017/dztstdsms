package com.std.sms.dto.req;

import java.util.List;

import com.std.sms.domain.Receiver;

public class XN804011Req {
    // 系统编号（必填）
    private String systemCode;

    // 用户列表（必填）
    List<Receiver> receiverList;

    public String getSystemCode() {
        return systemCode;
    }

    public void setSystemCode(String systemCode) {
        this.systemCode = systemCode;
    }

    public List<Receiver> getReceiverList() {
        return receiverList;
    }

    public void setReceiverList(List<Receiver> receiverList) {
        this.receiverList = receiverList;
    }
}
