package com.std.sms.dao;

import com.std.sms.dao.base.IBaseDAO;
import com.std.sms.domain.Receiver;

public interface IReceiverDAO extends IBaseDAO<Receiver> {
    String NAMESPACE = IReceiverDAO.class.getName().concat(".");

    public int update(Receiver data);

    public int updateWechatId(Receiver data);

    public int updateJpushId(Receiver data);

}
