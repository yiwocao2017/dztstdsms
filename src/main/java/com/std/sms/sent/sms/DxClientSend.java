package com.std.sms.sent.sms;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.std.sms.bo.ISystemChannelBO;
import com.std.sms.domain.SystemChannel;
import com.std.sms.enums.EChannelType;
import com.std.sms.enums.EPushType;
import com.std.sms.exception.BizException;
import com.std.sms.sent.csmd.CsmdWebServiceClient;
import com.std.sms.sent.hhxx.SmsClientSend;
import com.std.sms.sent.s253.Sms253ClientSend;
import com.std.sms.sent.sykj.SYSmsClientSend;

/**
 * @author: xieyj 
 * @since: 2016年11月27日 下午2:41:08 
 * @history:
 */
@Component
public class DxClientSend {
    protected static final Logger logger = LoggerFactory
        .getLogger(DxClientSend.class);

    @Autowired
    private ISystemChannelBO systemChannelBO;

    public boolean sendSms(String systemCode, String mobile, String content,
            String pushType) {
        boolean result = true;
        SystemChannel smsSc = systemChannelBO.getSystemChannelByCondition(
            systemCode, EChannelType.SMS, pushType);
        if (smsSc == null) {
            logger.error("找不到短信发送渠道!");
            return false;
        }
        if (StringUtils.isNotBlank(smsSc.getRemark())) {
            content = "【" + smsSc.getRemark() + "】" + content;
        }
        if (EPushType.CSMD.getCode().equals(pushType)) {
            result = this.sendByCSMD(smsSc.getPrivateKey1(),
                smsSc.getPrivateKey2(), mobile, content);
        } else if (EPushType.HHXX.getCode().equals(pushType)) {
            result = this
                .sendByHHXX(smsSc.getPrivateKey1(), smsSc.getPrivateKey2(),
                    smsSc.getPrivateKey3(), mobile, content);
        } else if (EPushType.SYKJ.getCode().equals(pushType)) {
            result = this
                .sendBySYKJ(smsSc.getPrivateKey1(), smsSc.getPrivateKey2(),
                    smsSc.getPrivateKey3(), mobile, content);
        } else if (EPushType.Z253.getCode().equals(pushType)) {
            result = this.sendBy253(smsSc.getPrivateKey1(),
                smsSc.getPrivateKey2(), mobile, content);
        }
        return result;
    }

    public boolean sendByCSMD(String sn, String password, String mobile,
            String content) throws BizException {
        boolean result = false;
        if (StringUtils.isBlank(sn) || StringUtils.isBlank(password)) {
            logger.error("短信发送失败，sn或password未定义");
            return result;
        }
        try {
            content = URLEncoder.encode(content, "utf-8");
            CsmdWebServiceClient client = new CsmdWebServiceClient(sn, password);
            String result_mt = client.mdSmsSend_u(mobile, content, "", "", "");
            // 发送短信，如果是以负号开头就是发送失败。
            if (result_mt.startsWith("-") || result_mt.equals("")) {
                logger.error("短信发送失败，错误代码：" + result_mt);
            } else {
                result = true;
            }
        } catch (UnsupportedEncodingException e) {
            logger.error("创世漫道发送短信未知错误", e);
        }
        return result;
    }

    public boolean sendByHHXX(String account, String password, String userid,
            String mobile, String content) throws BizException {
        boolean result = false;
        if (StringUtils.isBlank(userid) || StringUtils.isBlank(account)
                || StringUtils.isBlank(password)) {
            logger.error("短信发送失败，userid或account或password未定义");
            return result;
        }
        try {
            String url = "http://118.145.18.144:5888/sms.aspx";
            String res = SmsClientSend.sendSms(url, userid, account, password,
                mobile, content);
            // 发送短信，如果是以负号开头就是发送失败。
            if (!res.contains("ok")) {
                logger.error("xn709901", "短信发送失败，错误代码：" + res);
            } else {
                result = true;
            }
        } catch (Exception e) {
            logger.error("xn709901", "汇禾信息发送短信未知错误", e);
        }
        return result;
    }

    public boolean sendBySYKJ(String account, String password, String product,
            String mobileNumber, String content) throws BizException {
        boolean result = false;
        if (product == null || account == null || password == null) {
            // throw new BizException("xn709901",
            // "短信发送失败，product或account或password未定义");
            logger.error("短信发送失败，product或account或password未定义");
            return result;
        }
        try {
            String url = "http://send.18sms.com/msg/HttpBatchSendSM";
            String res = SYSmsClientSend.sendSms(url, product, account,
                password, mobileNumber, content);
            // 发送短信，如果是以负号开头就是发送失败。
            if (!res.contains(",0")) {
                logger.error("短信发送失败，错误代码：" + res);
                result = false;
            } else {
                result = true;
            }
        } catch (Exception e) {
            logger.error("xn709901", "示远科技短信发送未知错误", e);
        }
        return result;
    }

    public boolean sendBy253(String account, String password,
            String mobileNumber, String content) throws BizException {
        boolean result = false;
        if (account == null || password == null) {
            logger.error("xn709901", "短信发送失败，account或password未定义");
            return result;
        }
        try {
            String url = "http://222.73.117.169/msg/HttpBatchSendSM";
            String res = Sms253ClientSend.sendSms(url, account, password,
                mobileNumber, content);
            // 发送短信，如果是以负号开头就是发送失败。
            if (!res.contains(",0")) {
                logger.error("xn709901", "短信发送失败，错误代码：" + res);
                result = false;
            } else {
                result = true;
            }
        } catch (Exception e) {
            logger.error("xn709901", "253平台短信发送未知错误");
        }
        return result;
    }
}
