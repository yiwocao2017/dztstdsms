package com.std.sms.api.impl;

import com.std.sms.ao.ISystemChannelAO;
import com.std.sms.api.AProcessor;
import com.std.sms.common.JsonUtil;
import com.std.sms.domain.SystemChannel;
import com.std.sms.dto.req.XN804006Req;
import com.std.sms.exception.BizException;
import com.std.sms.exception.ParaException;
import com.std.sms.spring.SpringContextHolder;

/**
 * 列表查询系统渠道
 * @author: xieyj 
 * @since: 2016年11月26日 上午11:08:13 
 * @history:
 */
public class XN804006 extends AProcessor {
    private ISystemChannelAO systemChannelAO = SpringContextHolder
        .getBean(ISystemChannelAO.class);

    private XN804006Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        SystemChannel condition = new SystemChannel();
        condition.setSystemCode(req.getSystemCode());
        condition.setChannelType(req.getChannelType());
        condition.setPushType(req.getPushType());
        condition.setStatus(req.getStatus());
        return systemChannelAO.querySystemChannelList(condition);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN804006Req.class);
    }
}
