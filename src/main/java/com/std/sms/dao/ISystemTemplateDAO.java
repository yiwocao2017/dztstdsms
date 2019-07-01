package com.std.sms.dao;

import com.std.sms.dao.base.IBaseDAO;
import com.std.sms.domain.SystemTemplate;

/**
 * @author: xieyj 
 * @since: 2016年12月4日 上午9:49:15 
 * @history:
 */
public interface ISystemTemplateDAO extends IBaseDAO<SystemTemplate> {
    String NAMESPACE = ISystemTemplateDAO.class.getName().concat(".");

    public int update(SystemTemplate data);
}
