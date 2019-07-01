package com.std.sms.api.impl;

import com.std.sms.ao.ITemplateAO;
import com.std.sms.api.AProcessor;
import com.std.sms.common.JsonUtil;
import com.std.sms.core.StringValidater;
import com.std.sms.dto.req.XN804060Req;
import com.std.sms.exception.BizException;
import com.std.sms.exception.ParaException;
import com.std.sms.spring.SpringContextHolder;

/**
 * 获取指定微信模板
 * @author: xieyj 
 * @since: 2016年11月28日 下午4:16:38 
 * @history:
 */
public class XN804060 extends AProcessor {
    private ITemplateAO templateAO = SpringContextHolder
        .getBean(ITemplateAO.class);

    private XN804060Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return templateAO.getTemplate(req.getSystemCode());
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN804060Req.class);
        StringValidater.validateBlank(req.getSystemCode());
    }
}
