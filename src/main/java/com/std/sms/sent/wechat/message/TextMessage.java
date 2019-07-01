/**
 * @Title TextMessage.java 
 * @Package com.std.sms.sent.wechat.message 
 * @Description 
 * @author xieyj  
 * @date 2016年12月3日 下午4:08:22 
 * @version V1.0   
 */
package com.std.sms.sent.wechat.message;

/** 
 * @author: xieyj 
 * @since: 2016年12月3日 下午4:08:22 
 * @history:
 */
public class TextMessage extends BaseMessage {
    // 消息内容
    private String Content;

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}
