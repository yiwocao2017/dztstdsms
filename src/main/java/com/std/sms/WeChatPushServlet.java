package com.std.sms;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import com.std.sms.ao.IReceiverAO;
import com.std.sms.sent.wechat.CallBackProcess;
import com.std.sms.sent.wechat.message.MessageUtil;
import com.std.sms.spring.SpringContextHolder;
import com.std.sms.util.PhoneUtil;
import com.std.sms.util.SignUtil;

/**
 * @author: xieyj 
 * @since: 2016年12月2日 上午11:42:44 
 * @history:
 */
public class WeChatPushServlet extends HttpServlet {
    static Logger logger = Logger.getLogger(WeChatPushServlet.class);

    private IReceiverAO receiverAO = SpringContextHolder
        .getBean(IReceiverAO.class);

    private CallBackProcess callBackProcess = SpringContextHolder
        .getBean(CallBackProcess.class);

    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = 6175432226630152841L;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        System.out
            .println("***************************验证签名begin***************************");
        String signature = request.getParameter("signature");// 微信加密签名
        String timestamp = request.getParameter("timestamp");// 时间戳
        String nonce = request.getParameter("nonce"); // 随机数
        String echostr = request.getParameter("echostr");// 随机字符串
        PrintWriter out = response.getWriter();
        // 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
        if (SignUtil.checkSignature(signature, timestamp, nonce)) {
            out.print(echostr);
        }
        out.close();
        out = null;
        System.out
            .println("***************************验证签名end***************************");
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        String systemCode = request.getParameter("systemCode");
        System.out.println("*************post请求开始*************");
        // 时间戳
        String timestamp = request.getParameter("timestamp");
        // 随机数
        String nonce = request.getParameter("nonce");
        String respMsg = null;
        try {
            Map<String, String> requestMap = new HashMap<String, String>();
            boolean isReplay = false;
            String encryptType = request.getParameter("encrypt_type");
            if (StringUtils.isNotBlank(systemCode)) {
                if ("aes".equals(encryptType)) {
                    requestMap = callBackProcess.parseCryptXml(request,
                        timestamp, nonce, systemCode);
                    if (MessageUtil.REQ_MESSAGE_TYPE_TEXT.equals(requestMap
                        .get("MsgType"))) {
                        String content = requestMap.get("Content");
                        if (PhoneUtil.isMobile(content)) {
                            receiverAO.importWxReceiver(content, systemCode,
                                requestMap.get("FromUserName"), "接收微信消息");
                            isReplay = true;
                        }
                    } else if (MessageUtil.REQ_MESSAGE_TYPE_EVENT
                        .equals(requestMap.get("MsgType"))
                            && MessageUtil.EVENT_TYPE_SUBSCRIBE
                                .equals(requestMap.get("Event"))) {
                        isReplay = true;
                    }
                }
            }
            if (isReplay) {
                respMsg = callBackProcess.respRequest(systemCode, timestamp,
                    nonce, requestMap);
            } else {
                respMsg = "";
            }
        } catch (Exception e) {
            logger.error("**程序错误**:" + e.getMessage());
        } finally {
            PrintWriter out = response.getWriter();
            if (StringUtils.isNotBlank(respMsg)) {
                out.print(respMsg);
            } else {
                out.print("success");
            }
            out.close();
        }
        System.out.println("*************post请求完成*************");
    }
}
