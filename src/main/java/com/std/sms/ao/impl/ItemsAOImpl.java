package com.std.sms.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.std.sms.ao.IItemsAO;
import com.std.sms.bo.IItemsBO;
import com.std.sms.bo.IUserBO;
import com.std.sms.bo.base.Paginable;
import com.std.sms.domain.Items;
import com.std.sms.exception.BizException;

@Service
public class ItemsAOImpl implements IItemsAO {

    @Autowired
    private IItemsBO itemsBO;

    @Autowired
    private IUserBO userBO;

    @Override
    public String addItems(Items data) {
        String userId = userBO.addUser(data.getLoginName(), data.getUpdater());
        data.setUserId(userId);
        return itemsBO.saveItems(data);
    }

    @Override
    public int editItems(Items data) {
        if (!itemsBO.isItemsExist(data.getCode())) {
            throw new BizException("xn0000", "办件员不存在");
        }
        return itemsBO.refreshItems(data);
    }

    @Override
    public int dropItems(String code, String updater) {
        Items items = this.getItems(code);
        userBO.logoutUser(items.getUserId(), updater);
        return itemsBO.removeItems(code);
    }

    @Override
    public Paginable<Items> queryItemsPage(int start, int limit, Items condition) {
        return itemsBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<Items> queryItemsList(Items condition) {
        return itemsBO.queryItemsList(condition);
    }

    @Override
    public Items getItems(String code) {
        return itemsBO.getItems(code);
    }
}
