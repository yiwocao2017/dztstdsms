package com.std.sms.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.std.sms.dao.IDayReportDAO;
import com.std.sms.dao.base.support.AMybatisTemplate;
import com.std.sms.domain.DayReport;

@Repository("dayReportDAOImpl")
public class DayReportDAOImpl extends AMybatisTemplate implements IDayReportDAO {

    @Override
    public int insert(DayReport data) {
        return super.insert(NAMESPACE.concat("insert_dayReport"), data);
    }

    @Override
    public int delete(DayReport data) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public DayReport select(DayReport condition) {
        return super.select(NAMESPACE.concat("select_dayReport"), condition,
            DayReport.class);
    }

    @Override
    public long selectTotalCount(DayReport condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_dayReport_count"), condition);
    }

    @Override
    public List<DayReport> selectList(DayReport condition) {
        return super.selectList(NAMESPACE.concat("select_dayReport"),
            condition, DayReport.class);
    }

    @Override
    public List<DayReport> selectList(DayReport condition, int start, int count) {
        return super.selectList(NAMESPACE.concat("select_dayReport"), start,
            count, condition, DayReport.class);
    }

}
