package com.std.sms.ao.impl;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.std.sms.ao.IDayReportAO;
import com.std.sms.bo.IDayReportBO;
import com.std.sms.bo.ISOutBO;
import com.std.sms.bo.base.Paginable;
import com.std.sms.common.DateUtil;
import com.std.sms.domain.DayReport;
import com.std.sms.domain.SOut;

@Service
public class DayReportAOImpl implements IDayReportAO {

    @Autowired
    private ISOutBO sOutBO;

    @Autowired
    private IDayReportBO dayReportBO;

    @Override
    public void doSaveDayReport() {
        SOut sData = new SOut();
        Set<String> channels = new HashSet<String>();
        Set<String> companys = new HashSet<String>();
        Date start = DateUtil.getTodayStart();
        Date end = DateUtil.getTodayEnd();
        sData.setSendDatetimeStart(start);
        sData.setSendDatetimeEnd(end);
        List<SOut> list = sOutBO.querySOutList(sData);
        for (SOut s : list) {
            if (!channels.contains(s.getChannel().split("-")[1]))
                channels.add(s.getChannel().split("-")[1]);
            if (!companys.contains(s.getCompanyCode()))
                companys.add(s.getCompanyCode());
        }
        int Scount = 0;
        int Fcount = 0;
        for (String company : companys) {
            for (String channel : channels) {
                for (SOut s : list) {
                    if (s.getCompanyCode().equals(company)
                            && s.getChannel().split("-")[1].equals(channel)) {
                        if (s.getErrorCode().equals("1")) {
                            Scount++;
                        } else {
                            Fcount++;
                        }
                    }
                }
                if (Scount != 0 || Fcount != 0) {
                    dayReportBO.saveDayReport(company, channel,
                        String.valueOf(Scount), String.valueOf(Fcount));
                    Scount = 0;
                    Fcount = 0;
                }
            }
        }
    }

    @Override
    public Paginable<DayReport> queryDayReportPage(int start, int limit,
            DayReport condition) {
        return dayReportBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<DayReport> queryDayReportList(DayReport condition) {
        return dayReportBO.queryDayReportList(condition);
    }
}
