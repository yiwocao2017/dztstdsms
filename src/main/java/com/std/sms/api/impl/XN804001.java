package com.std.sms.api.impl;

import com.std.sms.ao.ISystemChannelAO;
import com.std.sms.api.AProcessor;
import com.std.sms.common.JsonUtil;
import com.std.sms.core.StringValidater;
import com.std.sms.domain.SystemChannel;
import com.std.sms.dto.req.XN804001Req;
import com.std.sms.dto.res.BooleanRes;
import com.std.sms.exception.BizException;
import com.std.sms.exception.ParaException;
import com.std.sms.spring.SpringContextHolder;

/**
 * 修改系统渠道
 * @author: xieyj 
 * @since: 2016年11月26日 上午11:08:13 
 * @history:
 */
public class XN804001 extends AProcessor {
    private ISystemChannelAO systemChannelAO = SpringContextHolder
        .getBean(ISystemChannelAO.class);

    private XN804001Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        SystemChannel data = new SystemChannel();
        data.setId(StringValidater.toLong(req.getId()));
        data.setSystemCode(req.getSystemCode());
        data.setChannelType(req.getChannelType());
        data.setPushType(req.getPushType());
        data.setStatus(req.getStatus());
        data.setPushSystem(req.getPushSystem());
        data.setPrivateKey1(req.getPrivateKey1());
        data.setPrivateKey2(req.getPrivateKey2());
        data.setPrivateKey3(req.getPrivateKey3());
        data.setPrivateKey4(req.getPrivateKey4());
        data.setPrivateKey5(req.getPrivateKey5());
        data.setPrivateKey6(req.getPrivateKey6());
        data.setRemark(req.getRemark());
        systemChannelAO.editSystemChannel(data);
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN804001Req.class);
        StringValidater.validateBlank(req.getId(), req.getSystemCode(),
            req.getChannelType(), req.getPushType(), req.getStatus());
    }
}
