package com.std.sms.api.impl;

import com.std.sms.api.AProcessor;
import com.std.sms.exception.BizException;
import com.std.sms.exception.ParaException;

public class XNOther extends AProcessor {

    @Override
    public Object doBusiness() throws BizException {
        throw new BizException("799xxx", "无效API功能号");
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        throw new ParaException("799xxx", "无效API功能号");

    }

}
