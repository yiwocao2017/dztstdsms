package com.std.sms.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.std.sms.bo.base.Paginable;
import com.std.sms.domain.Items;

@Component
public interface IItemsAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public String addItems(Items data);

    public int dropItems(String code, String updater);

    public int editItems(Items data);

    public Paginable<Items> queryItemsPage(int start, int limit, Items condition);

    public List<Items> queryItemsList(Items condition);

    public Items getItems(String code);

}
