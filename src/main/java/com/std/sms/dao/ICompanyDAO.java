package com.std.sms.dao;

import com.std.sms.dao.base.IBaseDAO;
import com.std.sms.domain.Company;

public interface ICompanyDAO extends IBaseDAO<Company> {
    String NAMESPACE = ICompanyDAO.class.getName().concat(".");
}
