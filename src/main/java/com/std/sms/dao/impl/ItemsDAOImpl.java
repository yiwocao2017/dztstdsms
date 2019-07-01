package com.std.sms.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.std.sms.dao.IItemsDAO;
import com.std.sms.dao.base.support.AMybatisTemplate;
import com.std.sms.domain.Items;

@Repository("itemsDAOImpl")
public class ItemsDAOImpl extends AMybatisTemplate implements IItemsDAO {

    @Override
    public int insert(Items data) {
        return super.insert(NAMESPACE.concat("insert_items"), data);
    }

    @Override
    public int delete(Items data) {
        return super.delete(NAMESPACE.concat("delete_items"), data);
    }

    @Override
    public Items select(Items condition) {
        return super.select(NAMESPACE.concat("select_items"), condition,
            Items.class);
    }

    @Override
    public long selectTotalCount(Items condition) {
        return super.selectTotalCount(NAMESPACE.concat("select_items_count"),
            condition);
    }

    @Override
    public List<Items> selectList(Items condition) {
        return super.selectList(NAMESPACE.concat("select_items"), condition,
            Items.class);
    }

    @Override
    public List<Items> selectList(Items condition, int start, int count) {
        return super.selectList(NAMESPACE.concat("select_items"), start, count,
            condition, Items.class);
    }

    /** 
     * @see com.std.sms.dao.IItemsDAO#update(com.std.sms.domain.Items)
     */
    @Override
    public int update(Items data) {
        return super.update(NAMESPACE.concat("update_items"), data);
    }
}
