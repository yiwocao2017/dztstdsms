package com.std.sms.api.impl;

import com.std.sms.ao.ISystemTemplateAO;
import com.std.sms.api.AProcessor;
import com.std.sms.common.JsonUtil;
import com.std.sms.domain.SystemTemplate;
import com.std.sms.dto.req.XN804062Req;
import com.std.sms.exception.BizException;
import com.std.sms.exception.ParaException;
import com.std.sms.spring.SpringContextHolder;

/**
 * 列表查询模板
 * @author: xieyj 
 * @since: 2016年11月28日 下午4:16:38 
 * @history:
 */
public class XN804062 extends AProcessor {
    private ISystemTemplateAO systemTemplateAO = SpringContextHolder
        .getBean(ISystemTemplateAO.class);

    private XN804062Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        SystemTemplate condition = new SystemTemplate();
        condition.setSystemCode(req.getSystemCode());
        condition.setChannelType(req.getChannelType());
        condition.setPushType(req.getPushType());
        return systemTemplateAO.querySystemTemplateList(condition);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN804062Req.class);
    }
}
