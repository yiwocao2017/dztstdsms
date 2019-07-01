package com.std.sms.api.impl;

import com.std.sms.ao.ISmsAO;
import com.std.sms.api.AProcessor;
import com.std.sms.common.JsonUtil;
import com.std.sms.domain.Sms;
import com.std.sms.dto.req.XN804041Req;
import com.std.sms.exception.BizException;
import com.std.sms.exception.ParaException;
import com.std.sms.spring.SpringContextHolder;

/**
 * 列表查询消息
 * @author: xieyj 
 * @since: 2016年11月26日 下午2:29:42 
 * @history:
 */
public class XN804041 extends AProcessor {
    private ISmsAO smsAO = SpringContextHolder.getBean(ISmsAO.class);

    private XN804041Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Sms condition = new Sms();
        condition.setFromSystemCode(req.getFromSystemCode());
        condition.setChannelType(req.getChannelType());
        condition.setPushType(req.getPushType());
        condition.setToSystemCode(req.getToSystemCode());
        condition.setToKind(req.getToKind());
        condition.setToMobile(req.getToMobile());
        condition.setSmsType(req.getSmsType());
        condition.setStatus(req.getStatus());
        return smsAO.querySmsList(condition);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN804041Req.class);
    }
}
