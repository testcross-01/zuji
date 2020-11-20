package top.testcross.zuji.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import top.testcross.zuji.bean.PamLikeExample;
import top.testcross.zuji.bean.PmPost;
import top.testcross.zuji.bean.PmPostExample;
import top.testcross.zuji.bean.interfaces.ActionDataBean;
import top.testcross.zuji.bean.interfaces.DataBean;
import top.testcross.zuji.mapper.PamLikeMapper;
import top.testcross.zuji.mapper.PmPostMapper;
import top.testcross.zuji.service.IPamLikeService;
import top.testcross.zuji.util.DaoUtil;

import java.util.List;

@Service
public class PamLikeServiceImpl extends ActionServiceAbstract implements IPamLikeService  {

    @Autowired
    PamLikeMapper pamLikeMapper;

    @Autowired
    PmPostMapper pmPostMapper;

    @Override
    public int countActionByUser(String id) {
        PamLikeExample example=new PamLikeExample();
        PamLikeExample.Criteria criteria= example.createCriteria();
        criteria.andUserIdEqualTo(id);
        return pamLikeMapper.countByExample(example);
    }

    @Override
    public int countActionByPost(String id) {
        PamLikeExample example=new PamLikeExample();
        PamLikeExample.Criteria criteria=example.createCriteria();
        criteria.andPostIdEqualTo(id);
        return pamLikeMapper.countByExample(example);
    }

    @Override
    public int countActionByOtherUser(String id) {
        PmPostExample postExample=new PmPostExample();
        postExample.createCriteria().andUserIdEqualTo(id);
        List<PmPost> posts=(List<PmPost>) DaoUtil.selectByExample(pmPostMapper,postExample);
        int count=0;
        for(PmPost post:posts){
            count+=post.getPostLikeCount();
        }
        return count;
    }

    @Override
    public int saveAndCreateMessage(ActionDataBean actionDataBean) throws Exception {
        if(DaoUtil.insert(pamLikeMapper,actionDataBean)==0||createAndSaveMessage(actionDataBean,1)==0)
            throw new Exception("点赞失败");
        return 1;
    }

    @Override
    public int deleteAndCreateMessage(ActionDataBean actionDataBean) throws Exception {
        if(DaoUtil.deleteByID(pamLikeMapper,actionDataBean.getUUID())==0||createAndSaveMessage(actionDataBean,0)==0)
            throw new Exception("取消点赞失败");
        return 1;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
    public int save(DataBean dataBean) throws Exception{
        return saveAndCreateMessage((ActionDataBean)dataBean);
    }

    @Override
    public int deleteByID(String id) {
        return DaoUtil.deleteByID(pamLikeMapper,id);
    }

    @Override
    public int modifyByID(DataBean dataBean) {
        return DaoUtil.updateByID(pamLikeMapper,dataBean);
    }

    @Override
    public DataBean findByID(String id) {
        return DaoUtil.selectByID(pamLikeMapper,id);
    }
}
