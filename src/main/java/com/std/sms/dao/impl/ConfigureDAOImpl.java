package com.std.sms.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.std.sms.dao.IConfigureDAO;
import com.std.sms.dao.base.support.AMybatisTemplate;
import com.std.sms.domain.Configure;

@Repository("configureDAOImpl")
public class ConfigureDAOImpl extends AMybatisTemplate implements IConfigureDAO {

    @Override
    public int insert(Configure data) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int delete(Configure data) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Configure select(Configure condition) {
        return super.select(NAMESPACE.concat("select_configure"), condition,
            Configure.class);
    }

    @Override
    public long selectTotalCount(Configure condition) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public List<Configure> selectList(Configure condition) {
        return super.selectList(NAMESPACE.concat("select_configure"),
            condition, Configure.class);
    }

    @Override
    public List<Configure> selectList(Configure condition, int start, int count) {
        return super.selectList(NAMESPACE.concat("select_configure"), start,
            count, condition, Configure.class);
    }
}
