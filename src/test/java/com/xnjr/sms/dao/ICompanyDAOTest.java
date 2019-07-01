package com.xnjr.sms.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.unitils.spring.annotation.SpringBeanByType;

import com.std.sms.bo.IDayReportBO;
import com.std.sms.dao.ICompanyDAO;
import com.std.sms.dao.ISOutDAO;
import com.std.sms.domain.Company;

public class ICompanyDAOTest extends ADAOTest {

    @SpringBeanByType
    private ICompanyDAO companyDAO;

    @Autowired
    private ISOutDAO sOutDAO;

    @Autowired
    private IDayReportBO dayReportBO;

    @Test
    public void select() {
        Company condition = new Company();
        condition.setCode("XN1001");
        Company data = companyDAO.select(condition);
        logger.info("select : {}", data.getCode() + "\t" + data.getName()
                + "\t" + data.getPrefix());
    }
}
