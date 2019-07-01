package com.std.sms.sent.wechat;

public class MsgReq {
    private String starttime;

    private String endtime;

    private String msgid;

    private String number;

    public MsgReq() {

    }

    public MsgReq(String starttime, String endtime, String msgid, String number) {
        this.starttime = starttime;
        this.endtime = endtime;
        this.msgid = msgid;
        this.number = number;

    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public String getMsgid() {
        return msgid;
    }

    public void setMsgid(String msgid) {
        this.msgid = msgid;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

}
