package com.std.sms.bo.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.std.sms.bo.ICompanyBO;
import com.std.sms.bo.base.PaginableBOImpl;
import com.std.sms.dao.ICompanyDAO;
import com.std.sms.domain.Company;

@Component
public class CompanyBOImpl extends PaginableBOImpl<Company> implements
        ICompanyBO {

    @Autowired
    private ICompanyDAO companyDAO;

    @Override
    public Company queryCompany(String code) {
        Company data = new Company();
        data.setCode(code);
        return companyDAO.select(data);
    }

}
