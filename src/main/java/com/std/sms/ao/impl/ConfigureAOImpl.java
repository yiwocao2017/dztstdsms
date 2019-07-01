package com.std.sms.ao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.std.sms.ao.IConfigureAO;
import com.std.sms.bo.IConfigureBO;

@Service
public class ConfigureAOImpl implements IConfigureAO {

    @Autowired
    private IConfigureBO configureBO;
}
