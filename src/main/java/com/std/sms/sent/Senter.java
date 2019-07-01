package com.std.sms.sent;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.std.sms.bo.IConfigureBO;
import com.std.sms.common.PropertiesUtil;
import com.std.sms.exception.BizException;
import com.std.sms.sent.csmd.CsmdWebServiceClient;
import com.std.sms.sent.hhxx.SmsClientSend;
import com.std.sms.sent.s253.Sms253ClientSend;
import com.std.sms.sent.sykj.SYSmsClientSend;

/**
 * 发短信 返回信息详见文档。
 * 
 * @author Administrator
 * 
 */
@Component
public class Senter {
    protected static final Logger logger = LoggerFactory
        .getLogger(Senter.class);

    @Autowired
    private IConfigureBO configureBO;

    public void send(String companyCode, String channel, String mobileNumber,
            String content) throws BizException {
        String[] str = channel.split("-");
        if (str[1].equalsIgnoreCase("CSMD")) {
            this.sendByCSMD(companyCode, channel, content, mobileNumber);
        } else if (str[1].equalsIgnoreCase("HHXX")) {
            this.sendByHHXX(companyCode, channel, content, mobileNumber);
        } else if (str[1].equalsIgnoreCase("SYKJ")) {
            this.sendBySYKJ(companyCode, channel, content, mobileNumber);
        } else if (str[1].equalsIgnoreCase("Z253")) {
            this.sendBy253(companyCode, channel, content, mobileNumber);
        } else {
            throw new BizException("xn709901", "短信配置信息，channel未定义");
        }
    }

    private void sendByHHXX(String companyCode, String channel, String content,
            String mobileNumber) throws BizException {
        String userid = null;
        String account = null;
        String password = null;
        String[] str = channel.split("-");
        if (str[2].equalsIgnoreCase("K") || str[2].equalsIgnoreCase("D")) {
            userid = configureBO.doGetConfigure(companyCode, str[1],
                "hhxx_userid_1").getValue();
            account = configureBO.doGetConfigure(companyCode, str[1],
                "hhxx_account_1").getValue();
            password = configureBO.doGetConfigure(companyCode, str[1],
                "hhxx_password_1").getValue();
        } else {
            userid = configureBO.doGetConfigure(companyCode, str[1],
                "hhxx_userid_2").getValue();
            account = configureBO.doGetConfigure(companyCode, str[1],
                "hhxx_account_2").getValue();
            password = configureBO.doGetConfigure(companyCode, str[1],
                "hhxx_password_2").getValue();
        }
        if (userid == null || account == null || password == null) {
            throw new BizException("xn709901",
                "短信发送失败，userid或account或password未定义");
        }
        try {
            String url = PropertiesUtil.Config.HHXX_URL;
            // "http://118.145.18.144:5888/sms.aspx";
            String res = SmsClientSend.sendSms(url, userid, account, password,
                mobileNumber, content);
            // 发送短信，如果是以负号开头就是发送失败。
            if (!res.contains("ok")) {
                throw new BizException("xn709901", "短信发送失败，错误代码：" + res);
            }
        } catch (Exception e) {
            throw new BizException("xn709901", "汇禾信息发送短信未知错误");
        }
    }

    private void sendBySYKJ(String companyCode, String channel, String content,
            String mobileNumber) throws BizException {
        String product = null;
        String account = null;
        String password = null;
        String[] str = channel.split("-");
        product = configureBO.doGetConfigure(companyCode, str[1],
            "sykj_product").getValue();
        account = configureBO.doGetConfigure(companyCode, str[1],
            "sykj_account").getValue();
        password = configureBO.doGetConfigure(companyCode, str[1],
            "sykj_password").getValue();
        if (account == null || password == null) {
            throw new BizException("xn709901", "短信发送失败，account或password未定义");
        }
        try {
            String url = PropertiesUtil.Config.SYKJ_URL;
            // "http://send.18sms.com/msg/HttpBatchSendSM";
            String res = SYSmsClientSend.sendSms(url, product, account,
                password, mobileNumber, content);
            // 发送短信，如果是以负号开头就是发送失败。
            if (!res.contains(",0")) {
                throw new BizException("xn709901", "错误代码:" + res);
            }
        } catch (Exception e) {
            throw new BizException("xn709901", "示远科技短信发送错误，报错原因:"
                    + e.getMessage());
        }
    }

    private void sendBy253(String companyCode, String channel, String content,
            String mobileNumber) throws BizException {
        String account = null;
        String password = null;
        String[] str = channel.split("-");
        account = configureBO.doGetConfigure(companyCode, str[1],
            "z253_account").getValue();
        password = configureBO.doGetConfigure(companyCode, str[1],
            "z253_password").getValue();
        if (account == null || password == null) {
            throw new BizException("xn709901", "短信发送失败，account或password未定义");
        }
        try {
            String url = PropertiesUtil.Config.Z253_URL;
            // "http://222.73.117.169/msg/HttpBatchSendSM";
            String res = Sms253ClientSend.sendSms(url, account, password,
                mobileNumber, content);
            // 发送短信，如果是以负号开头就是发送失败。
            if (!res.contains(",0")) {
                throw new BizException("xn709901", "短信发送失败，错误代码：" + res);
            }
        } catch (Exception e) {
            logger.error("253短信错误", e.getMessage());
            throw new BizException("xn709901", "253平台短信发送未知错误");
        }
    }

    private void sendByCSMD(String companyCode, String channel, String content,
            String mobileNumber) throws BizException {
        // String sn = props.getProperty("csmd_sn");
        // String pwd = props.getProperty("csmd_password");
        String[] str = channel.split("-");
        String sn = configureBO.doGetConfigure(companyCode, str[1], "csmd_sn")
            .getValue();
        String pwd = configureBO.doGetConfigure(companyCode, str[1],
            "csmd_password").getValue();
        if (sn == null || pwd == null) {
            throw new BizException("xn709901", "短信发送失败，sn或password未定义");
        }
        try {
            content = URLEncoder.encode(content, "utf-8");
            CsmdWebServiceClient client = new CsmdWebServiceClient(sn, pwd);
            String result_mt = client.mdSmsSend_u(mobileNumber, content, "",
                "", "");
            // 发送短信，如果是以负号开头就是发送失败。
            if (result_mt.startsWith("-") || result_mt.equals("")) {
                throw new BizException("xn709901", "短信发送失败，错误代码：" + result_mt);
            }
        } catch (UnsupportedEncodingException e) {
            throw new BizException("xn709901", "创世漫道发送短信未知错误");
        }
    }

    public static void main(String[] args) {
        // new Senter().send("XN1001", "CSMD",
        // "【雄牛科技】尊敬的用户,您的验证码是678987 ,请妥善保留",
        // "15088750712");
    }
}
