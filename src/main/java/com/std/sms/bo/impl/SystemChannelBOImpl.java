package com.std.sms.bo.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.std.sms.bo.ISystemChannelBO;
import com.std.sms.bo.base.PaginableBOImpl;
import com.std.sms.dao.ISystemChannelDAO;
import com.std.sms.domain.SystemChannel;
import com.std.sms.enums.EChannelType;
import com.std.sms.exception.BizException;

@Component
public class SystemChannelBOImpl extends PaginableBOImpl<SystemChannel>
        implements ISystemChannelBO {

    @Autowired
    private ISystemChannelDAO systemChannelDAO;

    @Override
    public boolean isSystemChannelExist(Long id) {
        SystemChannel condition = new SystemChannel();
        condition.setId(id);
        if (systemChannelDAO.selectTotalCount(condition) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isSystemChannelExist(String systemCode, String channelType,
            String pushType, Long id) {
        boolean result = false;
        SystemChannel condition = new SystemChannel();
        condition.setSystemCode(systemCode);
        condition.setChannelType(channelType);
        condition.setPushType(pushType);
        List<SystemChannel> list = systemChannelDAO.selectList(condition);
        if (CollectionUtils.isNotEmpty(list)) {
            SystemChannel data = list.get(0);
            if (id == null || !id.equals(data.getId())) {
                result = true;
            }
        }
        return result;
    }

    @Override
    public void saveSystemChannel(SystemChannel data) {
        if (data != null) {
            systemChannelDAO.insert(data);
        }
    }

    @Override
    public int removeSystemChannel(Long id) {
        int count = 0;
        if (id != null) {
            SystemChannel data = new SystemChannel();
            data.setId(id);
            count = systemChannelDAO.delete(data);
        }
        return count;
    }

    @Override
    public int refreshSystemChannel(SystemChannel data) {
        int count = 0;
        if (StringUtils.isNotBlank(data.getSystemCode())) {
            count = systemChannelDAO.update(data);
        }
        return count;
    }

    /** 
     * @see com.std.sms.bo.ISystemChannelBO#refreshSystemChannel(java.lang.Long, java.lang.String)
     */
    @Override
    @Transactional
    public int refreshSystemChannel(Long id, String privateKey3) {
        int count = 0;
        if (id != null) {
            SystemChannel data = new SystemChannel();
            data.setId(id);
            data.setPrivateKey3(privateKey3);
            systemChannelDAO.updatePrivateKey3(data);
        }
        return count;
    }

    @Override
    public List<SystemChannel> querySystemChannelList(SystemChannel condition) {
        return systemChannelDAO.selectList(condition);
    }

    @Override
    public SystemChannel getSystemChannel(Long id) {
        SystemChannel data = null;
        if (id != null) {
            SystemChannel condition = new SystemChannel();
            condition.setId(id);
            data = systemChannelDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "系统渠道不存在");
            }
        }
        return data;
    }

    @Override
    public SystemChannel getSystemChannelByCondition(String systemCode,
            EChannelType channelType, String pushType) {
        SystemChannel data = null;
        if (StringUtils.isNotBlank(systemCode) && null != channelType
                && null != pushType) {
            SystemChannel condition = new SystemChannel();
            condition.setSystemCode(systemCode);
            condition.setChannelType(channelType.getCode());
            condition.setPushType(pushType);
            List<SystemChannel> list = systemChannelDAO.selectList(condition);
            if (CollectionUtils.isNotEmpty(list)) {
                data = list.get(0);
            }
            if (data == null) {
                throw new BizException("xn0000", "系统渠道不存在");
            }
        }
        return data;
    }
}
