package com.std.sms.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.std.sms.ao.ISCaptchaAO;
import com.std.sms.api.AProcessor;
import com.std.sms.common.JsonUtil;
import com.std.sms.dto.req.XN799002Req;
import com.std.sms.dto.res.XN799002Res;
import com.std.sms.exception.BizException;
import com.std.sms.exception.ParaException;
import com.std.sms.spring.SpringContextHolder;

/**
 * 验证短信验证码
 * @author: myb858 
 * @since: 2016年5月25日 下午12:33:30 
 * @history:
 */
public class XN799002 extends AProcessor {
    private ISCaptchaAO sCaptchaAO = SpringContextHolder
        .getBean(ISCaptchaAO.class);

    private XN799002Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        boolean flag = sCaptchaAO.doCheck(req.getCode(), req.getCaptcha());
        return new XN799002Res(flag);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN799002Req.class);
        if (StringUtils.isBlank(req.getCode())) {
            throw new ParaException("xn799002", "短信验证码编号不能为空");
        }
        if (StringUtils.isBlank(req.getCaptcha())) {
            throw new ParaException("xn799002", "短信验证码不能为空");
        }
        if (req.getCode().length() > 32) {
            throw new ParaException("xn799002", "请输入正确的短信验证码编号");
        }
    }

}
