package com.std.sms.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.std.sms.dao.ISystemChannelDAO;
import com.std.sms.dao.base.support.AMybatisTemplate;
import com.std.sms.domain.SystemChannel;

/**
 * @author: xieyj 
 * @since: 2016年11月18日 下午4:25:27 
 * @history:
 */
@Repository("systemChannelDAOImpl")
public class SystemChannelDAOImpl extends AMybatisTemplate implements
        ISystemChannelDAO {

    @Override
    public int insert(SystemChannel data) {
        return super.insert(NAMESPACE.concat("insert_systemChannel"), data);
    }

    @Override
    public int delete(SystemChannel data) {
        return super.delete(NAMESPACE.concat("delete_systemChannel"), data);
    }

    @Override
    public int update(SystemChannel data) {
        return super.update(NAMESPACE.concat("update_systemChannel"), data);
    }

    @Override
    public SystemChannel select(SystemChannel condition) {
        return super.select(NAMESPACE.concat("select_systemChannel"),
            condition, SystemChannel.class);
    }

    @Override
    public long selectTotalCount(SystemChannel condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_systemChannel_count"), condition);
    }

    @Override
    public List<SystemChannel> selectList(SystemChannel condition) {
        return super.selectList(NAMESPACE.concat("select_systemChannel"),
            condition, SystemChannel.class);
    }

    @Override
    public List<SystemChannel> selectList(SystemChannel condition, int start,
            int count) {
        return super.selectList(NAMESPACE.concat("select_systemChannel"),
            start, count, condition, SystemChannel.class);
    }

    /** 
     * @see com.std.sms.dao.ISystemChannelDAO#updatePrivateKey3(com.std.sms.domain.SystemChannel)
     */
    @Override
    public int updatePrivateKey3(SystemChannel data) {
        return super.update(
            NAMESPACE.concat("update_systemChannel_privateKey3"), data);
    }
}
