package com.std.sms.api.impl;

import com.std.sms.ao.IItemsAO;
import com.std.sms.api.AProcessor;
import com.std.sms.common.JsonUtil;
import com.std.sms.core.StringValidater;
import com.std.sms.domain.Items;
import com.std.sms.dto.req.XN804052Req;
import com.std.sms.dto.res.BooleanRes;
import com.std.sms.exception.BizException;
import com.std.sms.exception.ParaException;
import com.std.sms.spring.SpringContextHolder;

/**
 * 修改办件
 * @author: xieyj 
 * @since: 2016年11月29日 下午7:42:08 
 * @history:
 */
public class XN804052 extends AProcessor {
    private IItemsAO itemsAO = SpringContextHolder.getBean(IItemsAO.class);

    private XN804052Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Items data = new Items();
        data.setCode(req.getCode());
        data.setRealName(req.getRealName());
        data.setFirst(req.getFirst());
        data.setDepartment(req.getDepartment());
        data.setContent(req.getContent());
        data.setTelephone(req.getTelephone());
        data.setRemark(req.getRemark());
        data.setSystemCode(req.getSystemCode());
        itemsAO.editItems(data);
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN804052Req.class);
        StringValidater.validateBlank(req.getCode(), req.getRealName(),
            req.getFirst(), req.getDepartment(), req.getContent(),
            req.getTelephone(), req.getRemark(), req.getSystemCode());
    }
}
