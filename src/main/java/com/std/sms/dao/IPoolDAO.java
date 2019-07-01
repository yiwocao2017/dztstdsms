package com.std.sms.dao;

import com.std.sms.dao.base.IBaseDAO;
import com.std.sms.domain.Pool;

public interface IPoolDAO extends IBaseDAO<Pool> {
    String NAMESPACE = IPoolDAO.class.getName().concat(".");
}
