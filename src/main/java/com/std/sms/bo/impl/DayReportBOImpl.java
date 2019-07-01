package com.std.sms.bo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.std.sms.bo.IDayReportBO;
import com.std.sms.bo.base.PaginableBOImpl;
import com.std.sms.common.DateUtil;
import com.std.sms.core.OrderNoGenerater;
import com.std.sms.dao.IDayReportDAO;
import com.std.sms.domain.DayReport;

@Component
public class DayReportBOImpl extends PaginableBOImpl<DayReport> implements
        IDayReportBO {

    @Autowired
    private IDayReportDAO dayReportDAO;

    @Override
    public int saveDayReport(String companyCode, String channel,
            String sucTimes, String failTimes) {
        DayReport data = new DayReport();
        data.setCode(OrderNoGenerater.generateM("DR"));
        data.setCompanyCode(companyCode);
        data.setChannel(channel);
        data.setSucTimes(sucTimes);
        data.setFailTimes(failTimes);
        String reportDate = DateUtil.getToday(DateUtil.DATA_TIME_PATTERN_1);
        data.setReportDate(DateUtil.strToDate(reportDate,
            DateUtil.DATA_TIME_PATTERN_1));
        return dayReportDAO.insert(data);
    }

    @Override
    public DayReport getDayReport(DayReport data) {
        return dayReportDAO.select(data);
    }

    @Override
    public List<DayReport> queryDayReportList(DayReport data) {
        return dayReportDAO.selectList(data);
    }

}
