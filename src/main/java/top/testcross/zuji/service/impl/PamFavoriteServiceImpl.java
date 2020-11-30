package top.testcross.zuji.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import top.testcross.zuji.bean.*;
import top.testcross.zuji.bean.interfaces.ActionDataBean;
import top.testcross.zuji.bean.interfaces.DataBean;
import top.testcross.zuji.mapper.BmGeoPlaceinfoMapper;
import top.testcross.zuji.mapper.PamFavoriteMapper;
import top.testcross.zuji.mapper.PmPostMapper;
import top.testcross.zuji.service.IPamFavoriteService;
import top.testcross.zuji.util.DaoUtil;

import java.util.LinkedList;
import java.util.List;

@Service
public class PamFavoriteServiceImpl extends ActionServiceAbstract implements IPamFavoriteService {
    @Autowired
    PamFavoriteMapper pamFavoriteMapper;

    @Autowired
    PmPostMapper pmPostMapper;

    @Autowired
    BmGeoPlaceinfoMapper bmGeoPlaceinfoMapper;

    @Override
    public int countActionByUser(String id) {
        PamFavoriteExample example=new PamFavoriteExample();
        PamFavoriteExample.Criteria criteria= example.createCriteria();
        criteria.andUserIdEqualTo(id);
        return pamFavoriteMapper.countByExample(example);
    }

    @Override
    public int countActionByPost(String id) {
        PamFavoriteExample example=new PamFavoriteExample();
        PamFavoriteExample.Criteria criteria= example.createCriteria();
        criteria.andPostIdEqualTo(id);
        return pamFavoriteMapper.countByExample(example);
    }

    @Override
    public int countActionByOtherUser(String id) {
        //查询用户对应的所有动态
        PmPostExample postExample=new PmPostExample();
        postExample.createCriteria().andUserIdEqualTo(id);
        List<PmPost> posts=(List<PmPost>) DaoUtil.selectByExample(pmPostMapper,postExample);

        //计算所有动态的收藏总和
        int count=0;
        for(PmPost post:posts){
            count+=post.getPostFavCount();
        }
        return count;
    }

    @Override
    public DataBean selectByUserIdAndPostId(String userId, String postId){
        PamFavoriteExample example=new PamFavoriteExample();
        example.createCriteria().andUserIdEqualTo(userId).andPostIdEqualTo(postId);
        List<? extends DataBean>dataBeans=DaoUtil.selectByExample(pamFavoriteMapper,example);
        if(dataBeans.size()==0)return new PamFavorite();

        return dataBeans.get(0);
    }

    @Override
    public int deleteByUserIdAndPostId(String userId, String postId) {
        DataBean dataBean=selectByUserIdAndPostId(userId,postId);
        return deleteAndCreateMessage((ActionDataBean) dataBean);
    }

    @Override
    public int saveAndCreateMessage(ActionDataBean actionDataBean){
        DaoUtil.insert(pamFavoriteMapper,actionDataBean);
        createAndSaveMessage(actionDataBean,1);
        return 1;
    }

    @Override
    public int deleteAndCreateMessage(ActionDataBean actionDataBean){
        DaoUtil.deleteByID(pamFavoriteMapper,actionDataBean.getUUID());
        createAndSaveMessage(actionDataBean,0);

        return 1;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
    public int save(DataBean dataBean){
        return saveAndCreateMessage((ActionDataBean)dataBean);
    }

    @Override
    public int deleteByID(String id) {
        return DaoUtil.deleteByID(pamFavoriteMapper,id);
    }

    @Override
    public int modifyByID(DataBean dataBean) {
        return DaoUtil.updateByID(pamFavoriteMapper,dataBean);
    }

    @Override
    public DataBean findByID(String id) {
        return DaoUtil.selectByID(pamFavoriteMapper,id);
    }


    @Override
    public List<? extends DataBean> findFavoritePlaceByUser(String id) {
        //通过用户id搜索所有收藏记录
        PamFavoriteExample favoriteExample=new PamFavoriteExample();
        favoriteExample.createCriteria().andUserIdEqualTo(id);
        List<PamFavorite> favorites=(List<PamFavorite>)DaoUtil.selectByExample(pamFavoriteMapper,favoriteExample);

        //构造pi_id集合
        List<String> pis=new LinkedList<String>();
        for(PamFavorite favorite:favorites){
            pis.add(favorite.getPiId());
        }

        //通过收藏记录中的pi_id搜索对应的地理信息
        BmGeoPlaceinfoExample geoPlaceinfoExample=new BmGeoPlaceinfoExample();
        geoPlaceinfoExample.createCriteria().andPiIdIn(pis);
        return DaoUtil.selectByExample(bmGeoPlaceinfoMapper,geoPlaceinfoExample);
    }
}
