package com.std.sms.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.std.sms.ao.ISystemTemplateAO;
import com.std.sms.bo.ISystemTemplateBO;
import com.std.sms.bo.base.Paginable;
import com.std.sms.domain.SystemTemplate;
import com.std.sms.exception.BizException;

@Service
public class SystemTemplateAOImpl implements ISystemTemplateAO {

    @Autowired
    private ISystemTemplateBO systemTemplateBO;

    @Override
    public void addSystemTemplate(SystemTemplate data) {
        systemTemplateBO.saveSystemTemplate(data);
    }

    @Override
    public void editSystemTemplate(SystemTemplate data) {
        if (!systemTemplateBO.isSystemTemplateExist(data.getId())) {
            throw new BizException("xn0000", "记录编号不存在");
        }
        systemTemplateBO.refreshSystemTemplate(data);
    }

    @Override
    public void dropSystemTemplate(Long id) {
        if (!systemTemplateBO.isSystemTemplateExist(id)) {
            throw new BizException("xn0000", "记录编号不存在");
        }
        systemTemplateBO.removeSystemTemplate(id);
    }

    @Override
    public Paginable<SystemTemplate> querySystemTemplatePage(int start,
            int limit, SystemTemplate condition) {
        return systemTemplateBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<SystemTemplate> querySystemTemplateList(SystemTemplate condition) {
        return systemTemplateBO.querySystemTemplateList(condition);
    }

    @Override
    public SystemTemplate getSystemTemplate(Long id) {
        return systemTemplateBO.getSystemTemplate(id);
    }
}
