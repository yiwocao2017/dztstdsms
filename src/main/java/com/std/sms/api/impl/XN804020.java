package com.std.sms.api.impl;

import org.apache.commons.lang.StringUtils;

import com.std.sms.ao.IReceiverAO;
import com.std.sms.api.AProcessor;
import com.std.sms.common.JsonUtil;
import com.std.sms.core.StringValidater;
import com.std.sms.domain.Receiver;
import com.std.sms.dto.req.XN804020Req;
import com.std.sms.exception.BizException;
import com.std.sms.exception.ParaException;
import com.std.sms.spring.SpringContextHolder;

/**
 * 分页查询接收者
 * @author: xieyj 
 * @since: 2016年11月26日 下午2:29:42 
 * @history:
 */
public class XN804020 extends AProcessor {
    private IReceiverAO receiverAO = SpringContextHolder
        .getBean(IReceiverAO.class);

    private XN804020Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Receiver condition = new Receiver();
        condition.setMobile(req.getMobile());
        condition.setSystemCode(req.getSystemCode());
        condition.setName(req.getName());
        condition.setLevel(req.getLevel());
        String column = req.getOrderColumn();
        if (StringUtils.isBlank(column)) {
            column = IReceiverAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(column, req.getOrderDir());
        int start = Integer.valueOf(req.getStart());
        int limit = Integer.valueOf(req.getLimit());
        return receiverAO.queryReceiverPage(start, limit, condition);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN804020Req.class);
        StringValidater.validateNumber(req.getStart(), req.getLimit());
    }
}
