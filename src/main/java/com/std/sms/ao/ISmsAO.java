package com.std.sms.ao;

import java.util.List;

import com.std.sms.bo.base.Paginable;
import com.std.sms.domain.Sms;

public interface ISmsAO {
    static final String DEFAULT_ORDER_COLUMN = "id";

    /**
     * 短信发送
     * @param data
     * @return 
     * @create: 2016年11月20日 下午4:45:14 xieyj
     * @history:
     */
    public void toSendDxSms(Sms data);

    /**
     * 极光发送
     * @param data
     * @return 
     * @create: 2016年11月20日 下午4:45:14 xieyj
     * @history:
     */
    public void toSendJgSms(Sms data);

    /**
     * 微信发送
     * @param data
     * @return 
     * @create: 2016年11月20日 下午4:45:14 xieyj
     * @history:
     */
    public void toSendWxSms(Sms data);

    /**
     * 新增公告
     * @param data 
     * @create: 2016年11月29日 下午5:20:18 xieyj
     * @history:
     */
    public void addNoticeSms(Sms data);

    /**
     * 修改公告
     * @param data 
     * @create: 2016年11月29日 下午6:13:23 xieyj
     * @history:
     */
    public void editNoticeSms(Sms data);

    /**
     * 公告发布/下撤
     * @param id
     * @param updater 
     * @create: 2016年11月29日 下午5:18:51 xieyj
     * @history:
     */
    public void toSendNoticeSms(Long id, String updater);

    /**
     * @param data
     * @return 
     * @create: 2016年11月20日 下午4:45:14 xieyj
     * @history:
     */
    public void toSendSms(Sms data);

    /**
     * 失败重发
     * @param data
     * @return 
     * @create: 2016年11月20日 下午4:44:07 xieyj
     * @history:
     */
    public void reSendSms(Long id);

    /**
     * 成功再发
     * @param id
     * @return 
     * @create: 2016年11月20日 下午4:43:24 xieyj
     * @history:
     */
    public void copySms(Long id);

    /**
     * 定时器触发发送短信
     * @create: 2016年11月20日 下午4:46:53 xieyj
     * @history:
     */
    public void doSmsDaily();

    public Paginable<Sms> querySmsPage(int start, int limit, Sms condition);

    public List<Sms> querySmsList(Sms condition);

    public Sms getSms(Long id);
}
