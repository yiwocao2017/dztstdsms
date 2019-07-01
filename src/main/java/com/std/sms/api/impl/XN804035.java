package com.std.sms.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.std.sms.ao.ISmsAO;
import com.std.sms.api.AProcessor;
import com.std.sms.common.DateUtil;
import com.std.sms.common.JsonUtil;
import com.std.sms.core.StringValidater;
import com.std.sms.domain.Sms;
import com.std.sms.dto.req.XN804035Req;
import com.std.sms.dto.res.BooleanRes;
import com.std.sms.enums.ESmsType;
import com.std.sms.exception.BizException;
import com.std.sms.exception.ParaException;
import com.std.sms.spring.SpringContextHolder;

/** 
 * 公告修改
 * @author: xieyj 
 * @since: 2016年11月21日 下午5:42:18 
 * @history:
 */
public class XN804035 extends AProcessor {

    private ISmsAO smsAO = SpringContextHolder.getBean(ISmsAO.class);

    private XN804035Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Sms data = new Sms();
        data.setId(StringValidater.toLong(req.getId()));
        data.setSmsType(req.getSmsType());
        data.setToKind(req.getToKind());
        data.setSmsTitle(req.getSmsTitle());
        data.setSmsContent(req.getSmsContent());
        data.setTopushDatetime(DateUtil.getFrontDate(req.getTopushDatetime(),
            false));
        data.setUpdater(req.getUpdater());
        data.setRemark(req.getRemark());
        smsAO.editNoticeSms(data);
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN804035Req.class);
        StringValidater.validateBlank(req.getId(), req.getSmsType(),
            req.getSmsTitle(), req.getSmsContent(), req.getUpdater());
        if (ESmsType.WAIT_SEND.getCode().equals(req.getSmsType())
                && StringUtils.isBlank(req.getTopushDatetime())) {
            throw new BizException("xn702000", "拟发送时间不能为空");
        }
    }
}
