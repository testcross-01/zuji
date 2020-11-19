package top.testcross.zuji.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.testcross.zuji.bean.interfaces.DataBean;
import top.testcross.zuji.mapper.UimUserMapper;
import top.testcross.zuji.service.IUimUserService;
import top.testcross.zuji.util.DaoUtil;

@Service
public class UimUserServiceImpl implements IUimUserService {
    @Autowired
    UimUserMapper uimUserMapper;

    @Override
    public int save(DataBean dataBean) {
        return DaoUtil.insert(uimUserMapper,dataBean);
    }

    @Override
    public int deleteByID(String id) {
        return DaoUtil.deleteByID(uimUserMapper,id);
    }

    @Override
    public int modifyByID(DataBean dataBean) {
        return DaoUtil.updateByID(uimUserMapper,dataBean);
    }

    @Override
    public DataBean findByID(String id) {
        return DaoUtil.selectByID(uimUserMapper,id);
    }
}
