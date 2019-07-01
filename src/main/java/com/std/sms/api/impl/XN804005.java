package com.std.sms.api.impl;

import org.apache.commons.lang.StringUtils;

import com.std.sms.ao.ISystemChannelAO;
import com.std.sms.api.AProcessor;
import com.std.sms.common.JsonUtil;
import com.std.sms.core.StringValidater;
import com.std.sms.domain.SystemChannel;
import com.std.sms.dto.req.XN804005Req;
import com.std.sms.exception.BizException;
import com.std.sms.exception.ParaException;
import com.std.sms.spring.SpringContextHolder;

/**
 * 分页查询系统渠道
 * @author: xieyj 
 * @since: 2016年11月26日 上午11:08:13 
 * @history:
 */
public class XN804005 extends AProcessor {
    private ISystemChannelAO systemChannelAO = SpringContextHolder
        .getBean(ISystemChannelAO.class);

    private XN804005Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        SystemChannel condition = new SystemChannel();
        condition.setSystemCode(req.getSystemCode());
        condition.setChannelType(req.getChannelType());
        condition.setPushType(req.getPushType());
        condition.setStatus(req.getStatus());
        String column = req.getOrderColumn();
        if (StringUtils.isBlank(column)) {
            column = ISystemChannelAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(column, req.getOrderDir());
        int start = Integer.valueOf(req.getStart());
        int limit = Integer.valueOf(req.getLimit());
        return systemChannelAO.querySystemChannelPage(start, limit, condition);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN804005Req.class);
        StringValidater.validateNumber(req.getStart(), req.getLimit());
    }
}
