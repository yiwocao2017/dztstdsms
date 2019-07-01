package com.std.sms.bo;

import java.util.List;

import com.std.sms.bo.base.IPaginableBO;
import com.std.sms.domain.SystemChannel;
import com.std.sms.enums.EChannelType;

public interface ISystemChannelBO extends IPaginableBO<SystemChannel> {

    public boolean isSystemChannelExist(Long id);

    public boolean isSystemChannelExist(String systemCode, String channelType,
            String pushType, Long id);

    public void saveSystemChannel(SystemChannel data);

    public int removeSystemChannel(Long id);

    public int refreshSystemChannel(SystemChannel data);

    public int refreshSystemChannel(Long id, String privateKey3);

    public List<SystemChannel> querySystemChannelList(SystemChannel condition);

    public SystemChannel getSystemChannel(Long id);

    public SystemChannel getSystemChannelByCondition(String systemCode,
            EChannelType channelType, String pushType);
}
