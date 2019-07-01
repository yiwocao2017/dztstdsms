package com.std.sms.dao;

import com.std.sms.dao.base.IBaseDAO;
import com.std.sms.domain.DayReport;

public interface IDayReportDAO extends IBaseDAO<DayReport> {
    String NAMESPACE = IDayReportDAO.class.getName().concat(".");
}
