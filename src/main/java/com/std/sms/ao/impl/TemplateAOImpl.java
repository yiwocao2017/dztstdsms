package com.std.sms.ao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.std.sms.ao.ITemplateAO;
import com.std.sms.bo.ISystemTemplateBO;
import com.std.sms.bo.ITemplateBO;
import com.std.sms.sent.wechat.Template;

@Service
public class TemplateAOImpl implements ITemplateAO {
    @Autowired
    private ITemplateBO templateBO;

    @Autowired
    private ISystemTemplateBO systemTemplateBO;

    /** 
     * @see com.std.sms.ao.ITemplateAO#getTemplate()
     */
    @Override
    public Template getTemplate(String systemCode) {
        // return templateBO.getTemplate(systemCode);
        // return systemTemplateBO.getSystemTemplateByCondition(systemCode);
        return null;
    }
}
