package com.std.sms.dao;

import com.std.sms.dao.base.IBaseDAO;
import com.std.sms.domain.SOut;

public interface ISOutDAO extends IBaseDAO<SOut> {
    String NAMESPACE = ISOutDAO.class.getName().concat(".");
}
