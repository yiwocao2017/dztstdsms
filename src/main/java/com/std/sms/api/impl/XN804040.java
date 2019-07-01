package com.std.sms.api.impl;

import org.apache.commons.lang.StringUtils;

import com.std.sms.ao.ISmsAO;
import com.std.sms.api.AProcessor;
import com.std.sms.common.JsonUtil;
import com.std.sms.core.StringValidater;
import com.std.sms.domain.Sms;
import com.std.sms.dto.req.XN804040Req;
import com.std.sms.exception.BizException;
import com.std.sms.exception.ParaException;
import com.std.sms.spring.SpringContextHolder;

/**
 * 分页查询消息
 * @author: xieyj 
 * @since: 2016年11月26日 下午2:29:42 
 * @history:
 */
public class XN804040 extends AProcessor {
    private ISmsAO smsAO = SpringContextHolder.getBean(ISmsAO.class);

    private XN804040Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Sms condition = new Sms();
        condition.setFromSystemCode(req.getFromSystemCode());
        condition.setChannelType(req.getChannelType());
        condition.setPushType(req.getPushType());
        condition.setToSystemCode(req.getToSystemCode());
        condition.setToKind(req.getToKind());
        condition.setToMobile(req.getToMobile());

        condition.setName(req.getName());
        condition.setSmsType(req.getSmsType());
        condition.setSmsTitle(req.getSmsTitle());
        condition.setStatus(req.getStatus());
        String column = req.getOrderColumn();
        if (StringUtils.isBlank(column)) {
            column = ISmsAO.DEFAULT_ORDER_COLUMN;
        }

        condition.setOrder(column, req.getOrderDir());
        int start = Integer.valueOf(req.getStart());
        int limit = Integer.valueOf(req.getLimit());
        return smsAO.querySmsPage(start, limit, condition);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN804040Req.class);
        StringValidater.validateNumber(req.getStart(), req.getLimit());
    }
}
