package com.std.sms.bo;

import java.util.List;

import com.std.sms.bo.base.IPaginableBO;
import com.std.sms.domain.SystemTemplate;

/**
 * @author: xieyj 
 * @since: 2016年12月4日 上午9:45:21 
 * @history:
 */
public interface ISystemTemplateBO extends IPaginableBO<SystemTemplate> {

    public boolean isSystemTemplateExist(Long id);

    public String saveSystemTemplate(SystemTemplate data);

    public int removeSystemTemplate(Long id);

    public int refreshSystemTemplate(SystemTemplate data);

    public List<SystemTemplate> querySystemTemplateList(SystemTemplate condition);

    public SystemTemplate getSystemTemplate(Long id);

    public SystemTemplate getSystemTemplateByCondition(String systemCode,
            String channelType, String pushType, String templateId);

    public SystemTemplate getSystemTemplate(String systemCode);
}
