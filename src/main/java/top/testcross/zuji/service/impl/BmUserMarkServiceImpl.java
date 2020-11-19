package top.testcross.zuji.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationImportSelector;
import top.testcross.zuji.bean.*;
import top.testcross.zuji.bean.interfaces.DataBean;
import top.testcross.zuji.mapper.BmTagMapper;
import top.testcross.zuji.mapper.BmUserMarkMapper;
import top.testcross.zuji.mapper.UimUserMapper;
import top.testcross.zuji.service.IBmUserMarkService;
import top.testcross.zuji.util.DaoUtil;

import java.util.LinkedList;
import java.util.List;

public class BmUserMarkServiceImpl implements IBmUserMarkService {
    @Autowired
    BmUserMarkMapper bmUserMarkMapper;

    @Autowired
    UimUserMapper userMapper;

    @Autowired
    BmTagMapper tagMapper;

    @Override
    public int save(DataBean dataBean) {
        return DaoUtil.insert(bmUserMarkMapper,dataBean);
    }

    @Override
    public int deleteByID(String id) {
        return DaoUtil.deleteByID(bmUserMarkMapper,id);
    }

    @Override
    public int modifyByID(DataBean dataBean) {
        return DaoUtil.updateByID(bmUserMarkMapper,dataBean);
    }

    @Override
    public DataBean findByID(String id) {
        return DaoUtil.selectByID(bmUserMarkMapper,id);
    }

    @Override
    public List<? extends DataBean> findTagByUser(String userId) {
        //根据用户查询到所有标识记录
        BmUserMarkExample userMarkExample=new BmUserMarkExample();
        userMarkExample.createCriteria().andUserIdEqualTo(userId);
        List<BmUserMark> marks= (List<BmUserMark>)DaoUtil.selectByExample(bmUserMarkMapper,userMarkExample);

        //构造tag id集合
        List<String > tagIds=new LinkedList<>();
        for(BmUserMark mark:marks){
            tagIds.add(mark.getTagId());
        }

        //根据tag id查询所有的标签
        BmTagExample tagExample=new BmTagExample();
        tagExample.createCriteria().andTagIdIn(tagIds);
        return DaoUtil.selectByExample(tagMapper,tagExample);
    }

    @Override
    public List<? extends DataBean> findUserByTag(String tagId) {
        //根据标签查询到所有标识记录
        BmUserMarkExample userMarkExample=new BmUserMarkExample();
        userMarkExample.createCriteria().andTagIdEqualTo(tagId);
        List<BmUserMark> marks=(List<BmUserMark>)DaoUtil.selectByExample(bmUserMarkMapper,userMarkExample);;

        //构造 use id集合
        List<String> userIds=new LinkedList<>();
        for(BmUserMark mark:marks){
            userIds.add(mark.getUserId());
        }

        //根据usr id集合查询所有的用户
        UimUserExample userExample=new UimUserExample();
        userExample.createCriteria().andUserIdIn(userIds);
        return DaoUtil.selectByExample(userMapper,userExample);
    }
}
