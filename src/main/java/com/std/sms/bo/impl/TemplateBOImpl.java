package com.std.sms.bo.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.std.sms.bo.ITemplateBO;
import com.std.sms.dao.ISystemChannelDAO;

@Component
public class TemplateBOImpl implements ITemplateBO {

    @Autowired
    private ISystemChannelDAO systemChannelDAO;

    // /**
    // * @see com.std.sms.bo.ITemplateBO#getTemplate(java.lang.String)
    // */
    // @Override
    // public Template getTemplate(String systemCode) {
    // SystemChannel condition = new SystemChannel();
    // condition.setSystemCode(systemCode);
    // condition.setChannelType(EChannelType.WECHAT.getCode());
    // condition.setPushType(EPushType.WEIXIN.getCode());
    // SystemChannel systemChannel = systemChannelDAO.select(condition);
    // List<Template> list = WeChatClientSend.getTemplateList(systemChannel
    // .getPrivateKey3());
    // Template data = null;
    // for (Template template : list) {
    // if (PropertiesUtil.Config.TEMPLATE_ID.equals(template
    // .getTemplate_id())) {
    // data = template;
    // break;
    // }
    // }
    // return data;
    // }
}
