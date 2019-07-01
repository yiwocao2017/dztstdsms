package com.std.sms.bo.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.std.sms.bo.IPoolBO;
import com.std.sms.bo.base.PaginableBOImpl;
import com.std.sms.common.DateUtil;
import com.std.sms.core.OrderNoGenerater;
import com.std.sms.dao.IPoolDAO;
import com.std.sms.domain.Pool;

@Component
public class PoolBOImpl extends PaginableBOImpl<Pool> implements IPoolBO {

    @Autowired
    private IPoolDAO poolDAO;

    @Override
    public String savePool(String channel, String mobile, String content,
            String sendDatetime) {
        Pool data = new Pool();
        String[] str = channel.split("-");
        data.setCompanyCode(str[0]);
        data.setCode(OrderNoGenerater.generateM("PO"));
        data.setMobile(mobile);
        data.setContent(content);
        data.setChannel(channel);
        Date toSendDatetime = DateUtil.strToDate(sendDatetime,
            DateUtil.DATA_TIME_PATTERN_2);
        data.setToSendDatetime(toSendDatetime);
        poolDAO.insert(data);
        return data.getCode();
    }

    /** 
     * @see com.std.sms.bo.IPoolBO#savePool(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public String savePool(String channel, String mobile, String content,
            String sendDatetime, String companyCode, String systemCode) {
        Pool data = new Pool();
        data.setCompanyCode(companyCode);
        data.setCode(OrderNoGenerater.generateM("PO"));
        data.setMobile(mobile);
        data.setContent(content);
        data.setChannel(channel);
        Date toSendDatetime = DateUtil.strToDate(sendDatetime,
            DateUtil.DATA_TIME_PATTERN_2);
        data.setToSendDatetime(toSendDatetime);
        poolDAO.insert(data);
        return data.getCode();
    }

    @Override
    public int removePool(String code) {
        int count = 0;
        if (code != null && code != "") {
            Pool data = new Pool();
            data.setCode(code);
            count = poolDAO.delete(data);
        }
        return count;
    }

    @Override
    public List<Pool> queryPoolList(Pool data) {
        return poolDAO.selectList(data);
    }
}
