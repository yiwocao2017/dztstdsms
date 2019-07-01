package com.std.sms.api.impl;

import com.std.sms.ao.ISystemTemplateAO;
import com.std.sms.api.AProcessor;
import com.std.sms.common.JsonUtil;
import com.std.sms.core.StringValidater;
import com.std.sms.domain.SystemTemplate;
import com.std.sms.dto.req.XN804065Req;
import com.std.sms.dto.res.BooleanRes;
import com.std.sms.exception.BizException;
import com.std.sms.exception.ParaException;
import com.std.sms.spring.SpringContextHolder;

/**
 * 新增模板
 * @author: xieyj 
 * @since: 2016年12月8日 上午11:26:54 
 * @history:
 */
public class XN804065 extends AProcessor {
    private ISystemTemplateAO systemTemplateAO = SpringContextHolder
        .getBean(ISystemTemplateAO.class);

    private XN804065Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        SystemTemplate data = new SystemTemplate();
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
        systemTemplateAO.addSystemTemplate(data);
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN804065Req.class);
        StringValidater.validateBlank(req.getSystemCode(),
            req.getChannelType(), req.getPushType(), req.getTemplateId(),
            req.getTitle(), req.getContent());
    }
}
