package com.std.sms.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.std.sms.ao.ISmsAO;
import com.std.sms.api.AProcessor;
import com.std.sms.common.DateUtil;
import com.std.sms.common.JsonUtil;
import com.std.sms.core.StringValidater;
import com.std.sms.domain.Sms;
import com.std.sms.dto.req.XN804033Req;
import com.std.sms.dto.res.BooleanRes;
import com.std.sms.enums.EChannelType;
import com.std.sms.enums.EPushType;
import com.std.sms.enums.ESmsType;
import com.std.sms.exception.BizException;
import com.std.sms.exception.ParaException;
import com.std.sms.spring.SpringContextHolder;

/** 
 * 微信发送消息(内部单发，群发；外部单发)
 * @author: xieyj 
 * @since: 2016年11月21日 下午5:42:18 
 * @history:
 */
public class XN804033 extends AProcessor {
    private ISmsAO smsAO = SpringContextHolder.getBean(ISmsAO.class);

    private XN804033Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Sms data = new Sms();
        data.setFromSystemCode(req.getFromSystemCode());
        data.setChannelType(EChannelType.WECHAT.getCode());
        data.setPushType(EPushType.WEIXIN.getCode());
        data.setToSystemCode(req.getToSystemCode());
        data.setToMobile(req.getToMobile());
        data.setSmsType(req.getSmsType());
        data.setWxSmsContent(req.getSmsContent());
        data.setTemplateId(req.getTemplateId());
        data.setTopushDatetime(DateUtil.getFrontDate(req.getTopushDatetime(),
            false));
        data.setUpdater(req.getUpdater());
        data.setRemark(req.getRemark());
        smsAO.toSendWxSms(data);
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN804033Req.class);
        StringValidater.validateBlank(req.getFromSystemCode(),
            req.getToSystemCode(), req.getSmsType(), req.getUpdater());
        if (ESmsType.WAIT_SEND.getCode().equals(req.getSmsType())
                && StringUtils.isBlank(req.getTopushDatetime())) {
            throw new BizException("xn702000", "拟发送时间不能为空");
        }
        if (req.getSmsContent() == null) {
            throw new BizException("xn702000", "发送内容不能为空");
        }
    }
}
