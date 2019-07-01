package com.std.sms.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.std.sms.ao.ISCaptchaAO;
import com.std.sms.api.AProcessor;
import com.std.sms.common.JsonUtil;
import com.std.sms.dto.req.XN799003Req;
import com.std.sms.dto.res.XN799003Res;
import com.std.sms.exception.BizException;
import com.std.sms.exception.ParaException;
import com.std.sms.spring.SpringContextHolder;
import com.std.sms.util.ChannelUtil;
import com.std.sms.util.PhoneUtil;

/**
 * 发送短信验证码
 * @author: myb858 
 * @since: 2016年1月14日 下午4:07:08 
 * @history:
 */
public class XN799003 extends AProcessor {

    private ISCaptchaAO sCaptchaAO = SpringContextHolder
        .getBean(ISCaptchaAO.class);

    private XN799003Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        String channel = req.getChannel();
        String mobile = req.getMobile();
        String bizType = req.getBizType();
        String code = sCaptchaAO.doSend(channel, mobile, bizType);
        return new XN799003Res(code);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN799003Req.class);
        if (!PhoneUtil.isMobile(req.getMobile())) {
            throw new ParaException("xn799003", "手机号非法");
        }
        if (StringUtils.isBlank(req.getChannel())) {
            throw new ParaException("xn799003", "通道不能为空");
        }
        if (StringUtils.isBlank(req.getBizType())) {
            throw new ParaException("xn799003", "业务类型不能为空");
        }
        if (!ChannelUtil.isChannel(req.getChannel())) {
            throw new ParaException("xn799001", "通道非法");
        }
    }
}
