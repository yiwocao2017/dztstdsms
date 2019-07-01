package com.std.sms.bo.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.std.sms.bo.IItemsBO;
import com.std.sms.bo.base.PaginableBOImpl;
import com.std.sms.core.OrderNoGenerater;
import com.std.sms.dao.IItemsDAO;
import com.std.sms.domain.Items;
import com.std.sms.enums.EGeneratePrefix;
import com.std.sms.exception.BizException;

@Component
public class ItemsBOImpl extends PaginableBOImpl<Items> implements IItemsBO {

    @Autowired
    private IItemsDAO itemsDAO;

    @Override
    public boolean isItemsExist(String code) {
        Items condition = new Items();
        condition.setCode(code);
        if (itemsDAO.selectTotalCount(condition) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public String saveItems(Items data) {
        String code = null;
        if (data != null) {
            code = OrderNoGenerater.generateM(EGeneratePrefix.ITEM.getCode());
            data.setCode(code);
            itemsDAO.insert(data);
        }
        return code;
    }

    @Override
    public int removeItems(String code) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            Items data = new Items();
            data.setCode(code);
            count = itemsDAO.delete(data);
        }
        return count;
    }

    @Override
    public int refreshItems(Items data) {
        int count = 0;
        if (StringUtils.isNotBlank(data.getCode())) {
            count = itemsDAO.update(data);
        }
        return count;
    }

    @Override
    public List<Items> queryItemsList(Items condition) {
        return itemsDAO.selectList(condition);
    }

    @Override
    public Items getItems(String code) {
        Items data = null;
        if (StringUtils.isNotBlank(code)) {
            Items condition = new Items();
            condition.setCode(code);
            data = itemsDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "�� ��Ų�����");
            }
        }
        return data;
    }
}
