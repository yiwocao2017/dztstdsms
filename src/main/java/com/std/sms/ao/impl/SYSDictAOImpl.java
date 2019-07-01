/**
 * @Title SYSDictAOImpl.java 
 * @Package com.xnjr.moom.ao.impl 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年4月17日 下午5:19:00 
 * @version V1.0   
 */
package com.std.sms.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.std.sms.ao.ISYSDictAO;
import com.std.sms.bo.ISYSDictBO;
import com.std.sms.bo.base.Paginable;
import com.std.sms.domain.SYSDict;
import com.std.sms.enums.EDictType;
import com.std.sms.exception.BizException;

/** 
 * @author: haiqingzheng 
 * @since: 2016年4月17日 下午5:19:00 
 * @history:
 */
@Service
public class SYSDictAOImpl implements ISYSDictAO {
    @Autowired
    ISYSDictBO sysDictBO;

    @Override
    public Long addSYSDict(String type, String parentKey, String key,
            String value, String remark) {
        if (EDictType.SECOND.getCode().equals(type)) {
            return addSecondSYSDict(type, parentKey, key, value, remark);
        } else if (EDictType.FIRST.getCode().equals(type)) {
            return addFirstSYSDict(type, parentKey, key, value, remark);
        } else {
            throw new BizException("xn000000", "type类型不在枚举类中 0-第一层 1-第二层");
        }

    }

    private Long addFirstSYSDict(String type, String parentKey, String key,
            String value, String remark) {
        // key不能重复
        sysDictBO.checkFirstKey(key);
        // 新增入库
        return sysDictBO.saveSYSDict(type, parentKey, key, value, remark);
    }

    private Long addSecondSYSDict(String type, String parentKey, String key,
            String value, String remark) {
        // 在当前父节点下key不能重复
        sysDictBO.checkSecondKey(parentKey, key);
        // 新增入库
        return sysDictBO.saveSYSDict(type, parentKey, key, value, remark);
    }

    @Override
    public void dropSYSDict(Long id) {
        sysDictBO.removeSYSDict(id);
    }

    @Override
    public void editSYSDict(Long id, String value, String remark) {
        sysDictBO.refreshSYSDict(id, value, remark);
    }

    @Override
    public Paginable<SYSDict> querySYSDictPage(int start, int limit,
            SYSDict condition) {
        return sysDictBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<SYSDict> querySysDictList(SYSDict condition) {
        return sysDictBO.querySYSDictList(condition);
    }

    @Override
    public SYSDict getSYSDict(Long id) {
        SYSDict sysDict = null;
        if (id != null) {
            SYSDict condition = new SYSDict();
            condition.setId(id);
            if (sysDictBO.getTotalCount(condition) <= 0) {
                throw new BizException("xn000000", "id记录不存在");
            }
            sysDict = sysDictBO.getSYSDict(id);
        }
        return sysDict;
    }
}
