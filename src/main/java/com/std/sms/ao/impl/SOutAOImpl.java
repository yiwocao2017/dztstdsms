package com.std.sms.ao.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.std.sms.ao.ISOutAO;
import com.std.sms.bo.ICompanyBO;
import com.std.sms.bo.IConfigureBO;
import com.std.sms.bo.IPoolBO;
import com.std.sms.bo.ISOutBO;
import com.std.sms.bo.base.Paginable;
import com.std.sms.domain.Company;
import com.std.sms.domain.SOut;
import com.std.sms.sent.Senter;
import com.std.sms.sent.SystemCodeSenter;

@Service
public class SOutAOImpl implements ISOutAO {

    @Autowired
    ICompanyBO companyBO;

    @Autowired
    IConfigureBO configureBO;

    @Autowired
    Senter senter;

    @Autowired
    SystemCodeSenter systemCodeSenter;

    @Autowired
    ISOutBO sOutBO;

    @Autowired
    IPoolBO poolBO;

    @Override
    public String doSend(String channel, String mobile, String content,
            String sendDatetime) {
        String[] str = channel.split("-");
        String code = null;
        if (str[2].equalsIgnoreCase("K") || str[2].equalsIgnoreCase("M")) {
            String prefixContent = changeContent(str[0], content);
            senter.send(str[0], channel, mobile, prefixContent);
            code = sOutBO.saveSOut(channel, mobile, prefixContent);
        } else {
            code = poolBO.savePool(channel, mobile, content, sendDatetime);
        }
        return code;
    }

    @Override
    public String doSendBySystemCode(String type, String mobile,
            String content, String sendDatetime, String companyCode,
            String systemCode) {
        String code = null;
        String channel = configureBO.getConfigureChannel(systemCode);
        if (type.equalsIgnoreCase("K") || type.equalsIgnoreCase("M")) {
            String prefixContent = changeContent(systemCode, content);
            systemCodeSenter.send(systemCode, type, channel, mobile,
                prefixContent);
            code = sOutBO.saveSOut(channel, mobile, prefixContent, companyCode,
                systemCode);
        } else {
            code = poolBO.savePool(channel, mobile, content, sendDatetime,
                systemCode, systemCode);
        }
        return code;
    }

    @Override
    public String doSaveSOut(String channel, String mobile, String content) {
        String[] str = channel.split("-");
        String prefixContent = changeContent(str[0], content);
        return sOutBO.saveSOut(channel, mobile, prefixContent);
    }

    public String changeContent(String companyCode, String content) {
        Company data = companyBO.queryCompany(companyCode);
        String result = content;
        if (StringUtils.isNotBlank(data.getPrefix())) {
            result = result + "【" + data.getPrefix() + "】";
        }
        return result;
    }

    @Override
    public Paginable<SOut> querySOutPage(int start, int limit, SOut condition) {
        return sOutBO.getPaginable(start, limit, condition);
    }
}
