package com.std.sms.bo;

import java.util.List;

import com.std.sms.bo.base.IPaginableBO;
import com.std.sms.domain.Sms;

public interface ISmsBO extends IPaginableBO<Sms> {

    public boolean isSmsExist(Long id);

    public String saveSms(Sms data);

    public int removeSms(Long id);

    public int refreshSms(Sms data);

    public int refreshSmsStatus(Long id, String status, String updater);

    public List<Sms> querySmsList(Sms condition);

    public Sms getSms(Long id);
}
