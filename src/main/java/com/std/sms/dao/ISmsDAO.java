package com.std.sms.dao;

import com.std.sms.dao.base.IBaseDAO;
import com.std.sms.domain.Sms;

public interface ISmsDAO extends IBaseDAO<Sms> {
    String NAMESPACE = ISmsDAO.class.getName().concat(".");

    public int update(Sms data);

    public int updateStatus(Sms data);
}
