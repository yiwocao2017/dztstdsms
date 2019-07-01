package com.std.sms.bo.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.std.sms.bo.IReceiverBO;
import com.std.sms.bo.base.PaginableBOImpl;
import com.std.sms.dao.IReceiverDAO;
import com.std.sms.domain.Receiver;
import com.std.sms.exception.BizException;

@Component
public class ReceiverBOImpl extends PaginableBOImpl<Receiver> implements
        IReceiverBO {

    @Autowired
    private IReceiverDAO receiverDAO;

    @Override
    public boolean isExistReceiver(String mobile, String systemCode,
            String level) {
        boolean result = false;
        if (StringUtils.isNotBlank(mobile)
                && StringUtils.isNotBlank(systemCode)) {
            Receiver condition = new Receiver();
            condition.setMobile(mobile);
            condition.setSystemCode(systemCode);
            condition.setLevel(level);
            Receiver data = receiverDAO.select(condition);
            if (data != null) {
                result = true;
            }
        }
        return result;
    }

    @Override
    public String saveReceiver(Receiver data) {
        String code = null;
        if (data != null) {
            receiverDAO.insert(data);
        }
        return code;
    }

    @Override
    public int removeReceiver(String mobile, String systemCode) {
        int count = 0;
        if (StringUtils.isNotBlank(mobile)
                && StringUtils.isNotBlank(systemCode)) {
            Receiver data = new Receiver();
            data.setMobile(mobile);
            data.setSystemCode(systemCode);
            count = receiverDAO.delete(data);
        }
        return count;
    }

    @Override
    public int refreshReceiver(Receiver data) {
        int count = 0;
        if (StringUtils.isNotBlank(data.getMobile())
                && StringUtils.isNotBlank(data.getSystemCode())) {
            count = receiverDAO.update(data);
        }
        return count;
    }

    @Override
    public List<Receiver> queryReceiverList(Receiver condition) {
        return receiverDAO.selectList(condition);
    }

    @Override
    public Receiver getReceiver(String mobile, String systemCode) {
        Receiver data = null;
        if (StringUtils.isNotBlank(mobile)
                && StringUtils.isNotBlank(systemCode)) {
            Receiver condition = new Receiver();
            condition.setMobile(mobile);
            condition.setSystemCode(systemCode);
            data = receiverDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "接收者记录不存在");
            }
        }
        return data;
    }

    @Override
    public Receiver getReceiverNotError(String mobile, String systemCode) {
        Receiver data = null;
        if (StringUtils.isNotBlank(mobile)
                && StringUtils.isNotBlank(systemCode)) {
            Receiver condition = new Receiver();
            condition.setMobile(mobile);
            condition.setSystemCode(systemCode);
            data = receiverDAO.select(condition);
        }
        return data;
    }

    @Override
    public Receiver getReceiverByWechatId(String wechatId, String systemCode) {
        Receiver data = null;
        if (StringUtils.isNotBlank(wechatId)
                && StringUtils.isNotBlank(systemCode)) {
            Receiver condition = new Receiver();
            condition.setWechatId(wechatId);
            condition.setSystemCode(systemCode);
            List<Receiver> dataList = receiverDAO.selectList(condition);
            if (CollectionUtils.isNotEmpty(dataList)) {
                data = dataList.get(0);
            }
        }
        return data;
    }

    @Override
    public int refreshReceiverWechatId(String mobile, String systemCode,
            String name, String wechatId, String remark) {
        int count = 0;
        if (StringUtils.isNotBlank(mobile)
                && StringUtils.isNotBlank(systemCode)) {
            Receiver data = new Receiver();
            data.setMobile(mobile);
            data.setSystemCode(systemCode);
            data.setName(name);
            data.setWechatId(wechatId);
            data.setRemark(remark);
            count = receiverDAO.updateWechatId(data);
        }
        return count;
    }

    @Override
    public int refreshReceiverJpushId(String mobile, String systemCode,
            String jpushId, String remark) {
        int count = 0;
        if (StringUtils.isNotBlank(mobile)
                && StringUtils.isNotBlank(systemCode)) {
            Receiver data = new Receiver();
            data.setMobile(mobile);
            data.setSystemCode(systemCode);
            data.setJpushId(jpushId);
            data.setRemark(remark);
            count = receiverDAO.updateJpushId(data);
        }
        return count;
    }
}
