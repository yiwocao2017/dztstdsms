/**
 * @Title ISYSDictBO.java 
 * @Package com.xnjr.moom.bo 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年4月17日 下午2:40:19 
 * @version V1.0   
 */
package com.std.sms.bo;

import java.util.List;

import com.std.sms.bo.base.IPaginableBO;
import com.std.sms.domain.SYSDict;

/** 
 * @author: haiqingzheng 
 * @since: 2016年4月17日 下午2:40:19 
 * @history:
 */
public interface ISYSDictBO extends IPaginableBO<SYSDict> {

    public Long saveSYSDict(String type, String parentKey, String key,
            String value, String remark);

    public void removeSYSDict(Long id);

    public void refreshSYSDict(Long id, String value, String remark);

    public List<SYSDict> querySYSDictList(SYSDict condition);

    public SYSDict getSYSDict(Long id);

    /**
     * 在所有的第一层数据字典里查找是否存在同样的key
     * @param key 
     * @create: 2017年3月6日 下午5:17:20 myb858
     * @history:
     */
    public void checkFirstKey(String key);

    /**
     * 在同样parentKey的第二层数据字典里查找是否存在同样的key
     * @param parentKey
     * @param key 
     * @create: 2017年3月6日 下午5:18:32 myb858
     * @history:
     */
    public void checkSecondKey(String parentKey, String key);

}
