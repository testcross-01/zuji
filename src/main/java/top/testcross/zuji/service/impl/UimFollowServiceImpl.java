package top.testcross.zuji.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.testcross.zuji.bean.interfaces.DataBean;
import top.testcross.zuji.bean.UimFollow;
import top.testcross.zuji.bean.UimFollowExample;
import top.testcross.zuji.mapper.UimFollowMapper;
import top.testcross.zuji.service.IUimFollowService;
import top.testcross.zuji.util.DaoUtil;


@Service
public class UimFollowServiceImpl implements IUimFollowService {
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
        UimFollow uimFollow=(UimFollow) dataBean;
        return uimFollowMapper.updateByPrimaryKey(uimFollow);
    }

    @Override
    public DataBean findByID(String id) {
        return uimFollowMapper.selectByPrimaryKey(id);
    }


    @Override
    public int countFollowersByUser(String userId) {
        UimFollowExample example=new UimFollowExample();
        UimFollowExample.Criteria criteria= example.createCriteria();
        criteria.andFollowUserIdEqualTo(userId);
        return uimFollowMapper.countByExample(example);
    }

    @Override
    public int countFollowByUser(String userId) {
        UimFollowExample example=new UimFollowExample();
        UimFollowExample.Criteria criteria= example.createCriteria();
        criteria.andUserIdEqualTo(userId);
        return uimFollowMapper.countByExample(example);
    }
}
