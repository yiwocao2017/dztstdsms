package com.std.sms.api.impl;

import com.std.sms.ao.IReceiverAO;
import com.std.sms.api.AProcessor;
import com.std.sms.common.JsonUtil;
import com.std.sms.domain.Receiver;
import com.std.sms.dto.req.XN804021Req;
import com.std.sms.exception.BizException;
import com.std.sms.exception.ParaException;
import com.std.sms.spring.SpringContextHolder;

/**
 * 列表查询接收者
 * @author: xieyj 
 * @since: 2016年11月26日 下午2:29:42 
 * @history:
 */
public class XN804021 extends AProcessor {
    private IReceiverAO receiverAO = SpringContextHolder
        .getBean(IReceiverAO.class);

    private XN804021Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Receiver condition = new Receiver();
        condition.setMobile(req.getMobile());
        condition.setSystemCode(req.getSystemCode());
        condition.setName(req.getName());
        condition.setLevel(req.getLevel());
        return receiverAO.queryReceiverList(condition);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN804021Req.class);
    }
}
