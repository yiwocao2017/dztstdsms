package com.std.sms.api.impl;

import com.std.sms.ao.IReceiverAO;
import com.std.sms.api.AProcessor;
import com.std.sms.common.JsonUtil;
import com.std.sms.core.StringValidater;
import com.std.sms.domain.Receiver;
import com.std.sms.dto.req.XN804012Req;
import com.std.sms.dto.res.BooleanRes;
import com.std.sms.exception.BizException;
import com.std.sms.exception.ParaException;
import com.std.sms.spring.SpringContextHolder;

/**
 * 新增接收者
 * @author: xieyj 
 * @since: 2016年11月26日 下午2:29:42 
 * @history:
 */
public class XN804012 extends AProcessor {
    private IReceiverAO receiverAO = SpringContextHolder
        .getBean(IReceiverAO.class);

    private XN804012Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Receiver data = new Receiver();
        data.setMobile(req.getMobile());
        data.setSystemCode(req.getSystemCode());
        data.setName(req.getName());
        data.setLevel(req.getLevel());
        data.setJpushId(req.getJpushId());
        data.setWechatId(req.getWechatId());
        data.setRemark(req.getRemark());
        receiverAO.addReceiver(data);
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN804012Req.class);
        StringValidater.validateBlank(req.getMobile(), req.getSystemCode(),
            req.getName());
    }
}
