package com.std.sms.dao;

import com.std.sms.dao.base.IBaseDAO;
import com.std.sms.domain.SystemChannel;

/**
 * @author: xieyj 
 * @since: 2016年11月18日 下午4:24:03 
 * @history:
 */
public interface ISystemChannelDAO extends IBaseDAO<SystemChannel> {
    String NAMESPACE = ISystemChannelDAO.class.getName().concat(".");

    public int update(SystemChannel data);

    public int updatePrivateKey3(SystemChannel data);
}
