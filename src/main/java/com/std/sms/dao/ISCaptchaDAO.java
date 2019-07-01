package com.std.sms.dao;

import com.std.sms.dao.base.IBaseDAO;
import com.std.sms.domain.SCaptcha;

public interface ISCaptchaDAO extends IBaseDAO<SCaptcha> {
    String NAMESPACE = ISCaptchaDAO.class.getName().concat(".");

    public int updateCheckInfo(SCaptcha data);
}
