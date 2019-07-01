package com.std.sms.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.std.sms.ao.ISCaptchaAO;
import com.std.sms.api.AProcessor;
import com.std.sms.common.JsonUtil;
import com.std.sms.dto.req.XN804082Req;
import com.std.sms.dto.res.BooleanRes;
import com.std.sms.exception.BizException;
import com.std.sms.exception.ParaException;
import com.std.sms.spring.SpringContextHolder;
import com.std.sms.util.PhoneUtil;

/**
 * 指定系统验证码验证
 * @author: xieyj 
 * @since: 2017年2月2日 上午10:24:30 
 * @history:
 */
public class XN804082 extends AProcessor {

    private ISCaptchaAO sCaptchaAO = SpringContextHolder
        .getBean(ISCaptchaAO.class);

    private XN804082Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        boolean flag = sCaptchaAO.doCheckByCM(req.getSystemCode(),
            req.getCompanyCode(), req.getMobile(), req.getCaptcha(),
            req.getBizType());
        return new BooleanRes(flag);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN804082Req.class);
        if (StringUtils.isBlank(req.getSystemCode())) {
            throw new ParaException("xn804080", "系统编号不能为空");
        }
        if (!PhoneUtil.isMobile(req.getMobile())) {
            throw new ParaException("xn804080", "手机号非法");
        }
    }
}
