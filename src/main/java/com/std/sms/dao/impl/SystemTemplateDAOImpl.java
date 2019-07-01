package com.std.sms.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.std.sms.dao.ISystemTemplateDAO;
import com.std.sms.dao.base.support.AMybatisTemplate;
import com.std.sms.domain.SystemTemplate;

/**
 * @author: xieyj 
 * @since: 2016年12月4日 上午9:43:44 
 * @history:
 */
@Repository("systemTemplateDAOImpl")
public class SystemTemplateDAOImpl extends AMybatisTemplate implements
        ISystemTemplateDAO {

    @Override
    public int insert(SystemTemplate data) {
        return super.insert(NAMESPACE.concat("insert_systemTemplate"), data);
    }

    @Override
    public int delete(SystemTemplate data) {
        return super.delete(NAMESPACE.concat("delete_systemTemplate"), data);
    }

    @Override
    public SystemTemplate select(SystemTemplate condition) {
        return super.select(NAMESPACE.concat("select_systemTemplate"),
            condition, SystemTemplate.class);
    }

    @Override
    public long selectTotalCount(SystemTemplate condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_systemTemplate_count"), condition);
    }

    @Override
    public List<SystemTemplate> selectList(SystemTemplate condition) {
        return super.selectList(NAMESPACE.concat("select_systemTemplate"),
            condition, SystemTemplate.class);
    }

    @Override
    public List<SystemTemplate> selectList(SystemTemplate condition, int start,
            int count) {
        return super.selectList(NAMESPACE.concat("select_systemTemplate"),
            start, count, condition, SystemTemplate.class);
    }

    /** 
     * @see com.std.sms.dao.ISystemTemplateDAO#update(com.std.sms.domain.SystemTemplate)
     */
    @Override
    public int update(SystemTemplate data) {
        return super.update(NAMESPACE.concat("update_systemTemplate"), data);
    }

}
