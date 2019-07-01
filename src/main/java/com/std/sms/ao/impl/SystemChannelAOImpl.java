package com.std.sms.ao.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.std.sms.ao.ISystemChannelAO;
import com.std.sms.bo.ISystemChannelBO;
import com.std.sms.bo.base.Paginable;
import com.std.sms.domain.SystemChannel;
import com.std.sms.enums.EChannelType;
import com.std.sms.enums.EPushType;
import com.std.sms.exception.BizException;
import com.std.sms.sent.wechat.WeChatClientSend;

@Service
public class SystemChannelAOImpl implements ISystemChannelAO {
    protected static final Logger logger = LoggerFactory
        .getLogger(WeChatClientSend.class);

    @Autowired
    private ISystemChannelBO systemChannelBO;

    @Autowired
    private WeChatClientSend weChatClientSend;

    @Override
    public void addSystemChannel(SystemChannel data) {
        if (systemChannelBO.isSystemChannelExist(data.getSystemCode(),
            data.getChannelType(), data.getPushType(), null)) {
            throw new BizException("xn0000", "该系统渠道已存在");
        }
        systemChannelBO.saveSystemChannel(data);
    }

    @Override
    public void editSystemChannel(SystemChannel data) {
        if (!systemChannelBO.isSystemChannelExist(data.getId())) {
            throw new BizException("xn0000", "记录编号不存在");
        }
        if (systemChannelBO.isSystemChannelExist(data.getSystemCode(),
            data.getChannelType(), data.getPushType(), data.getId())) {
            throw new BizException("xn0000", "该系统渠道已存在");
        }
        systemChannelBO.refreshSystemChannel(data);
    }

    @Override
    public void editSystemChannelRemark(Long id, String remark) {
        if (!systemChannelBO.isSystemChannelExist(id)) {
            throw new BizException("xn0000", "记录编号不存在");
        }
        systemChannelBO.refreshSystemChannel(id, remark);
    }

    @Override
    public void dropSystemChannel(Long id) {
        if (!systemChannelBO.isSystemChannelExist(id)) {
            throw new BizException("xn0000", "记录编号不存在");
        }
        systemChannelBO.removeSystemChannel(id);
    }

    @Override
    public Paginable<SystemChannel> querySystemChannelPage(int start,
            int limit, SystemChannel condition) {
        return systemChannelBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<SystemChannel> querySystemChannelList(SystemChannel condition) {
        return systemChannelBO.querySystemChannelList(condition);
    }

    @Override
    public SystemChannel getSystemChannel(Long id) {
        return systemChannelBO.getSystemChannel(id);
    }

    @Override
    public void doAccessTokenDaily() {
        logger.info("*****************更新微信accessToken_begin*****************");
        SystemChannel condition = new SystemChannel();
        condition.setChannelType(EChannelType.WECHAT.getCode());
        condition.setPushType(EPushType.WEIXIN.getCode());
        List<SystemChannel> dataList = systemChannelBO
            .querySystemChannelList(condition);
        if (CollectionUtils.isNotEmpty(dataList)) {
            for (SystemChannel data : dataList) {
                String accessToken = weChatClientSend.getAccessToken(
                    data.getPrivateKey1(), data.getPrivateKey2());
                systemChannelBO.refreshSystemChannel(data.getId(), accessToken);
            }
        }
        logger.info("*****************更新微信accessToken_end*****************");
    }
}
