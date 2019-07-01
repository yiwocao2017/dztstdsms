package com.std.sms.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.std.sms.ao.ISOutAO;
import com.std.sms.api.AProcessor;
import com.std.sms.common.JsonUtil;
import com.std.sms.dto.req.XN804080Req;
import com.std.sms.dto.res.PKCodeRes;
import com.std.sms.exception.BizException;
import com.std.sms.exception.ParaException;
import com.std.sms.spring.SpringContextHolder;
import com.std.sms.util.PhoneUtil;

/**
 * 指定系统发送短信信息
 * @author: xieyj 
 * @since: 2017年2月2日 上午10:24:30 
 * @history:
 */
public class XN804080 extends AProcessor {

    private ISOutAO sOutAO = SpringContextHolder.getBean(ISOutAO.class);

    private XN804080Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        String code = sOutAO.doSendBySystemCode(req.getType(), req.getMobile(),
            req.getContent(), req.getSendDatetime(), req.getCompanyCode(),
            req.getSystemCode());
        return new PKCodeRes(code);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN804080Req.class);
        if (StringUtils.isBlank(req.getSystemCode())) {
            throw new ParaException("xn804080", "系统编号不能为空");
        }
        if (!PhoneUtil.isMobile(req.getMobile())) {
            throw new ParaException("xn804080", "手机号非法");
        }
        if (StringUtils.isBlank(req.getContent())) {
            throw new ParaException("xn804080", "内容不能为空");
        }
    }
}
