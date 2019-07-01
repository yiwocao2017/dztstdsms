package com.std.sms.ao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.std.sms.ao.IPoolAO;
import com.std.sms.bo.ICompanyBO;
import com.std.sms.bo.IPoolBO;
import com.std.sms.bo.ISOutBO;
import com.std.sms.common.DateUtil;
import com.std.sms.domain.Company;
import com.std.sms.domain.Pool;
import com.std.sms.sent.Senter;

@Service
public class PoolAOImpl implements IPoolAO {

    @Autowired
    private IPoolBO poolBO;

    @Autowired
    private ISOutBO sOutBO;

    @Autowired
    Senter senter;

    @Autowired
    ICompanyBO companyBO;

    @Override
    public String doSaveSOutToPool(String channel, String mobile,
            String content, String sendDatetime) {
        return poolBO.savePool(channel, mobile, content, sendDatetime);
    }

    @Override
    public void doRemoveSOutFromPool(String code) {
        poolBO.removePool(code);
    }

    @Override
    public List<Pool> queryPoolList(String code) {
        Pool data = new Pool();
        data.setCode(code);
        return poolBO.queryPoolList(data);
    }

    @Override
    public void doSendFromPool() {
        List<Pool> list = queryPoolList("");
        if (list != null) {
            for (Pool p : list) {
                String today = DateUtil.getToday(DateUtil.DATA_TIME_PATTERN_2);
                Date now = DateUtil.strToDate(today,
                    DateUtil.DATA_TIME_PATTERN_2);
                Date toSendDatetime = p.getToSendDatetime();
                if (toSendDatetime != null) {
                    if (now.after(toSendDatetime) || now.equals(toSendDatetime)) {
                        String[] str = p.getChannel().split("-");
                        String prefixContent = changeContent(str[0],
                            p.getContent());
                        senter.send(str[0], p.getChannel(), p.getMobile(),
                            prefixContent);
                        sOutBO.saveSOut(p.getChannel(), p.getMobile(),
                            prefixContent);
                        doRemoveSOutFromPool(p.getCode());
                    }
                }
            }
        }
    }

    public String changeContent(String companyCode, String content) {
        Company data = companyBO.queryCompany(companyCode);
        String result = "【" + data.getPrefix() + "】" + content;
        return result;
    }

}
