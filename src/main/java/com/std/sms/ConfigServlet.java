package com.std.sms;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import com.std.sms.ao.ISystemChannelAO;
import com.std.sms.common.PropertiesUtil;
import com.std.sms.spring.SpringContextHolder;

public class ConfigServlet extends HttpServlet {
    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = -7810670972793349913L;

    private ISystemChannelAO systemChannelAO = SpringContextHolder
        .getBean(ISystemChannelAO.class);

    @Override
    public void init() throws ServletException {
        super.init();
        PropertiesUtil.init("/config.properties");
        // systemChannelAO.doAccessTokenDaily();
    }

}
