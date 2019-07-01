package com.std.sms.api.impl;

import com.std.sms.ao.IItemsAO;
import com.std.sms.api.AProcessor;
import com.std.sms.common.JsonUtil;
import com.std.sms.core.StringValidater;
import com.std.sms.domain.Items;
import com.std.sms.dto.req.XN804050Req;
import com.std.sms.dto.res.PKCodeRes;
import com.std.sms.exception.BizException;
import com.std.sms.exception.ParaException;
import com.std.sms.spring.SpringContextHolder;

/**
 * 新增办件
 * @author: xieyj 
 * @since: 2016年11月29日 下午7:42:08 
 * @history:
 */
public class XN804050 extends AProcessor {
    private IItemsAO itemsAO = SpringContextHolder.getBean(IItemsAO.class);

    private XN804050Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Items data = new Items();
        data.setLoginName(req.getLoginName());
        data.setRealName(req.getRealName());
        data.setFirst(req.getFirst());
        data.setDepartment(req.getDepartment());
        data.setContent(req.getContent());
        data.setTelephone(req.getTelephone());
        data.setRemark(req.getRemark());
        data.setSystemCode(req.getSystemCode());
        data.setUpdater(req.getUpdater());
        return new PKCodeRes(itemsAO.addItems(data));
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN804050Req.class);
        StringValidater.validateBlank(req.getLoginName(), req.getRealName(),
            req.getFirst(), req.getDepartment(), req.getContent(),
            req.getTelephone(), req.getRemark(), req.getSystemCode(),
            req.getUpdater());
    }
}
