package com.std.sms.api.impl;

import com.std.sms.ao.ISystemTemplateAO;
import com.std.sms.api.AProcessor;
import com.std.sms.common.JsonUtil;
import com.std.sms.core.StringValidater;
import com.std.sms.dto.req.XN804063Req;
import com.std.sms.exception.BizException;
import com.std.sms.exception.ParaException;
import com.std.sms.spring.SpringContextHolder;

/**
 * 详情查询模板
 * @author: xieyj 
 * @since: 2016年11月28日 下午4:16:38 
 * @history:
 */
public class XN804063 extends AProcessor {
    private ISystemTemplateAO systemTemplateAO = SpringContextHolder
        .getBean(ISystemTemplateAO.class);

    private XN804063Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Long id = StringValidater.toLong(req.getId());
        return systemTemplateAO.getSystemTemplate(id);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN804063Req.class);
        StringValidater.validateBlank(req.getId());
    }
}
