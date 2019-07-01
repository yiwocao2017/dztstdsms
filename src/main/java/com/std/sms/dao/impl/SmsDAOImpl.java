package com.std.sms.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.std.sms.dao.ISmsDAO;
import com.std.sms.dao.base.support.AMybatisTemplate;
import com.std.sms.domain.Sms;

@Repository("smsDAOImpl")
public class SmsDAOImpl extends AMybatisTemplate implements ISmsDAO {

    @Override
    public int insert(Sms data) {
        return super.insert(NAMESPACE.concat("insert_sms"), data);
    }

    @Override
    public int delete(Sms data) {
        return super.delete(NAMESPACE.concat("delete_sms"), data);
    }

    /** 
     * @see com.std.sms.dao.ISmsDAO#update(com.std.sms.domain.Sms)
     */
    @Override
    public int update(Sms data) {
        return super.update(NAMESPACE.concat("update_sms"), data);
    }

    @Override
    public int updateStatus(Sms data) {
        return super.update(NAMESPACE.concat("update_sms_status"), data);
    }

    @Override
    public Sms select(Sms condition) {
        return super.select(NAMESPACE.concat("select_sms"), condition,
            Sms.class);
    }

    @Override
    public long selectTotalCount(Sms condition) {
        return super.selectTotalCount(NAMESPACE.concat("select_sms_count"),
            condition);
    }

    @Override
    public List<Sms> selectList(Sms condition) {
        return super.selectList(NAMESPACE.concat("select_sms"), condition,
            Sms.class);
    }

    @Override
    public List<Sms> selectList(Sms condition, int start, int count) {
        return super.selectList(NAMESPACE.concat("select_sms"), start, count,
            condition, Sms.class);
    }
}
