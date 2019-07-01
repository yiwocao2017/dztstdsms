package com.std.sms.api.impl;

import com.std.sms.ao.ISystemChannelAO;
import com.std.sms.api.AProcessor;
import com.std.sms.dto.req.XN804010Req;
import com.std.sms.exception.BizException;
import com.std.sms.exception.ParaException;
import com.std.sms.spring.SpringContextHolder;

/**
 * 同步接收者
 * @author: xieyj 
 * @since: 2016年11月26日 下午2:28:55 
 * @history:
 */
public class XN804010 extends AProcessor {
    private ISystemChannelAO systemChannelAO = SpringContextHolder
        .getBean(ISystemChannelAO.class);

    private XN804010Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return null;
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
    }
}
