/**
 * @Title ESmsBizType.java 
 * @Package com.ibis.pz.enums 
 * @Description 
 * @author miyb  
 * @date 2015-4-14 下午2:45:40 
 * @version V1.0   
 */
package com.std.sms.enums;

/** 
 * @author: miyb 
 * @since: 2015-4-14 下午2:45:40 
 * @history:
 */
public enum EBizType {
    REGISTER("1", "平台主账户-注册"), FINDLOGINPWD("2", "平台主账户-找回登陆密码"), RESETLOGINPWD(
            "3", "平台主账户-重置登陆密码"), SETTRADEPWD("4", "平台主账户-设置支付密码"), FINDTRADEPWD(
            "5", "平台主账户-找回支付密码"), RESETTRADEPWD("6", "平台主账户-重置支付密码"), CHANGEMOBILE(
            "7", "平台主账户-修改手机号码")

    , ChargeWithdraw("20", "平台主账户-充值取现"), Charge("21", "平台主账户-充值"), Charge_Yes(
            "22", "平台主账户-充值成功"), Charge_No("23", "平台主账户-充值失败"), Withdraw("25",
            "平台主账户-取现"), Withdraw_Yes("26", "平台主账户-取现成功"), Withdraw_No("27",
            "平台主账户-取现失败")

    , HongLan("30", "平台主账户-红冲蓝补"), Hong("31", "平台主账户-红冲"), Lan("32", "平台主账户-蓝补")

    , FAREN_ADD("98", "平台主账户-法人添加"), APP("99", "应用-委托发送");

    EBizType(String code, String value) {
        this.code = code;
        this.value = value;
    }

    private String code;

    private String value;

    public String getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }
}
