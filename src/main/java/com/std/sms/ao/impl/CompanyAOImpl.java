package com.std.sms.ao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.std.sms.ao.ICompanyAO;
import com.std.sms.bo.ICompanyBO;
import com.std.sms.domain.Company;

@Service
public class CompanyAOImpl implements ICompanyAO {

    @Autowired
    private ICompanyBO companyBO;

    @Override
    public Company doGetCompany(String code) {
        return companyBO.queryCompany(code);
    }

}
