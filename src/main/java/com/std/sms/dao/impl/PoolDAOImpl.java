package com.std.sms.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.std.sms.dao.IPoolDAO;
import com.std.sms.dao.base.support.AMybatisTemplate;
import com.std.sms.domain.Pool;

@Repository("poolDAOImpl")
public class PoolDAOImpl extends AMybatisTemplate implements IPoolDAO {

    @Override
    public int insert(Pool data) {
        return super.insert(NAMESPACE.concat("insert_pool"), data);
    }

    @Override
    public int delete(Pool data) {
        return super.delete(NAMESPACE.concat("delete_pool"), data);
    }

    @Override
    public Pool select(Pool condition) {
        return super.select(NAMESPACE.concat("select_pool"), condition,
            Pool.class);
    }

    @Override
    public long selectTotalCount(Pool condition) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public List<Pool> selectList(Pool condition) {
        return super.selectList(NAMESPACE.concat("select_pool"), condition,
            Pool.class);
    }

    @Override
    public List<Pool> selectList(Pool condition, int start, int count) {
        return super.selectList(NAMESPACE.concat("select_pool"), start, count,
            condition, Pool.class);
    }

}
