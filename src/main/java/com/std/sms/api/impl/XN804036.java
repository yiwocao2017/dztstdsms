package com.std.sms.api.impl;

import com.std.sms.ao.ISmsAO;
import com.std.sms.api.AProcessor;
import com.std.sms.common.JsonUtil;
import com.std.sms.core.StringValidater;
import com.std.sms.dto.req.XN804036Req;
import com.std.sms.dto.res.BooleanRes;
import com.std.sms.exception.BizException;
import com.std.sms.exception.ParaException;
import com.std.sms.spring.SpringContextHolder;

/** 
 * 公告发布/下撤
 * @author: xieyj 
 * @since: 2016年11月21日 下午5:42:18 
 * @history:
 */
public class XN804036 extends AProcessor {

    private ISmsAO smsAO = SpringContextHolder.getBean(ISmsAO.class);

    private XN804036Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Long id = StringValidater.toLong(req.getId());
        smsAO.toSendNoticeSms(id, req.getUpdater());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN804036Req.class);
        StringValidater.validateBlank(req.getId(), req.getUpdater());
    }
}
