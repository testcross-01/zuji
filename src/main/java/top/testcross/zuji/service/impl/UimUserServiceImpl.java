package top.testcross.zuji.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.testcross.zuji.bean.interfaces.DataBean;
import top.testcross.zuji.mapper.UimFollowMapper;
import top.testcross.zuji.service.IUimUserService;
import top.testcross.zuji.util.DaoUtil;

@Service
public class UimUserServiceImpl implements IUimUserService {
    @Autowired
    UimFollowMapper uimFollowMapper;

    @Override
    public int save(DataBean dataBean) {
        return DaoUtil.insert(uimFollowMapper,dataBean);
    }

    @Override
    public int deleteByID(String id) {
        return DaoUtil.deleteByID(uimFollowMapper,id);
    }

    @Override
    public int modifyByID(DataBean dataBean) {
        return DaoUtil.updateByID(uimFollowMapper,dataBean);
    }

    @Override
    public DataBean findByID(String id) {
        return DaoUtil.selectByID(uimFollowMapper,id);
    }
}
