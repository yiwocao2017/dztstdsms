package com.std.sms.bo;

import java.util.List;

import com.std.sms.bo.base.IPaginableBO;
import com.std.sms.domain.Receiver;

public interface IReceiverBO extends IPaginableBO<Receiver> {

    public boolean isExistReceiver(String mobile, String systemCode,
            String level);

    public String saveReceiver(Receiver data);

    public int removeReceiver(String mobile, String systemCode);

    public int refreshReceiver(Receiver data);

    public int refreshReceiverWechatId(String mobile, String systemCode,
            String name, String wechatId, String remark);

    public int refreshReceiverJpushId(String mobile, String systemCode,
            String jpushId, String remark);

    public List<Receiver> queryReceiverList(Receiver condition);

    public Receiver getReceiver(String mobile, String systemCode);

    public Receiver getReceiverNotError(String mobile, String systemCode);

    public Receiver getReceiverByWechatId(String wechatId, String systemCode);
}
