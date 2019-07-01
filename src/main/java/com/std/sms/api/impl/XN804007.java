package com.std.sms.api.impl;

import com.std.sms.ao.ISystemChannelAO;
import com.std.sms.api.AProcessor;
import com.std.sms.common.JsonUtil;
import com.std.sms.core.StringValidater;
import com.std.sms.dto.req.XN804007Req;
import com.std.sms.exception.BizException;
import com.std.sms.exception.ParaException;
import com.std.sms.spring.SpringContextHolder;

/**
 * 详情查询系统渠道
 * @author: xieyj 
 * @since: 2016年11月26日 上午11:08:13 
 * @history:
 */
public class XN804007 extends AProcessor {
    private ISystemChannelAO systemChannelAO = SpringContextHolder
        .getBean(ISystemChannelAO.class);

    private XN804007Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Long id = StringValidater.toLong(req.getId());
        return systemChannelAO.getSystemChannel(id);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN804007Req.class);
        StringValidater.validateBlank(req.getId());
    }
}
