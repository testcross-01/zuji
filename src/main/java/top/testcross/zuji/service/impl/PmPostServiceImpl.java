package top.testcross.zuji.service.impl;

import com.sun.javaws.exceptions.BadMimeTypeResponseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import top.testcross.zuji.bean.*;
import top.testcross.zuji.bean.interfaces.ActionDataBean;
import top.testcross.zuji.bean.interfaces.DataBean;
import top.testcross.zuji.mapper.*;
import top.testcross.zuji.service.IPmPostService;
import top.testcross.zuji.util.DaoUtil;

import javax.print.DocFlavor;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

@Service
public class PmPostServiceImpl extends ActionServiceAbstract implements IPmPostService {
    @Autowired
    PmPostMapper pmPostMapper;

    @Autowired
    BmPostMarkMapper postMarkMapper;

    @Autowired
    BmTagMapper bmTagMapper;

    @Autowired
    BmImgMapper imgMapper;

    @Autowired
    BmGeoPlaceinfoMapper placeinfoMapper;

    @Autowired
    PamFavoriteMapper favoriteMapper;

    @Autowired
    PamLikeMapper likeMapper;




    @Override
    public List<? extends DataBean> findPostByUserIdOrderByCreateTime(String id) {
        PmPostExample example=new PmPostExample();
        example.createCriteria().andUserIdEqualTo(id);

        //根据时间排序
        example.setOrderByClause("post_create_time asc");
        return DaoUtil.selectByExample(pmPostMapper,example);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
    public int save(DataBean dataBean) throws Exception{
        return saveAndCreateMessage((ActionDataBean) dataBean);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
    public int deleteByID(String id) throws Exception{
        PmPost post=(PmPost) findByID(id);
        return deleteAndCreateMessage((ActionDataBean)post);
    }

    @Override
    public int modifyByID(DataBean dataBean) {
        return DaoUtil.updateByID(pmPostMapper,dataBean);
    }

    @Override
    public DataBean findByID(String id) {
        return DaoUtil.selectByID(pmPostMapper,id);
    }


    @Override
    public List<? extends DataBean> findPostInIds(List<String> ids,String userId) {
        if(ids.size()<=0)return new LinkedList<>();

        //根据id查询所有对应动态
        PmPostExample pmPostExample=new PmPostExample();
        pmPostExample.createCriteria().andPostIdIn(ids);
        List<PmPost> posts=(List<PmPost>) DaoUtil.selectByExample(pmPostMapper,pmPostExample);

        //构建post map对象
        HashMap<String,PmPost> idToPosts=new HashMap<>();
        for (PmPost post:posts){
            idToPosts.put(post.getPostId(),post);
        }

        //给图片添加图片和标签
        addImgsToPosts(ids,idToPosts);
        addTagsToPosts(ids,idToPosts);
        addPIToPosts(ids,idToPosts);
        addCpImgToPosts(ids,idToPosts);

        return posts;
    }

    @Override
    public List<? extends DataBean> findPartPostInIds(List<String> ids) {
        if(ids.size()<=0)return new LinkedList<>();

        //根据id查询所有对应动态
        PmPostExample pmPostExample=new PmPostExample();
        pmPostExample.createCriteria().andPostIdIn(ids);
        List<PmPost> posts=(List<PmPost>) DaoUtil.selectByExample(pmPostMapper,pmPostExample);

        //构建post map对象
        HashMap<String,PmPost> idToPosts=new HashMap<>();
        for (PmPost post:posts){
            idToPosts.put(post.getPostId(),post);
        }

        addCpImgToPosts(ids,idToPosts);
        addPIToPosts(ids,idToPosts);
        return posts;
    }

    @Override
    public int countPostByUser(String userID) {
        PmPostExample example=new PmPostExample();
        example.createCriteria().andUserIdEqualTo(userID);
        return pmPostMapper.countByExample(example);
    }

    /**
     * 为动态添加封面图片
     * @param postIds
     * @param postMap
     */
    private void addCpImgToPosts(List<String> postIds,HashMap<String,PmPost> postMap){
        //根据动态信息获得cpimg集合
        List<String> imgIds=new LinkedList<>();
        for(PmPost post:postMap.values()){
            imgIds.add(post.getPostCpImgId());
        }

        //根据图片查询获得所有img
        BmImgExample imgExample=new BmImgExample();
        imgExample.createCriteria().andImgIdIn(imgIds);
        List<BmImg> imgs=(List<BmImg>) DaoUtil.selectByExample(imgMapper,imgExample);

        //将首页图片放入动态中
        for(BmImg img:imgs){
            PmPost post=postMap.get(img.getImgSrcId());
            post.setCpImg(img);
        }
    }


    /**
     * 向动态中添加标签
     * @param postIds
     * @param postMap
     */
    private void addTagsToPosts(List<String> postIds,HashMap<String,PmPost> postMap){
        if(postIds.size()==0)return;

        //根据动态id查询出所有的mark记录
        BmPostMarkExample postMarkExample=new BmPostMarkExample();
        postMarkExample.createCriteria().andPostIdIn(postIds);
        List<BmPostMark> marks=(List<BmPostMark>)DaoUtil.selectByExample(postMarkMapper,postMarkExample);

        //建立tagid集合
        List<String> tagIds=new LinkedList<>();
        for(BmPostMark mark:marks){
            tagIds.add(mark.getTagId());
        }

        //根据tagid查询tag集合
        BmTagExample bmTagExample=new BmTagExample();
        bmTagExample.createCriteria().andTagIdIn(tagIds);
        List<BmTag> tags=(List<BmTag>) DaoUtil.selectByExample(bmTagMapper,bmTagExample);



        //建立tag map
        HashMap<String,BmTag> tagMap=new HashMap<>();
        for(BmTag tag:tags){
            tagMap.put(tag.getTagId(),tag);
        }

        //向动态中添加tag
        for(BmPostMark mark:marks){
            PmPost post=postMap.get(mark.getPostId());
            BmTag tag=tagMap.get(mark.getTagId());
            if(post.getTags()==null){
                post.setTags(new LinkedList<>());
            }
            post.getTags().add(tag);
        }
    }

    /**
     * 向动态中添加图片
     * @param postIds
     * @param postMap
     */
    private void addImgsToPosts(List<String> postIds,HashMap<String,PmPost> postMap){
        if(postIds.size()<=0)return;

        //根据动态id搜索所有图片
        BmImgExample imgExample=new BmImgExample();
        imgExample.createCriteria().andImgSrcTypeEqualTo((byte) 1).andImgSrcIdIn(postIds);
        List<BmImg> imgs=(List<BmImg>)DaoUtil.selectByExample(imgMapper,imgExample);

        //讲图片加入到动态中
        for(BmImg img:imgs){
            PmPost post=postMap.get(img.getImgSrcId());
            if(post.getImgs()==null){
                post.setImgs(new LinkedList<>());
            }
            post.getImgs().add(img);
        }
    }

    /**
     * 向动态添加地址信息
     * @param postIds
     * @param postMap
     */
    private void addPIToPosts(List<String> postIds,HashMap<String,PmPost> postMap){
        //根据动态信息获得pi集合
        List<String> piIds=new LinkedList<>();
        for(PmPost post:postMap.values()){
            piIds.add(post.getPiId());
        }

        //查询出所有地址信息
        BmGeoPlaceinfoExample placeinfoExample=new BmGeoPlaceinfoExample();
        placeinfoExample.createCriteria().andPiIdIn(piIds);
        List<BmGeoPlaceinfo> placeinfos=(List<BmGeoPlaceinfo>) DaoUtil.selectByExample(placeinfoMapper,placeinfoExample);


        //构建pi map
        HashMap<String,BmGeoPlaceinfo> placeinfoHashMap=new HashMap<>();
        for(BmGeoPlaceinfo placeinfo:placeinfos){
            placeinfoHashMap.put(placeinfo.getPiId(),placeinfo);
        }


        //将地址信息加到动态中
        for(PmPost post:postMap.values()){
            BmGeoPlaceinfo placeinfo=placeinfoHashMap.get(post.getPiId());
            post.setPlaceinfo(placeinfo);
        }

    }


    /**
     * 向动态中添加当前用户喜爱id
     * @param postIds
     * @param userId
     * @param postMap
     */
    private void addLikeIdToPosts(List<String> postIds,String userId,HashMap<String,PmPost> postMap) {
        //搜索本人所有的like记录
        PamLikeExample example=new PamLikeExample();
        example.createCriteria().andUserIdEqualTo(userId);
        List<PamLike> likes=(List<PamLike>) DaoUtil.selectByExample(likeMapper,example);

        //遍历记录将id放到对应的动态中
        for(PamLike like:likes){
            PmPost post=postMap.get(like.getPostId());
            if(post!=null){
                post.setLikeId(like.getLikeId());
            }
        }

    }

    /**
     * 向动态中添加当前用户收藏id
     * @param postIds
     * @param userId
     * @param postMap
     */
    private void addFavIdToPosts(List<String> postIds,String userId,HashMap<String,PmPost> postMap){
        //搜索本人所有的fav记录
        PamFavoriteExample example=new PamFavoriteExample();
        example.createCriteria().andUserIdEqualTo(userId);
        List<PamFavorite> favorites=(List<PamFavorite>) DaoUtil.selectByExample(favoriteMapper,example);

        //遍历记录将id放到对应的动态中
        for(PamFavorite favorite:favorites){
            PmPost post=postMap.get(favorite.getPostId());
            if(post!=null){
                post.setLikeId(favorite.getFavId());
            }
        }
    }


    @Override
    public int saveAndCreateMessage(ActionDataBean actionDataBean) throws Exception {
        if(DaoUtil.insert(pmPostMapper,actionDataBean)==0||createAndSaveMessage(actionDataBean,1)==0)
            throw new Exception("创建动态失败");
        return 1;
    }

    @Override
    public int deleteAndCreateMessage(ActionDataBean actionDataBean) throws Exception {
        if(DaoUtil.deleteByID(pmPostMapper,actionDataBean.getUUID())==0||createAndSaveMessage(actionDataBean,0)==0)
            throw new Exception("删除动态失败");
        return 1;
    }
}
