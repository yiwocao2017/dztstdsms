/**
 * @Title ISYSDictAO.java 
 * @Package com.xnjr.moom.ao 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年4月17日 下午5:12:19 
 * @version V1.0   
 */
package com.std.sms.ao;

import java.util.List;

import com.std.sms.bo.base.Paginable;
import com.std.sms.domain.SYSDict;

/** 
 * @author: haiqingzheng 
 * @since: 2016年4月17日 下午5:12:19 
 * @history:
 */
public interface ISYSDictAO {
    static String DEFAULT_ORDER_COLUMN = "id";

    public Long addSYSDict(String type, String parentKey, String key,
            String value, String remark);

    public void dropSYSDict(Long id);

    public void editSYSDict(Long id, String value, String remark);

    public Paginable<SYSDict> querySYSDictPage(int start, int limit,
            SYSDict condition);

    public List<SYSDict> querySysDictList(SYSDict condition);

    public SYSDict getSYSDict(Long id);
}
