package com.std.sms.api.impl;

import com.std.sms.ao.ISystemTemplateAO;
import com.std.sms.api.AProcessor;
import com.std.sms.common.JsonUtil;
import com.std.sms.core.StringValidater;
import com.std.sms.domain.SystemTemplate;
import com.std.sms.dto.req.XN804067Req;
import com.std.sms.dto.res.BooleanRes;
import com.std.sms.exception.BizException;
import com.std.sms.exception.ParaException;
import com.std.sms.spring.SpringContextHolder;

/**
 * 修改模板
 * @author: xieyj 
 * @since: 2016年12月8日 下午1:26:49 
 * @history:
 */
public class XN804067 extends AProcessor {
    private ISystemTemplateAO systemTemplateAO = SpringContextHolder
        .getBean(ISystemTemplateAO.class);

    private XN804067Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        SystemTemplate data = new SystemTemplate();
        data.setId(StringValidater.toLong(req.getId()));
        data.setSystemCode(req.getSystemCode());
        data.setChannelType(req.getChannelType());
        data.setPushType(req.getPushType());
        data.setTemplateId(req.getTemplateId());
        data.setTitle(req.getTitle());
        data.setUrl(req.getUrl());
        data.setKey1(req.getKey1());
        data.setKey2(req.getKey2());
        data.setKey3(req.getKey3());
        data.setContent(req.getContent());
        data.setRemark(req.getRemark());
        systemTemplateAO.editSystemTemplate(data);
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN804067Req.class);
        StringValidater.validateBlank(req.getId(), req.getSystemCode(),
            req.getChannelType(), req.getPushType(), req.getTemplateId(),
            req.getTitle(), req.getContent());
    }
}
