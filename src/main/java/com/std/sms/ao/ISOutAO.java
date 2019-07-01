package com.std.sms.ao;

import com.std.sms.bo.base.Paginable;
import com.std.sms.domain.SOut;

public interface ISOutAO {

    String DEFAULT_ORDER_COLUMN = "code";

    /** 
     * 执行发送短信函数
     * @param mobile
     * @param content
     * @param channel
     * @return 
     * @create: 2016年7月7日 下午5:44:57 zuixian
     * @history: 
     */
    public String doSend(String channel, String mobile, String content,
            String sendDatetime);

    /**
     * 发送短信(平台级)
     * @param type
     * @param mobile
     * @param content
     * @param sendDatetime
     * @param companyCode
     * @param systemCode
     * @return 
     * @create: 2017年2月13日 下午1:09:02 xieyj
     * @history:
     */
    public String doSendBySystemCode(String type, String mobile,
            String content, String sendDatetime, String companyCode,
            String systemCode);

    /** 
     * 执行保存已发短信
     * @param moible
     * @param content
     * @param flag
     * @return 
     * @create: 2016年7月7日 下午5:45:34 zuixian
     * @history: 
     */
    public String doSaveSOut(String channel, String mobile, String content);

    /** 
     * 分页查询已发短信
     * @param start
     * @param limit
     * @param condition
     * @return 
     * @create: 2016年7月10日 上午11:07:04 zuixian
     * @history: 
     */
    public Paginable<SOut> querySOutPage(int start, int limit, SOut condition);
}
