package top.testcross.zuji.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.testcross.zuji.bean.interfaces.DataBean;
import top.testcross.zuji.mapper.BmTagMapper;
import top.testcross.zuji.service.IBmTagService;
import top.testcross.zuji.util.DaoUtil;

@Service
public class BmTagServiceImpl implements IBmTagService {
    @Autowired
    BmTagMapper tagMapper;

    @Override
    public int save(DataBean dataBean) {
        return DaoUtil.insert(tagMapper,dataBean);
    }

    @Override
    public int deleteByID(String id) {
        return DaoUtil.deleteByID(tagMapper,id);
    }

    @Override
    public int modifyByID(DataBean dataBean) {
        return DaoUtil.updateByID(tagMapper,dataBean);
    }

    @Override
    public DataBean findByID(String id) {
        return DaoUtil.selectByID(tagMapper,id);
    }
}
