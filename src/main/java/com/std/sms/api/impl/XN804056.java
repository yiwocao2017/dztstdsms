package com.std.sms.api.impl;

import com.std.sms.ao.IItemsAO;
import com.std.sms.api.AProcessor;
import com.std.sms.common.JsonUtil;
import com.std.sms.domain.Items;
import com.std.sms.dto.req.XN804056Req;
import com.std.sms.exception.BizException;
import com.std.sms.exception.ParaException;
import com.std.sms.spring.SpringContextHolder;

/**
 * 列表查询办件
 * @author: xieyj 
 * @since: 2016年11月26日 上午11:08:13 
 * @history:
 */
public class XN804056 extends AProcessor {
    private IItemsAO itemsAO = SpringContextHolder.getBean(IItemsAO.class);

    private XN804056Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Items condition = new Items();
        condition.setUserId(req.getUserId());
        condition.setRealName(req.getRealName());
        condition.setDepartment(req.getDepartment());
        condition.setSystemCode(req.getSystemCode());
        return itemsAO.queryItemsList(condition);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN804056Req.class);
    }
}
