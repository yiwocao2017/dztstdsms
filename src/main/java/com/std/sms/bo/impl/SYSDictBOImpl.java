/**
 * @Title SYSDictBOImpl.java 
 * @Package com.xnjr.moom.bo.impl 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年4月17日 下午2:50:06 
 * @version V1.0   
 */
package com.std.sms.bo.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.std.sms.bo.ISYSDictBO;
import com.std.sms.bo.base.PaginableBOImpl;
import com.std.sms.dao.ISYSDictDAO;
import com.std.sms.domain.SYSDict;
import com.std.sms.enums.EDictType;
import com.std.sms.exception.BizException;

/** 
 * @author: haiqingzheng 
 * @since: 2016年4月17日 下午2:50:06 
 * @history:
 */
@Component
public class SYSDictBOImpl extends PaginableBOImpl<SYSDict> implements
        ISYSDictBO {
    @Autowired
    private ISYSDictDAO sysDictDAO;

    @Override
    public Long saveSYSDict(String type, String parentKey, String key,
            String value, String remark) {
        SYSDict sysDict = new SYSDict();
        sysDict.setType(type);
        if (EDictType.SECOND.getCode().equals(type)) {
            sysDict.setParentKey(parentKey);
        } else {
            sysDict.setParentKey(null);
        }
        sysDict.setDkey(key);
        sysDict.setDvalue(value);
        sysDict.setRemark(remark);
        sysDictDAO.insert(sysDict);
        return sysDict.getId();
    }

    @Override
    public void removeSYSDict(Long id) {
        if (id > 0) {
            SYSDict data = new SYSDict();
            data.setId(id);
            sysDictDAO.delete(data);
        }
    }

    @Override
    public void refreshSYSDict(Long id, String value, String remark) {
        if (id > 0) {
            SYSDict data = new SYSDict();
            data.setId(id);
            data.setDvalue(value);
            data.setRemark(remark);
            sysDictDAO.update(data);
        }
    }

    @Override
    public SYSDict getSYSDict(Long id) {
        SYSDict sysDict = null;
        if (id > 0) {
            SYSDict data = new SYSDict();
            data.setId(id);
            sysDict = sysDictDAO.select(data);
        }
        return sysDict;
    }

    @Override
    public List<SYSDict> querySYSDictList(SYSDict condition) {
        return sysDictDAO.selectList(condition);
    }

    @Override
    public void checkFirstKey(String key) {
        if (StringUtils.isBlank(key)) {
            throw new BizException("xn000000", "key不能为空");
        }
        SYSDict condition = new SYSDict();
        condition.setDkey(key);
        condition.setType(EDictType.FIRST.getCode());
        if (getTotalCount(condition) > 0) {
            throw new BizException("xn000000", "第一层key不能为重复");
        }
    }

    @Override
    public void checkSecondKey(String parentKey, String key) {
        if (StringUtils.isBlank(parentKey)) {
            throw new BizException("xn000000", "parentKey不能为空");
        }
        if (StringUtils.isBlank(key)) {
            throw new BizException("xn000000", "key不能为空");
        }
        SYSDict condition = new SYSDict();
        condition.setParentKey(parentKey);
        condition.setDkey(key);
        condition.setType(EDictType.SECOND.getCode());
        if (getTotalCount(condition) > 0) {
            throw new BizException("xn000000", "当前<" + parentKey
                    + ">节点下，key不能为重复");
        }
    }

}
