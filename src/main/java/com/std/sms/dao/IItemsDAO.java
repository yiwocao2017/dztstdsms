package com.std.sms.dao;

import com.std.sms.dao.base.IBaseDAO;
import com.std.sms.domain.Items;

//dao层 
public interface IItemsDAO extends IBaseDAO<Items> {
    String NAMESPACE = IItemsDAO.class.getName().concat(".");

    public int update(Items data);
}
