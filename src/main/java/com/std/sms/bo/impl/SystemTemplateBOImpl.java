package com.std.sms.bo.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.std.sms.bo.ISystemTemplateBO;
import com.std.sms.bo.base.PaginableBOImpl;
import com.std.sms.dao.ISystemChannelDAO;
import com.std.sms.dao.ISystemTemplateDAO;
import com.std.sms.domain.SystemTemplate;
import com.std.sms.exception.BizException;
import com.std.sms.sent.wechat.WeChatClientSend;

@Component
public class SystemTemplateBOImpl extends PaginableBOImpl<SystemTemplate>
        implements ISystemTemplateBO {

    @Autowired
    private ISystemTemplateDAO systemTemplateDAO;

    @Autowired
    private ISystemChannelDAO systemChannelDAO;

    @Autowired
    private WeChatClientSend weChatClientSend;

    @Override
    public boolean isSystemTemplateExist(Long id) {
        SystemTemplate condition = new SystemTemplate();
        condition.setId(id);
        if (systemTemplateDAO.selectTotalCount(condition) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public String saveSystemTemplate(SystemTemplate data) {
        String code = null;
        if (data != null) {
            systemTemplateDAO.insert(data);
        }
        return code;
    }

    @Override
    public int removeSystemTemplate(Long id) {
        int count = 0;
        if (id != null) {
            SystemTemplate data = new SystemTemplate();
            data.setId(id);
            count = systemTemplateDAO.delete(data);
        }
        return count;
    }

    @Override
    public int refreshSystemTemplate(SystemTemplate data) {
        int count = 0;
        if (null != data.getId()) {
            count = systemTemplateDAO.update(data);
        }
        return count;
    }

    @Override
    public List<SystemTemplate> querySystemTemplateList(SystemTemplate condition) {
        return systemTemplateDAO.selectList(condition);
    }

    @Override
    public SystemTemplate getSystemTemplate(Long id) {
        SystemTemplate data = null;
        if (id != null) {
            SystemTemplate condition = new SystemTemplate();
            condition.setId(id);
            data = systemTemplateDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "系统模板不存在");
            }
        }
        return data;
    }

    @Override
    public SystemTemplate getSystemTemplateByCondition(String systemCode,
            String channelType, String pushType, String templateId) {
        // SystemChannel condition = new SystemChannel();
        // condition.setSystemCode(systemCode);
        // condition.setChannelType(EChannelType.WECHAT.getCode());
        // condition.setPushType(EPushType.WEIXIN.getCode());
        // SystemChannel systemChannel = systemChannelDAO.select(condition);
        // List<Template> list = weChatClientSend.getTemplateList(systemChannel
        // .getPrivateKey3());
        // SystemTemplate systemTemplate = getSystemTemplate(systemCode);
        // Template data = null;
        // for (Template template : list) {
        // if (systemTemplate.getTemplateId()
        // .equals(template.getTemplate_id())) {
        // data = template;
        // break;
        // }
        // }
        SystemTemplate data = null;
        SystemTemplate condition = new SystemTemplate();
        condition.setSystemCode(systemCode);
        condition.setChannelType(channelType);
        condition.setPushType(pushType);
        condition.setTemplateId(templateId);
        List<SystemTemplate> list = systemTemplateDAO.selectList(condition);
        if (CollectionUtils.isNotEmpty(list)) {
            data = list.get(0);
        }
        if (data == null) {
            throw new BizException("xn0000", "系统模板不存在");
        }
        return data;
    }

    @Override
    public SystemTemplate getSystemTemplate(String systemCode) {
        SystemTemplate data = null;
        SystemTemplate condition = new SystemTemplate();
        condition.setSystemCode(systemCode);
        List<SystemTemplate> dataList = systemTemplateDAO.selectList(condition);
        if (CollectionUtils.isNotEmpty(dataList)) {
            data = dataList.get(0);
        } else {
            throw new BizException("xn0000", "系统模板不存在");
        }
        return data;
    }
}
