/**
 * @Title UserBOImpl.java 
 * @Package com.std.sms.bo.impl 
 * @Description 
 * @author xieyj  
 * @date 2016年11月30日 下午11:01:05 
 * @version V1.0   
 */
package com.std.sms.bo.impl;

import org.springframework.stereotype.Component;

import com.std.sms.bo.IUserBO;
import com.std.sms.common.PropertiesUtil;
import com.std.sms.dto.req.XN805042Req;
import com.std.sms.dto.req.XN805052Req;
import com.std.sms.dto.res.XN805042Res;
import com.std.sms.exception.BizException;
import com.std.sms.http.BizConnecter;
import com.std.sms.http.JsonUtils;

/** 
 * @author: xieyj 
 * @since: 2016年11月30日 下午11:01:05 
 * @history:
 */
@Component
public class UserBOImpl implements IUserBO {

    @Override
    public String addUser(String loginName, String updater) {
        XN805042Req req = new XN805042Req();
        req.setLoginName(loginName);
        req.setRoleCode(PropertiesUtil.Config.BJ_ROLE_CODE);
        req.setKind("01");
        req.setUpdater(updater);
        XN805042Res res = BizConnecter.getBizData("805042",
            JsonUtils.object2Json(req), XN805042Res.class);
        if (res == null) {
            throw new BizException("XN000000", "办件员注册失败");
        }
        return res.getUserId();
    }

    /** 
     * @see com.std.sms.bo.IUserBO#logoutUser(java.lang.String,  java.lang.String)
     */
    @Override
    public void logoutUser(String userId, String updater) {
        XN805052Req req = new XN805052Req();
        req.setUserId(userId);
        req.setToStatus("2");
        req.setUpdater(updater);
        req.setRemark("办件员已删除");
        BizConnecter.getBizData("805052", JsonUtils.object2Json(req),
            Object.class);
    }
}
