package com.std.sms.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.std.sms.dao.ICompanyDAO;
import com.std.sms.dao.base.support.AMybatisTemplate;
import com.std.sms.domain.Company;

@Repository("companyDAOImpl")
public class CompanyDAOImpl extends AMybatisTemplate implements ICompanyDAO {

    @Override
    public int insert(Company data) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int delete(Company data) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Company select(Company condition) {
        return super.select(NAMESPACE.concat("select_company"), condition,
            Company.class);
    }

    @Override
    public long selectTotalCount(Company condition) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public List<Company> selectList(Company condition) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Company> selectList(Company condition, int start, int count) {
        // TODO Auto-generated method stub
        return null;
    }

}
