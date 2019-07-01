/**
 * @Title XN804030.java 
 * @Package com.std.sms.api.impl 
 * @Description 
 * @author xieyj  
 * @date 2016年11月21日 下午5:42:18 
 * @version V1.0   
 */
package com.std.sms.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.std.sms.ao.ISmsAO;
import com.std.sms.api.AProcessor;
import com.std.sms.common.DateUtil;
import com.std.sms.common.JsonUtil;
import com.std.sms.core.StringValidater;
import com.std.sms.domain.Sms;
import com.std.sms.dto.req.XN804030Req;
import com.std.sms.dto.res.BooleanRes;
import com.std.sms.enums.EChannelType;
import com.std.sms.enums.EPushType;
import com.std.sms.enums.ESmsType;
import com.std.sms.exception.BizException;
import com.std.sms.exception.ParaException;
import com.std.sms.spring.SpringContextHolder;

/** 
 * 发送消息
 * @author: xieyj 
 * @since: 2016年11月21日 下午5:42:18 
 * @history:
 */
public class XN804030 extends AProcessor {
    private ISmsAO smsAO = SpringContextHolder.getBean(ISmsAO.class);

    private XN804030Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Sms data = new Sms();
        data.setFromSystemCode(req.getFromSystemCode());
        data.setChannelType(req.getChannelType());
        data.setPushType(req.getPushType());
        data.setToSystemCode(req.getToSystemCode());
        data.setToMobile(req.getToMobile());
        data.setToKind(req.getToKind());
        data.setSmsType(req.getSmsType());
        data.setSmsTitle(req.getSmsTitle());
        data.setSmsContent(req.getSmsContent());
        if (EChannelType.WECHAT.getCode().equals(req.getChannelType())
                && EPushType.WEIXIN.getCode().equals(req.getPushType())) {
            data.setWxSmsContent(req.getWxContent());
            data.setTemplateId(req.getTemplateId());
        } else {
            data.setSmsContent(req.getSmsContent());
        }
        data.setTopushDatetime(DateUtil.getFrontDate(req.getTopushDatetime(),
            false));
        data.setUpdater(req.getUpdater());
        data.setRemark(req.getRemark());
        smsAO.toSendSms(data);
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN804030Req.class);
        StringValidater.validateBlank(req.getFromSystemCode(),
            req.getChannelType(), req.getPushType(), req.getToSystemCode(),
            req.getSmsType(), req.getUpdater());
        if (EChannelType.WECHAT.getCode().equals(req.getChannelType())
                && EPushType.WEIXIN.getCode().equals(req.getPushType())) {
            if (null == req.getWxContent()) {
                throw new BizException("xn702000", "微信内容不能为空");
            }
            if (StringUtils.isBlank(req.getTemplateId())) {
                throw new BizException("xn702000", "模板编号不能为空");
            }
        } else {
            StringValidater.validateBlank(req.getSmsContent());
        }
        if (ESmsType.WAIT_SEND.getCode().equals(req.getSmsType())
                && StringUtils.isBlank(req.getTopushDatetime())) {
            throw new BizException("xn702000", "拟发送时间不能为空");
        }
    }
}
