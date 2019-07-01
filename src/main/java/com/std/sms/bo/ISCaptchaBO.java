package com.std.sms.bo;

import com.std.sms.bo.base.IPaginableBO;
import com.std.sms.domain.SCaptcha;

public interface ISCaptchaBO extends IPaginableBO<SCaptcha> {
    /** 
     * 保存验证码
     * @param data 
     * @create: 2016年7月10日 下午2:11:25 zuixian
     * @history: 
     */
    public String savaSCaptcha(String channel, String mobile, String captcha,
            String bizType);

    /**
     * 保存验证码
     * @param mobile
     * @param channel
     * @param captcha
     * @param bizType
     * @param companyCode
     * @param systemCode
     * @return 
     * @create: 2017年2月2日 上午10:46:38 xieyj
     * @history:
     */
    public String savaSCaptcha(String mobile, String captcha, String bizType,
            String companyCode, String systemCode);

    /**
     * 获取验证码
     * @param data 
     * @create: 2016年7月10日 下午2:11:48 zuixian
     * @history: 
     */
    public SCaptcha getSCaptcha(String code);

    /** 
     * 通过手机号与公司编号获取验证码
     * @param code
     * @return 
     * @create: 2016年10月17日 下午4:00:59 zuixian
     * @history: 
     */
    public SCaptcha getSCaptchaByCM(String companyCode, String mobile,
            String bizType);

    /**
     * 通过系统编号，手机号与公司编号获取验证码
     * @param systemCode
     * @param companyCode
     * @param mobile
     * @param bizType
     * @return 
     * @create: 2017年2月13日 下午12:56:05 xieyj
     * @history:
     */
    public SCaptcha getSCaptchaByCM(String systemCode, String companyCode,
            String mobile, String bizType);

    /** 
     * 更新验证码信息
     * @param code 
     * @create: 2016年7月10日 下午2:58:51 zuixian
     * @history: 
     */
    public void refreshSCaptchaInfo(SCaptcha data);
}
