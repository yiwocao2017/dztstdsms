package com.std.sms.dto.req;

public class XN799002Req {
    // 待验证的手机验证码的编号--必填
    private String code;

    // 待验证的手机验证码
    private String captcha;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }
}
