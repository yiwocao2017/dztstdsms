package com.std.sms.bo;

import java.util.List;

import com.std.sms.bo.base.IPaginableBO;
import com.std.sms.domain.Items;

/**
 * @author: xieyj 
 * @since: 2016年11月29日 下午7:26:35 
 * @history:
 */
public interface IItemsBO extends IPaginableBO<Items> {

    public boolean isItemsExist(String code);

    public String saveItems(Items data);

    public int removeItems(String code);

    public int refreshItems(Items data);

    public List<Items> queryItemsList(Items condition);

    public Items getItems(String code);

}
