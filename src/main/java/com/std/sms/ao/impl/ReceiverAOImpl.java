package com.std.sms.ao.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.std.sms.ao.IReceiverAO;
import com.std.sms.bo.IReceiverBO;
import com.std.sms.bo.ISystemChannelBO;
import com.std.sms.bo.base.Paginable;
import com.std.sms.domain.Receiver;
import com.std.sms.domain.SystemChannel;
import com.std.sms.enums.EChannelType;
import com.std.sms.enums.EPushType;
import com.std.sms.exception.BizException;
import com.std.sms.sent.wechat.WeChatClientSend;

@Service
public class ReceiverAOImpl implements IReceiverAO {

    @Autowired
    private IReceiverBO receiverBO;

    @Autowired
    private ISystemChannelBO systemChannelBO;

    @Autowired
    private WeChatClientSend weChatClientSend;

    /** 
     * @see com.std.sms.ao.IReceiverAO#synchReceivers()
     */
    @Override
    public void synchReceivers() {
    }

    /**
     * @see com.std.sms.ao.IReceiverAO#importReceivers(java.lang.String, java.util.List)
     */
    @Override
    public void importReceivers(String systemCode, List<Receiver> dataList) {
        for (Receiver data : dataList) {
            data.setSystemCode(systemCode);
            if (StringUtils.isNotBlank(data.getMobile())
                    && StringUtils.isNotBlank(data.getName())) {
                boolean result = receiverBO.isExistReceiver(data.getMobile(),
                    data.getSystemCode(), null);
                if (result) {
                    continue;
                }
                receiverBO.saveReceiver(data);
            }
        }
    }

    @Override
    public void importWxReceiver(String mobile, String systemCode,
            String wechatId, String remark) {
        Receiver receiver = receiverBO.getReceiverByWechatId(wechatId,
            systemCode);
        // Receiver receiver = receiverBO.getReceiverNotError(mobile,
        // systemCode);
        // 获取用户名
        SystemChannel systemChannel = systemChannelBO
            .getSystemChannelByCondition(systemCode, EChannelType.WECHAT,
                EPushType.WEIXIN.getCode());
        String nickname = weChatClientSend.getNickname(
            systemChannel.getPrivateKey3(), wechatId);
        if (receiver != null) {
            receiverBO.refreshReceiverWechatId(receiver.getMobile(),
                systemCode, nickname, wechatId, remark);
        } else {
            Receiver data = new Receiver();
            data.setMobile(mobile);
            data.setSystemCode(systemCode);
            data.setName(nickname);
            data.setWechatId(wechatId);
            data.setRemark(remark);
            receiverBO.saveReceiver(data);
        }
    }

    @Override
    public void addReceiver(Receiver data) {
        boolean result = receiverBO.isExistReceiver(data.getMobile(),
            data.getSystemCode(), null);
        if (result) {
            throw new BizException("xn702002", "接收者已存在");
        }
        receiverBO.saveReceiver(data);
    }

    @Override
    public void editReceiver(Receiver data) {
        receiverBO.getReceiver(data.getMobile(), data.getSystemCode());
        receiverBO.refreshReceiver(data);
    }

    @Override
    public void dropReceiver(String mobile, String systemCode) {
        receiverBO.getReceiver(mobile, systemCode);
        receiverBO.removeReceiver(mobile, systemCode);
    }

    @Override
    public Paginable<Receiver> queryReceiverPage(int start, int limit,
            Receiver condition) {
        return receiverBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<Receiver> queryReceiverList(Receiver condition) {
        return receiverBO.queryReceiverList(condition);
    }

    @Override
    public Receiver getReceiver(String mobile, String systemCode) {
        return receiverBO.getReceiver(mobile, systemCode);
    }
}
