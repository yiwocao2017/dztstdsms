package com.std.sms.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.std.sms.dao.ISCaptchaDAO;
import com.std.sms.dao.base.support.AMybatisTemplate;
import com.std.sms.domain.SCaptcha;

@Repository("sCaptchaDAOImpl")
public class SCaptchaDAOImpl extends AMybatisTemplate implements ISCaptchaDAO {

    @Override
    public int insert(SCaptcha data) {
        return super.insert(NAMESPACE.concat("insert_sCaptcha"), data);
    }

    @Override
    public int delete(SCaptcha data) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public SCaptcha select(SCaptcha condition) {
        return super.select(NAMESPACE.concat("select_sCaptcha"), condition,
            SCaptcha.class);
    }

    @Override
    public long selectTotalCount(SCaptcha condition) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public List<SCaptcha> selectList(SCaptcha condition) {
        return super.selectList(NAMESPACE.concat("select_sCaptcha"), condition,
            SCaptcha.class);
    }

    @Override
    public List<SCaptcha> selectList(SCaptcha condition, int start, int count) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int updateCheckInfo(SCaptcha data) {
        return super.update(NAMESPACE.concat("update_sCaptcha"), data);
    }

}
