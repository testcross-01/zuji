package top.testcross.zuji.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import top.testcross.zuji.bean.interfaces.ActionDataBean;
import top.testcross.zuji.bean.interfaces.DataBean;
import top.testcross.zuji.bean.UimFollow;
import top.testcross.zuji.bean.UimFollowExample;
import top.testcross.zuji.mapper.UimFollowMapper;
import top.testcross.zuji.service.IUimFollowService;
import top.testcross.zuji.util.DaoUtil;

import java.util.List;


@Service
public class UimFollowServiceImpl extends ActionServiceAbstract implements IUimFollowService {
    @Autowired
    UimFollowMapper uimFollowMapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
    public int save(DataBean dataBean) throws Exception{
        return saveAndCreateMessage((ActionDataBean)dataBean);
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

    @Override
    public int deleteByUserIdAndFollowUserId(String userId, String followUserId) throws Exception {
        DataBean dataBean=selectByUserIdAndFollowUserId(userId,followUserId);
        return deleteAndCreateMessage((ActionDataBean)dataBean);
    }

    @Override
    public DataBean selectByUserIdAndFollowUserId(String userId, String followUserId) throws Exception {
        UimFollowExample example=new UimFollowExample();
        example.createCriteria().andUserIdEqualTo(userId).andFollowUserIdEqualTo(followUserId);
        List<? extends DataBean> dataBeans=DaoUtil.selectByExample(uimFollowMapper,example);

        if(dataBeans.size()==0)return new UimFollow();
        return dataBeans.get(0);
    }

    @Override
    public int saveAndCreateMessage(ActionDataBean actionDataBean) throws Exception {
        if(actionDataBean==null||DaoUtil.insert(uimFollowMapper,actionDataBean)==0||createAndSaveMessage(actionDataBean,1)==0)
            throw new Exception("关注保存时出错");
        return 1;
    }

    @Override
    public int deleteAndCreateMessage(ActionDataBean actionDataBean) throws Exception {
        if(actionDataBean==null||DaoUtil.deleteByID(uimFollowMapper,actionDataBean.getUUID())==0||createAndSaveMessage(actionDataBean,0)==0)
            throw new Exception("取注保存时出错");
        return 1;
    }
}
