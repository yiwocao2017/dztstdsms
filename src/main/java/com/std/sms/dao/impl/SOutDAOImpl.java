package com.std.sms.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.std.sms.dao.ISOutDAO;
import com.std.sms.dao.base.support.AMybatisTemplate;
import com.std.sms.domain.SOut;

@Repository("sOutDAOImpl")
public class SOutDAOImpl extends AMybatisTemplate implements ISOutDAO {

    @Override
    public int insert(SOut data) {
        return super.insert(NAMESPACE.concat("insert_sOut"), data);
    }

    @Override
    public int delete(SOut data) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public SOut select(SOut condition) {
        return super.select(NAMESPACE.concat("select_sOut"), condition,
            SOut.class);
    }

    @Override
    public long selectTotalCount(SOut condition) {
        return super.selectTotalCount(NAMESPACE.concat("select_sOut_count"),
            condition);
    }

    @Override
    public List<SOut> selectList(SOut condition) {
        return super.selectList(NAMESPACE.concat("select_sOut"), condition,
            SOut.class);
    }

    @Override
    public List<SOut> selectList(SOut condition, int start, int count) {
        return super.selectList(NAMESPACE.concat("select_sOut"), start, count,
            condition, SOut.class);
    }

}
