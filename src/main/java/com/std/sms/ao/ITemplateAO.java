package com.std.sms.ao;

import com.std.sms.sent.wechat.Template;

public interface ITemplateAO {
    public Template getTemplate(String systemCode);
}
