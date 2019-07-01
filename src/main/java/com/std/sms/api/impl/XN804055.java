package com.std.sms.api.impl;

import org.apache.commons.lang.StringUtils;

import com.std.sms.ao.IItemsAO;
import com.std.sms.api.AProcessor;
import com.std.sms.common.JsonUtil;
import com.std.sms.core.StringValidater;
import com.std.sms.domain.Items;
import com.std.sms.dto.req.XN804055Req;
import com.std.sms.exception.BizException;
import com.std.sms.exception.ParaException;
import com.std.sms.spring.SpringContextHolder;

/**
 * 分页查询办件
 * @author: xieyj 
 * @since: 2016年11月26日 上午11:08:13 
 * @history:
 */
public class XN804055 extends AProcessor {
    private IItemsAO itemsAO = SpringContextHolder.getBean(IItemsAO.class);

    private XN804055Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Items condition = new Items();
        condition.setRealName(req.getRealName());
        condition.setDepartment(req.getDepartment());
        condition.setSystemCode(req.getSystemCode());
        condition.setUserId(req.getUserId());
        String column = req.getOrderColumn();
        if (StringUtils.isBlank(column)) {
            column = IItemsAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(column, req.getOrderDir());
        int start = Integer.valueOf(req.getStart());
        int limit = Integer.valueOf(req.getLimit());
        return itemsAO.queryItemsPage(start, limit, condition);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN804055Req.class);
        StringValidater.validateNumber(req.getStart(), req.getLimit());
    }
}
