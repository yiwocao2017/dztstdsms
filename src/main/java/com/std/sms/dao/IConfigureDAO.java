package com.std.sms.dao;

import com.std.sms.dao.base.IBaseDAO;
import com.std.sms.domain.Configure;

public interface IConfigureDAO extends IBaseDAO<Configure> {
    String NAMESPACE = IConfigureDAO.class.getName().concat(".");
}
