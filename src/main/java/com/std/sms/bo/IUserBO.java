/**
 * @Title IUserBO.java 
 * @Package com.std.sms.bo 
 * @Description 
 * @author xieyj  
 * @date 2016年11月30日 下午10:57:39 
 * @version V1.0   
 */
package com.std.sms.bo;

/** 
 * @author: xieyj 
 * @since: 2016年11月30日 下午10:57:39 
 * @history:
 */
public interface IUserBO {
    /**
     * 代注册
     * @param loginName
     * @param updater
     * @return 
     * @create: 2016年12月1日 下午1:16:38 xieyj
     * @history:
     */
    public String addUser(String loginName, String updater);

    /**
     * 注销
     * @param userId
     * @param updater
     * @return 
     * @create: 2016年12月1日 下午1:16:32 xieyj
     * @history:
     */
    public void logoutUser(String userId, String updater);
}
