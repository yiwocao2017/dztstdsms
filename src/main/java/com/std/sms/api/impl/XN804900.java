/**
 * @Title XNlh5010.java 
 * @Package com.xnjr.moom.api.impl 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年4月17日 下午5:00:02 
 * @version V1.0   
 */
package com.std.sms.api.impl;

import com.std.sms.ao.ISYSDictAO;
import com.std.sms.api.AProcessor;
import com.std.sms.common.JsonUtil;
import com.std.sms.core.StringValidater;
import com.std.sms.dto.req.XN804900Req;
import com.std.sms.dto.res.PKIdRes;
import com.std.sms.exception.BizException;
import com.std.sms.exception.ParaException;
import com.std.sms.spring.SpringContextHolder;

/** 
 * 新增数据字典
 * @author: haiqingzheng 
 * @since: 2016年4月17日 下午5:00:02 
 * @history:
 */
public class XN804900 extends AProcessor {
    private ISYSDictAO sysDictAO = SpringContextHolder
        .getBean(ISYSDictAO.class);

    private XN804900Req req = null;

    /** 
     * @see com.xnjr.mall.api.IProcessor#doBusiness()
     */
    @Override
    public Object doBusiness() throws BizException {
        Long id = sysDictAO.addSYSDict(req.getType(), req.getParentKey(),
            req.getDkey(), req.getDvalue(), req.getRemark());
        return new PKIdRes(id);
    }

    /** 
     * @see com.xnjr.mall.api.IProcessor#doCheck(java.lang.String)
     */
    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN804900Req.class);
        StringValidater.validateBlank(req.getType(), req.getDkey(),
            req.getDvalue());
    }
}
