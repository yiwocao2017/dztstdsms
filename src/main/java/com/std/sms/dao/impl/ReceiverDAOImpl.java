package com.std.sms.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.std.sms.dao.IReceiverDAO;
import com.std.sms.dao.base.support.AMybatisTemplate;
import com.std.sms.domain.Receiver;

@Repository("receiverDAOImpl")
public class ReceiverDAOImpl extends AMybatisTemplate implements IReceiverDAO {

    @Override
    public int insert(Receiver data) {
        return super.insert(NAMESPACE.concat("insert_receiver"), data);
    }

    @Override
    public int delete(Receiver data) {
        return super.delete(NAMESPACE.concat("delete_receiver"), data);
    }

    @Override
    public Receiver select(Receiver condition) {
        return super.select(NAMESPACE.concat("select_receiver"), condition,
            Receiver.class);
    }

    @Override
    public long selectTotalCount(Receiver condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_receiver_count"), condition);
    }

    @Override
    public List<Receiver> selectList(Receiver condition) {
        return super.selectList(NAMESPACE.concat("select_receiver"), condition,
            Receiver.class);
    }

    @Override
    public List<Receiver> selectList(Receiver condition, int start, int count) {
        return super.selectList(NAMESPACE.concat("select_receiver"), start,
            count, condition, Receiver.class);
    }

    /** 
     * @see com.std.sms.dao.IReceiverDAO#update(com.std.sms.domain.SystemChannel)
     */
    @Override
    public int update(Receiver data) {
        return super.update(NAMESPACE.concat("update_receiver"), data);
    }

    /** 
     * @see com.std.sms.dao.IReceiverDAO#updateOpenID(com.std.sms.domain.Receiver)
     */
    @Override
    public int updateWechatId(Receiver data) {
        return super.update(NAMESPACE.concat("update_receiver_wechatId"), data);
    }

    /** 
     * @see com.std.sms.dao.IReceiverDAO#updateJpushID(com.std.sms.domain.Receiver)
     */
    @Override
    public int updateJpushId(Receiver data) {
        return super.update(NAMESPACE.concat("update_receiver_jpushId"), data);
    }
}
