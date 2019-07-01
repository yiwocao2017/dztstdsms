package com.std.sms.api.impl;

import com.std.sms.ao.ISCaptchaAO;
import com.std.sms.api.AProcessor;
import com.std.sms.common.JsonUtil;
import com.std.sms.core.StringValidater;
import com.std.sms.dto.req.XN799007Req;
import com.std.sms.dto.res.BooleanRes;
import com.std.sms.exception.BizException;
import com.std.sms.exception.ParaException;
import com.std.sms.spring.SpringContextHolder;

/** 
 * 通过公司编号与手机号检查验证码是否正确
 * @author: zuixian 
 * @since: 2016年10月17日 下午4:12:32 
 * @history:
 */
public class XN799007 extends AProcessor {
    private ISCaptchaAO sCaptchaAO = SpringContextHolder
        .getBean(ISCaptchaAO.class);

    private XN799007Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        boolean flag = sCaptchaAO.doCheckByCM(req.getCompanyCode(),
            req.getMobile(), req.getCaptcha(), req.getBizType());
        return new BooleanRes(flag);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN799007Req.class);
        StringValidater.validateBlank(req.getCompanyCode(), req.getMobile(),
            req.getCaptcha(), req.getBizType());
    }

}
