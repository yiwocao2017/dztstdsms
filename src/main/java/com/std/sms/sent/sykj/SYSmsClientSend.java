package com.std.sms.sent.sykj;

import java.net.URLEncoder;

import com.std.sms.common.SmsClientAccessTool;

/**
 * <p>
 * <date>2012-03-01</date><br/>
 * <span>软维提供的JAVA接口信息（短信，彩信）调用API</span><br/>
 * <span>----------发送短信-------------</span>
 * </p>
 * @author: myb858 
 * @since: 2015年11月5日 下午2:39:37 
 * @history:
 */
public class SYSmsClientSend {

    /**
     * 第一章  发送接口
     * 其一：发送方式，默认为POST
     * 其二：发送内容编码方式，默认为UTF-8
     * @param url：必填--发送连接地址URL--比如>http://118.145.30.35/sms.aspx
     * @param userid ：必填--用户ID，为数字
     * @param account：必填--用户帐号
     * @param password：必填--用户密码
     * @param mobile：必填--发送的手机号码，多个可以用逗号隔比如>13512345678,13612345678
     * @param content：必填--实际发送内容，
     * @return 返回发送信息之后返回字符串
     */
    public static String sendSms(String url, String product, String account,
            String pswd, String mobile, String content) {
        return sendSms(url, product, account, pswd, mobile, content, "false",
            "POST", "UTF-8", "UTF-8");
    }

    private static String sendSms(String url, String product, String account,
            String pswd, String mobile, String content, String needstatus,
            String sendType, String codingType, String backEncodType) {
        try {
            if (codingType == null || codingType.equals("")) {
                codingType = "UTF-8";
            }
            if (backEncodType == null || backEncodType.equals("")) {
                backEncodType = "UTF-8";
            }
            StringBuffer send = new StringBuffer();
            send.append("product=").append(product);
            send.append("&account=").append(
                URLEncoder.encode(account, codingType));
            send.append("&pswd=").append(URLEncoder.encode(pswd, codingType));
            send.append("&mobile=").append(mobile);
            send.append("&msg=").append(URLEncoder.encode(content, codingType));
            send.append("&needstatus=").append(needstatus);
            if (sendType != null && (sendType.toLowerCase()).equals("get")) {
                return SmsClientAccessTool.getInstance().doAccessHTTPGet(
                    url + "?" + send.toString(), backEncodType);
            } else {
                return SmsClientAccessTool.getInstance().doAccessHTTPPost(url,
                    send.toString(), backEncodType);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "未发送，编码异常";
        }
    }

}
