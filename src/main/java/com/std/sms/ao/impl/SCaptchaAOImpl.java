package com.std.sms.ao.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.std.sms.ao.ISCaptchaAO;
import com.std.sms.bo.ICompanyBO;
import com.std.sms.bo.IConfigureBO;
import com.std.sms.bo.ISCaptchaBO;
import com.std.sms.domain.Company;
import com.std.sms.domain.SCaptcha;
import com.std.sms.enums.ESmsStatus;
import com.std.sms.exception.BizException;
import com.std.sms.sent.Senter;
import com.std.sms.sent.SystemCodeSenter;
import com.std.sms.util.PhoneUtil;
import com.std.sms.util.RandomUtil;

@Service
public class SCaptchaAOImpl implements ISCaptchaAO {

    @Autowired
    ICompanyBO companyBO;

    @Autowired
    IConfigureBO configureBO;

    @Autowired
    Senter senter;

    @Autowired
    SystemCodeSenter systemCodeSenter;

    @Autowired
    ISCaptchaBO sCaptchaBO;

    @Override
    @Transactional
    public String doSend(String channel, String mobile, String bizType) {
        String[] str = channel.split("-");
        String captcha = RandomUtil.generate4();
        String captchaContent = addContent(mobile, captcha);
        String content = changeContent(str[0], captchaContent);
        String code = sCaptchaBO
            .savaSCaptcha(channel, mobile, captcha, bizType);
        senter.send(str[0], channel, mobile, content);
        return code;
    }

    @Override
    public String doSendBySystem(String systemCode, String companyCode,
            String mobile, String bizType) {
        String captcha = RandomUtil.generate4();
        String captchaContent = addContent(mobile, captcha);
        String content = changeContent(systemCode, captchaContent);
        String code = sCaptchaBO.savaSCaptcha(mobile, captcha, bizType,
            companyCode, systemCode);
        String channel = configureBO.getConfigureChannel(systemCode);
        systemCodeSenter.send(systemCode, "K", channel, mobile, content);
        return code;
    }

    @Override
    public boolean doCheck(String code, String captcha) {
        boolean result = false;
        SCaptcha data = sCaptchaBO.getSCaptcha(code);
        if (data == null) {
            throw new BizException("xn799002", "该短信验证码不存在!");
        }
        Date invalidDatetime = data.getInvalidDatetime();
        Date now = new Date();
        if (data.getCaptcha().equals(captcha)
                && invalidDatetime.after(now)
                && !data.getStatus().equalsIgnoreCase(
                    ESmsStatus.CHECKED.getCode())) {
            data.setStatus(ESmsStatus.CHECKED.getCode());
            data.setCheckDatetime(now);
            sCaptchaBO.refreshSCaptchaInfo(data);
            result = true;
        } else {
            throw new BizException("xn799002", "验证码错误或失效!");
        }
        return result;
    }

    @Override
    public boolean doCheckByCM(String companyCode, String mobile,
            String captcha, String bizType) {
        boolean result = false;
        SCaptcha data = sCaptchaBO
            .getSCaptchaByCM(companyCode, mobile, bizType);
        if (data == null) {
            throw new BizException("xn799002", "该短信验证码不存在!");
        }
        Date invalidDatetime = data.getInvalidDatetime();
        Date now = new Date();
        if (data.getCaptcha().equals(captcha)
                && invalidDatetime.after(now)
                && !data.getStatus().equalsIgnoreCase(
                    ESmsStatus.CHECKED.getCode())) {
            data.setStatus(ESmsStatus.CHECKED.getCode());
            data.setCheckDatetime(now);
            sCaptchaBO.refreshSCaptchaInfo(data);
            result = true;
        } else {
            throw new BizException("xn799002", "验证码错误或失效!");
        }
        return result;
    }

    @Override
    public boolean doCheckBySystem(String systemCode, String companyCode,
            String mobile, String captcha, String bizType) {
        boolean result = false;
        SCaptcha data = sCaptchaBO.getSCaptchaByCM(systemCode, companyCode,
            mobile, bizType);
        if (data == null) {
            throw new BizException("xn799002", "该短信验证码不存在!");
        }
        Date invalidDatetime = data.getInvalidDatetime();
        Date now = new Date();
        if (data.getCaptcha().equals(captcha)
                && invalidDatetime.after(now)
                && !data.getStatus().equalsIgnoreCase(
                    ESmsStatus.CHECKED.getCode())) {
            data.setStatus(ESmsStatus.CHECKED.getCode());
            data.setCheckDatetime(now);
            sCaptchaBO.refreshSCaptchaInfo(data);
            result = true;
        } else {
            throw new BizException("xn799002", "验证码错误或失效!");
        }
        return result;
    }

    @Override
    public boolean doCheckByCM(String systemCode, String companyCode,
            String mobile, String captcha, String bizType) {
        boolean result = false;
        SCaptcha data = sCaptchaBO.getSCaptchaByCM(systemCode, companyCode,
            mobile, bizType);
        if (data == null) {
            throw new BizException("xn799002", "该短信验证码不存在!");
        }
        Date invalidDatetime = data.getInvalidDatetime();
        Date now = new Date();
        if (data.getCaptcha().equals(captcha)
                && invalidDatetime.after(now)
                && !data.getStatus().equalsIgnoreCase(
                    ESmsStatus.CHECKED.getCode())) {
            data.setStatus(ESmsStatus.CHECKED.getCode());
            data.setCheckDatetime(now);
            sCaptchaBO.refreshSCaptchaInfo(data);
            result = true;
        } else {
            throw new BizException("xn799002", "验证码错误或失效!");
        }
        return result;
    }

    public String changeContent(String companyCode, String content) {
        Company data = companyBO.queryCompany(companyCode);
        String result = content;
        if (data != null && null != data.getPrefix()) {
            result = "【" + data.getPrefix() + "】" + result;
        }
        return result;
    }

    private String addContent(String mobile, String captcha) {
        return "尊敬的" + PhoneUtil.hideMobile(mobile) + "用户, 您的验证码为" + captcha
                + "，请妥善保管此验证码，切勿泄露给他人。";
    }
}
