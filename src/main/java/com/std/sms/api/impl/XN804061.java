package com.std.sms.api.impl;

import org.apache.commons.lang.StringUtils;

import com.std.sms.ao.ISystemTemplateAO;
import com.std.sms.api.AProcessor;
import com.std.sms.common.JsonUtil;
import com.std.sms.core.StringValidater;
import com.std.sms.domain.SystemTemplate;
import com.std.sms.dto.req.XN804061Req;
import com.std.sms.exception.BizException;
import com.std.sms.exception.ParaException;
import com.std.sms.spring.SpringContextHolder;

/**
 * 分页查询系统模板
 * @author: xieyj 
 * @since: 2016年11月28日 下午4:16:38 
 * @history:
 */
public class XN804061 extends AProcessor {
    private ISystemTemplateAO systemTemplateAO = SpringContextHolder
        .getBean(ISystemTemplateAO.class);

    private XN804061Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        SystemTemplate condition = new SystemTemplate();
        condition.setSystemCode(req.getSystemCode());
        condition.setChannelType(req.getChannelType());
        condition.setPushType(req.getPushType());
        String column = req.getOrderColumn();
        if (StringUtils.isBlank(column)) {
            column = ISystemTemplateAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(column, req.getOrderDir());
        int start = Integer.valueOf(req.getStart());
        int limit = Integer.valueOf(req.getLimit());
        return systemTemplateAO
            .querySystemTemplatePage(start, limit, condition);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN804061Req.class);
        StringValidater.validateNumber(req.getStart(), req.getLimit());
    }
}
