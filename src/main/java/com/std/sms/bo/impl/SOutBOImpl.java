package com.std.sms.bo.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.std.sms.bo.ISOutBO;
import com.std.sms.bo.base.PaginableBOImpl;
import com.std.sms.core.OrderNoGenerater;
import com.std.sms.dao.ISOutDAO;
import com.std.sms.domain.SOut;
import com.std.sms.enums.ESmsStatus;

@Component
public class SOutBOImpl extends PaginableBOImpl<SOut> implements ISOutBO {

    @Autowired
    private ISOutDAO sOutDAO;

    @Override
    public String saveSOut(String channel, String mobile, String content) {
        SOut data = new SOut();
        String[] str = channel.split("-");
        data.setCode(OrderNoGenerater.generateM("SO"));
        data.setCompanyCode(str[0]);
        data.setMobile(mobile);
        data.setContent(content);
        data.setChannel(channel);
        Date now = new Date();
        data.setSendDatetime(now);
        data.setErrorCode(ESmsStatus.SENT_YES.getCode());
        data.setErrorInfo(ESmsStatus.SENT_YES.getValue());
        sOutDAO.insert(data);
        return data.getCode();
    }

    @Override
    public String saveSOut(String channel, String mobile, String content,
            String companyCode, String systemCode) {
        SOut data = new SOut();
        data.setCode(OrderNoGenerater.generateM("SO"));
        data.setSystemCode(systemCode);
        data.setMobile(mobile);
        data.setContent(content);
        data.setChannel(channel);
        Date now = new Date();
        data.setSendDatetime(now);
        data.setErrorCode(ESmsStatus.SENT_YES.getCode());
        data.setErrorInfo(ESmsStatus.SENT_YES.getValue());
        data.setCompanyCode(companyCode);
        data.setSystemCode(systemCode);
        sOutDAO.insert(data);
        return data.getCode();
    }

    @Override
    public List<SOut> querySOutList(SOut data) {
        return sOutDAO.selectList(data);
    }

}
