package com.std.sms.ao;

import java.util.List;

import com.std.sms.bo.base.Paginable;
import com.std.sms.domain.Receiver;

public interface IReceiverAO {
    static final String DEFAULT_ORDER_COLUMN = "system_code";

    /**
     * 同步接收者
     * @create: 2016年11月20日 下午4:21:27 xieyj
     * @history:
     */
    public void synchReceivers();

    /**
     * 导入接收者
     * @param systemCode
     * @param dataList 
     * @create: 2016年11月26日 下午2:31:01 xieyj
     * @history:
     */
    public void importReceivers(String systemCode, List<Receiver> dataList);

    /**
     * 微信回调，填充wechatId
     * @param systemCode
     * @param openId
     * @param mobile 
     * @create: 2016年12月2日 下午4:49:37 xieyj
     * @history:
     */
    public void importWxReceiver(String mobile, String systemCode,
            String wechatId, String remark);

    public void addReceiver(Receiver data);

    public void dropReceiver(String mobile, String systemCode);

    public void editReceiver(Receiver data);

    public Paginable<Receiver> queryReceiverPage(int start, int limit,
            Receiver condition);

    public List<Receiver> queryReceiverList(Receiver condition);

    public Receiver getReceiver(String mobile, String systemCode);

}
