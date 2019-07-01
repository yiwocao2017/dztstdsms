package com.std.sms.api.impl;

import com.std.sms.ao.IReceiverAO;
import com.std.sms.api.AProcessor;
import com.std.sms.common.JsonUtil;
import com.std.sms.core.StringValidater;
import com.std.sms.dto.req.XN804014Req;
import com.std.sms.dto.res.BooleanRes;
import com.std.sms.exception.BizException;
import com.std.sms.exception.ParaException;
import com.std.sms.spring.SpringContextHolder;

/**
 * 微信回调设置接收者
 * @author: xieyj 
 * @since: 2016年11月26日 下午2:29:42 
 * @history:
 */
public class XN804014 extends AProcessor {
    private IReceiverAO receiverAO = SpringContextHolder
        .getBean(IReceiverAO.class);

    private XN804014Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        receiverAO.importWxReceiver(req.getMobile(), req.getSystemCode(),
            req.getWechatId(), req.getRemark());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN804014Req.class);
        StringValidater.validateBlank(req.getMobile(), req.getSystemCode(),
            req.getWechatId());
    }
}
