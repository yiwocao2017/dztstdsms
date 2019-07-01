package com.std.sms.sent.wechat;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qq.weixin.mp.aes.AesException;
import com.qq.weixin.mp.aes.WXBizMsgCrypt;
import com.std.sms.bo.ISystemChannelBO;
import com.std.sms.domain.SystemChannel;
import com.std.sms.enums.EChannelType;
import com.std.sms.enums.EPushType;
import com.std.sms.sent.wechat.message.MessageUtil;
import com.std.sms.sent.wechat.message.TextMessage;

/** 
 * @author: xieyj 
 * @since: 2016年12月3日 下午3:43:01 
 * @history:
 */
@Service
public class CallBackProcess {
    static Logger logger = Logger.getLogger(CallBackProcess.class);

    @Autowired
    private ISystemChannelBO systemChannelBO;

    public Map<String, String> parseCryptXml(HttpServletRequest request,
            String timestamp, String nonce, String systemCode) throws Exception {
        Map<String, String> map = new HashMap<String, String>();
        InputStream inputStream = request.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(
            inputStream));
        String line;
        StringBuffer buf = new StringBuffer();
        while ((line = reader.readLine()) != null) {
            buf.append(line);
        }
        // 释放资源
        reader.close();
        inputStream.close();
        WXBizMsgCrypt wxCeypt = getWXBizMsgCrypt(systemCode);
        // 微信加密签名
        String msgSignature = request.getParameter("msg_signature");
        String respXml = wxCeypt.decryptMsg(msgSignature, timestamp, nonce,
            buf.toString());
        Document document = DocumentHelper.parseText(respXml);
        // 得到xml根元素
        Element root = document.getRootElement();
        // 得到根元素的所有子节点
        List<Element> elementList = root.elements();
        // 遍历所有子节点
        for (Element e : elementList) {
            map.put(e.getName(), e.getText());
        }
        return map;
    }

    /**
     * @param systemCode
     * @param timestamp
     * @param nonce
     * @param requestMap
     * @return 
     * @create: 2016年12月4日 上午10:37:25 xieyj
     * @history:
     */
    public String respRequest(String systemCode, String timestamp,
            String nonce, Map<String, String> requestMap) {
        SystemChannel systemChannel = systemChannelBO
            .getSystemChannelByCondition(systemCode, EChannelType.WECHAT,
                EPushType.WEIXIN.getCode());
        String respMessage = null;
        try {
            // 默认返回的文本消息内容
            String respContent = null;
            // 回复文本
            TextMessage textMessage = new TextMessage();
            textMessage.setToUserName(requestMap.get("FromUserName"));
            textMessage.setFromUserName(requestMap.get("ToUserName"));
            textMessage.setCreateTime(new Date().getTime());
            textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
            textMessage.setFuncFlag(0);
            String msgType = requestMap.get("MsgType");
            if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {
                respContent = systemChannel.getPrivateKey6();
            }
            // // 图片消息
            // else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)) {
            // respContent = "您发送的是图片消息！";
            // }
            // // 地理位置消息
            // else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)) {
            // respContent = "您发送的是地理位置消息！";
            // }
            // // 链接消息
            // else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LINK)) {
            // respContent = "您发送的是链接消息！";
            // }
            // // 音频消息
            // else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)) {
            // respContent = "您发送的是音频消息！";
            // }
            // 事件推送
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {
                // 事件类型
                String eventType = requestMap.get("Event");
                // 订阅
                if (eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {
                    respContent = systemChannel.getRemark();
                }
                // 取消订阅
                else if (eventType.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) {
                    // 取消订阅后用户再收不到公众号发送的消息，因此不需要回复消息
                }
                // 自定义菜单点击事件
                else if (eventType.equals(MessageUtil.EVENT_TYPE_CLICK)) {
                    // TODO 自定义菜单权没有开放，暂不处理该类消息
                }
            }
            textMessage.setContent(respContent);
            respMessage = msgToResp(textMessage, timestamp, nonce, systemCode);
            System.out.println("respMessage:" + respMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return respMessage;
    }

    public String msgToResp(TextMessage textMessage, String timeStamp,
            String nonce, String systemCode) throws Exception {
        WXBizMsgCrypt wxCeypt = getWXBizMsgCrypt(systemCode);
        String replyMsg = MessageUtil.textMessageToXml(textMessage);
        replyMsg = wxCeypt.encryptMsg(replyMsg, timeStamp, nonce);
        return replyMsg;
    }

    public WXBizMsgCrypt getWXBizMsgCrypt(String systemCode) {
        WXBizMsgCrypt wxCeypt = null;
        SystemChannel systemChannel = systemChannelBO
            .getSystemChannelByCondition(systemCode, EChannelType.WECHAT,
                EPushType.WEIXIN.getCode());
        try {
            wxCeypt = new WXBizMsgCrypt(systemChannel.getPrivateKey4(),
                systemChannel.getPrivateKey5(), systemChannel.getPrivateKey1());
        } catch (AesException e) {
            logger.info("error:" + e.getMessage());
        }
        return wxCeypt;
    }
}
