package com.std.sms.ao;

public interface ISCaptchaAO {
    /** 
     * 执行发送验证码函数
     * @param channel
     * @param mobile
     * @return 
     * @create: 2016年7月10日 下午2:17:47 zuixian
     * @history: 
     */
    public String doSend(String channel, String mobile, String bizType);

    /**
     * 执行发送验证码函数
     * @param systemCode
     * @param companyCode
     * @param mobile
     * @param bizType
     * @return 
     * @create: 2017年2月13日 下午12:26:14 xieyj
     * @history:
     */
    public String doSendBySystem(String systemCode, String companyCode,
            String mobile, String bizType);

    /** 
     * 检查验证码是否正确
     * @param code
     * @param captcha
     * @return 验证码正确返回true
     * @create: 2016年7月10日 下午2:18:24 zuixian
     * @history: 
     */
    public boolean doCheck(String code, String captcha);

    /** 
     * 通过公司编号与手机号来检查验证码是否正确(公司编号就是系统编号)
     * @param companyCode
     * @param mobile
     * @param captcha
     * @return 
     * @create: 2016年10月17日 下午4:08:15 zuixian
     * @history: 
     */
    public boolean doCheckByCM(String companyCode, String mobile,
            String captcha, String bizType);

    /**
     * 通过系统编号，公司编号与手机号来检查验证码是否正确(系统编号)
     * @param systemCode
     * @param companyCode
     * @param mobile
     * @param captcha
     * @param bizType
     * @return 
     * @create: 2017年2月13日 下午2:24:22 xieyj
     * @history:
     */
    public boolean doCheckBySystem(String systemCode, String companyCode,
            String mobile, String captcha, String bizType);

    /**
     * 通过系统编号，公司编号与手机号来检查验证码是否正确(新平台概念)
     * @param sysytemCode
     * @param companyCode
     * @param mobile
     * @param captcha
     * @param bizType
     * @return 
     * @create: 2017年2月13日 下午12:54:27 xieyj
     * @history:
     */
    public boolean doCheckByCM(String systemCode, String companyCode,
            String mobile, String captcha, String bizType);
}
