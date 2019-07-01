package com.std.sms.api.impl;

import com.std.sms.ao.IItemsAO;
import com.std.sms.api.AProcessor;
import com.std.sms.common.JsonUtil;
import com.std.sms.core.StringValidater;
import com.std.sms.dto.req.XN804057Req;
import com.std.sms.exception.BizException;
import com.std.sms.exception.ParaException;
import com.std.sms.spring.SpringContextHolder;

/**
 * 详情查询办件
 * @author: xieyj 
 * @since: 2016年11月26日 上午11:08:13 
 * @history:
 */
public class XN804057 extends AProcessor {
    private IItemsAO itemsAO = SpringContextHolder.getBean(IItemsAO.class);

    private XN804057Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return itemsAO.getItems(req.getCode());
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN804057Req.class);
        StringValidater.validateBlank(req.getCode());
    }
}
