package com.std.sms.sent.s253;

import java.net.URLEncoder;

import com.std.sms.common.SmsClientAccessTool;

/**
 * 253发送短信接口
 * @author: xieyj 
 * @since: 2017年1月4日 下午5:37:30 
 * @history:
 */
public class Sms253ClientSend {

    /**
     * 第一章  发送接口
     * 其一：发送方式，默认为POST
     * 其二：发送内容编码方式，默认为UTF-8
     * @param url：必填--发送连接地址URL--比如>http://118.145.30.35/sms.aspx
     * @param account：必填--用户帐号
     * @param password：必填--用户密码
     * @param mobile：必填--发送的手机号码，多个可以用逗号隔比如>13512345678,13612345678
     * @param content：必填--实际发送内容，
     * @return 返回发送信息之后返回字符串
     */
    public static String sendSms(String url, String account, String password,
            String mobile, String content) {
        return sendSms(url, account, password, mobile, content, "true", "POST",
            "UTF-8", "UTF-8");
    }

    private static String sendSms(String url, String account, String pswd,
            String mobile, String msg, String needstatus, String sendType,
            String codingType, String backEncodType) {
        try {
            if (codingType == null || codingType.equals("")) {
                codingType = "UTF-8";
            }
            if (backEncodType == null || backEncodType.equals("")) {
                backEncodType = "UTF-8";
            }
            StringBuffer send = new StringBuffer();
            send.append("&account=").append(
                URLEncoder.encode(account, codingType));
            send.append("&pswd=").append(URLEncoder.encode(pswd, codingType));
            send.append("&mobile=").append(mobile);
            send.append("&msg=").append(URLEncoder.encode(msg, codingType));
            send.append("&needstatus=").append(needstatus);
            String sendSms = send.toString();
            if (sendType != null && (sendType.toLowerCase()).equals("get")) {
                return SmsClientAccessTool.getInstance().doAccessHTTPGet(
                    url + "?" + sendSms, backEncodType);
            } else {
                return SmsClientAccessTool.getInstance().doAccessHTTPPost(url,
                    sendSms, backEncodType);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "未发送，编码异常";
        }
    }

    // public static void main(String[] args) {
    // String sendUrl = "http://222.73.117.169/msg/HttpBatchSendSM";
    // System.out.println(Sms253ClientSend.sendSms(sendUrl, "N1315527",
    // "Ps7f18eab", "***", "【正汇科技】测试短信"));
    // }
}
