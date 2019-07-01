package com.std.sms.api.impl;

import org.apache.commons.collections.CollectionUtils;

import com.std.sms.ao.IReceiverAO;
import com.std.sms.api.AProcessor;
import com.std.sms.common.JsonUtil;
import com.std.sms.core.StringValidater;
import com.std.sms.dto.req.XN804011Req;
import com.std.sms.dto.res.BooleanRes;
import com.std.sms.exception.BizException;
import com.std.sms.exception.ParaException;
import com.std.sms.spring.SpringContextHolder;

/**
 * 导入接收者
 * @author: xieyj 
 * @since: 2016年11月26日 下午2:29:42 
 * @history:
 */
public class XN804011 extends AProcessor {
    private IReceiverAO receiverAO = SpringContextHolder
        .getBean(IReceiverAO.class);

    private XN804011Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        receiverAO.importReceivers(req.getSystemCode(), req.getReceiverList());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN804011Req.class);
        StringValidater.validateBlank(req.getSystemCode());
        if (CollectionUtils.isEmpty(req.getReceiverList())) {
            throw new BizException("xn702000", "导入用户列表不能为空");
        }
    }
}
