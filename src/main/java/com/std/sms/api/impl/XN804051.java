package com.std.sms.api.impl;

import com.std.sms.ao.IItemsAO;
import com.std.sms.api.AProcessor;
import com.std.sms.common.JsonUtil;
import com.std.sms.core.StringValidater;
import com.std.sms.dto.req.XN804051Req;
import com.std.sms.dto.res.BooleanRes;
import com.std.sms.exception.BizException;
import com.std.sms.exception.ParaException;
import com.std.sms.spring.SpringContextHolder;

/**
 * 删除办件人员
 * @author: xieyj 
 * @since: 2016年11月28日 下午4:16:38 
 * @history:
 */
public class XN804051 extends AProcessor {
    private IItemsAO itemsAO = SpringContextHolder.getBean(IItemsAO.class);

    private XN804051Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        itemsAO.dropItems(req.getCode(), req.getUpdater());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN804051Req.class);
        StringValidater.validateBlank(req.getCode(), req.getUpdater());
    }
}
