package com.std.sms.bo.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.std.sms.bo.IConfigureBO;
import com.std.sms.bo.base.PaginableBOImpl;
import com.std.sms.dao.IConfigureDAO;
import com.std.sms.domain.Configure;
import com.std.sms.exception.BizException;

@Component
public class ConfigureBOImpl extends PaginableBOImpl<Configure> implements
        IConfigureBO {

    @Autowired
    private IConfigureDAO configureDAO;

    @Override
    public Configure doGetConfigure(String companyCode, String channel,
            String key) {
        Configure data = new Configure();
        data.setCompanyCode(companyCode);
        data.setChannel(channel);
        data.setKey(key);
        return configureDAO.select(data);
    }

    @Override
    public List<Configure> queryConfigureList(Configure condition) {
        return configureDAO.selectList(condition);
    }

    @Override
    public String getConfigureChannel(String systemCode) {
        String channel = "";
        Configure condition = new Configure();
        condition.setCompanyCode(systemCode);
        List<Configure> list = configureDAO.selectList(condition);
        if (CollectionUtils.isNotEmpty(list)) {
            channel = list.get(0).getChannel();
        } else {
            throw new BizException("xn000000", "系统渠道未配置");
        }
        return channel;
    }
}
