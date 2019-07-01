/**
 * @Title BaseMessage.java 
 * @Package com.std.sms.sent.wechat.message 
 * @Description 
 * @author xieyj  
 * @date 2016年12月3日 下午4:05:52 
 * @version V1.0   
 */
package com.std.sms.sent.wechat.message;

/** 
 * 消息基类
 * @author: xieyj 
 * @since: 2016年12月3日 下午4:05:52 
 * @history:
 */
public class BaseMessage {
    // 接收方帐号（收到的OpenID）
    private String ToUserName;

    // 开发者微信号
    private String FromUserName;

    // 消息创建时间 （整型）
    private long CreateTime;

    // 消息类型（text/music/news）
    private String MsgType;

    private int FuncFlag;

    public String getToUserName() {
        return ToUserName;
    }

    public void setToUserName(String toUserName) {
        ToUserName = toUserName;
    }

    public String getFromUserName() {
        return FromUserName;
    }

    public void setFromUserName(String fromUserName) {
        FromUserName = fromUserName;
    }

    public long getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(long createTime) {
        CreateTime = createTime;
    }

    public String getMsgType() {
        return MsgType;
    }

    public void setMsgType(String msgType) {
        MsgType = msgType;
    }

    public int getFuncFlag() {
        return FuncFlag;
    }

    public void setFuncFlag(int funcFlag) {
        FuncFlag = funcFlag;
    }
}
