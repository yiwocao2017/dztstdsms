package com.std.sms.api.impl;

import com.std.sms.ao.ISystemTemplateAO;
import com.std.sms.api.AProcessor;
import com.std.sms.common.JsonUtil;
import com.std.sms.core.StringValidater;
import com.std.sms.dto.req.XN804066Req;
import com.std.sms.dto.res.BooleanRes;
import com.std.sms.exception.BizException;
import com.std.sms.exception.ParaException;
import com.std.sms.spring.SpringContextHolder;

/**
 * 删除模板
 * @author: xieyj 
 * @since: 2016年12月8日 下午1:25:08 
 * @history:
 */
public class XN804066 extends AProcessor {
    private ISystemTemplateAO systemTemplateAO = SpringContextHolder
        .getBean(ISystemTemplateAO.class);

    private XN804066Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Long id = StringValidater.toLong(req.getId());
        systemTemplateAO.dropSystemTemplate(id);
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN804066Req.class);
        StringValidater.validateBlank(req.getId());
    }
}
