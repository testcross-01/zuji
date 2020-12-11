package top.testcross.zuji;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import top.testcross.zuji.bean.*;
import top.testcross.zuji.bean.interfaces.DataBean;
import top.testcross.zuji.exception.DaoUtilException;
import top.testcross.zuji.mapper.*;
import top.testcross.zuji.handler.MessageHandler;
import top.testcross.zuji.service.*;
import top.testcross.zuji.util.DaoUtil;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan("top.testcross.zuji.mapper")
public class ServiceTest {
    @Autowired
    IPmPostService pmPostService;

    @Autowired
    IUimUserService uimUserService;

    @Autowired
    IPamLikeService likeService;

    @Autowired
    IPamFavoriteService favoriteService;

    @Autowired
    IPamCommentService commentService;

    @Autowired
    IBmImgService bmImgService;

    @Autowired
    IBmTagService bmTagService;

    @Autowired
    IBmPostMarkService postMarkService;

    @Autowired
    IBmUserMarkService userMarkService;

    @Autowired
    IBmGeoPlaceInfoService bmGeoPlaceInfoService;



//    @Autowired
//    IBmMessageHService messageHService;



    @Autowired
    PasswordEncoder passwordEncoder;

    @Test
    public void basicTest() throws Exception{
        String password=passwordEncoder.encode("123");

        UimUser user=new UimUser(null,0,0,(byte)0,0,"小漆","1",password," ",0,0,0,0,0);

        int result=uimUserService.save(user);

        PmPost post=new PmPost(null,0,0,0,2,"a",true,"","你好，世界！","429eba79ffdc494693cbba38ca4046fe","af18860f7d36476fbc1608eebb9770ce",new Date(System.currentTimeMillis()),null,null,null,null);

        //pmPostService.save(post);
    }

    @Test
    public void deletePost() throws Exception{
        pmPostService.deleteByID("3bb3f425bbb04a7e8a3adc5fe80c93d8");
    }

    @Test
    public void postAction() throws Exception{
        PamFavorite pamFavorite=new PamFavorite(null,"8502fa2ce96c414d8e338688d7fe754d","5bd70addaa824a7ca85def358e02e898","",new Date(System.currentTimeMillis()));
        PamComment comment=new PamComment(null,"你好","5bd70addaa824a7ca85def358e02e898",null,"8502fa2ce96c414d8e338688d7fe754d",(byte)1,"",new Date(System.currentTimeMillis()),null);
        PamLike like=new PamLike(null,"8502fa2ce96c414d8e338688d7fe754d","5bd70addaa824a7ca85def358e02e898",new Date(System.currentTimeMillis()));

        favoriteService.save(pamFavorite);
        commentService.save(comment);
        likeService.save(like);

    }

    @Test
    public void comments() throws Exception{
        String parentId="d44f9fdddf704a37895b68ce8c7c1e0a";
        PamComment comment=new PamComment(null,"我也是","5bd70addaa824a7ca85def358e02e898",parentId,"dfe40755e10446658cf822901e8b4e6f",(byte)1,"233",new Date(System.currentTimeMillis()),null);
        for(int i=0;i<10;i++)
        commentService.save(comment);
    }

    @Autowired
    IUimFollowService uimFollowService;

    @Test
    public void follow() throws Exception{
       UimFollow uimFollow=new UimFollow(null,"8502fa2ce96c414d8e338688d7fe754d","dfe40755e10446658cf822901e8b4e6f");
       uimFollowService.save(uimFollow);
    }

    @Test
    public void postAndComments() throws Exception{
       List<? extends DataBean> comments= commentService.findCommentsByPostID("5bd70addaa824a7ca85def358e02e898");
    }

    @Test
    public void partPosts() throws Exception{
        List<String> postIds=new LinkedList<>();
        postIds.add("ea58091dcfd44086bd3f1e211a287794");
        postIds.add("5bd70addaa824a7ca85def358e02e898");
        List<? extends DataBean> posts=pmPostService.findPartPostInIds(postIds);
    }

    @Test
    public void completePosts() throws Exception{
        List<String> postIds=new LinkedList<>();
        postIds.add("ea58091dcfd44086bd3f1e211a287794");
        postIds.add("5bd70addaa824a7ca85def358e02e898");
        List<? extends DataBean> posts=pmPostService.findPostInIds(postIds,null);
    }

    @Test
    public void addTagsAndImages() throws Exception{
        List<BmImg> imgs=new LinkedList<>();
        imgs.add(new BmImg(null,"5bd70addaa824a7ca85def358e02e898",(byte)1,"szx1.jpg",true));
        imgs.add(new BmImg(null,"5bd70addaa824a7ca85def358e02e898",(byte)1,"szx2.jpg",true));
        imgs.add(new BmImg(null,"5bd70addaa824a7ca85def358e02e898",(byte)1,"szx3.jpg",true));
        imgs.add(new BmImg(null,"5bd70addaa824a7ca85def358e02e898",(byte)2,"szx.jpg",true));

        bmImgService.saveImgs(imgs);


        List<BmTag> tags=new LinkedList<>();
        tags.add(new BmTag(null,"外出","出去玩",(byte)1));
        tags.add(new BmTag(null,"长沙","长沙",(byte)1));
        tags.add(new BmTag(null,"老八","吃屎",(byte)1));

        for(BmTag tag:tags){
            bmTagService.save(tag);
        }
    }

    @Test
    public void markPost() throws Exception{
        List<BmTag> tags=new LinkedList<>();
        tags.add(new BmTag(null,"蓝天","蓝天",(byte)1));
        tags.add(new BmTag(null,"白云","白云",(byte)1));
        tags.add(new BmTag(null,"世界","世界",(byte)1));

        for(BmTag tag:tags){
            bmTagService.save(tag);
        }

        List<BmPostMark> postMarks=new LinkedList<>();
        for(BmTag tag:tags){
            postMarkService.save( new BmPostMark(null,"5bd70addaa824a7ca85def358e02e898",tag.getTagId()));
        }
    }

    @Test
    public void markUser() throws Exception{
        List<BmTag> tags=new LinkedList<>();
        tags.add(new BmTag(null,"年轻人","耗子尾汁",(byte)1));
        tags.add(new BmTag(null,"长沙","长沙人",(byte)1));
        tags.add(new BmTag(null,"牛皮","牛皮",(byte)1));

        for(BmTag tag:tags){
            bmTagService.save(tag);
        }

        List<BmPostMark> postMarks=new LinkedList<>();
        for(BmTag tag:tags){
            userMarkService.save( new BmUserMark(null,"dfe40755e10446658cf822901e8b4e6f",tag.getTagId()));
        }
    }

    @Test
    public void geo() throws Exception{
        List<BmGeoPlaceinfo> placeinfos=new LinkedList<>();
        placeinfos.add(new BmGeoPlaceinfo(null,"中国湖南长沙月亮岛街道","长沙","中国","街道","月亮岛街道"));
        placeinfos.add(new BmGeoPlaceinfo(null,"中国湖南长沙青园街道","长沙","中国","街道","青园街道"));

        for(BmGeoPlaceinfo placeinfo:placeinfos){
            bmGeoPlaceInfoService.save(placeinfo);
        }
    }

    @Test
    public void user() throws Exception{
        List<? extends  DataBean> dataBeans= userMarkService.findTagByUser("dfe40755e10446658cf822901e8b4e6f");
    }


    @Autowired
    PamLikeMapper likeMapper;

    @Autowired
    PamCommentMapper commentMapper;

    @Autowired
    PamFavoriteMapper favoriteMapper;

    @Autowired
    IBmMessageService messageService;

    @Autowired
    MessageHandler messageHandler;

    @Test
    public void message() throws Exception{
//        List<BmMessage> bmMessages=new LinkedList<>();
//
//        List<ActionDataBean> actionDataBeans=new LinkedList<>();
//
//        List<PamLike> likes=(List<PamLike>) DaoUtil.selectByExample(likeMapper,new PamLikeExample());
//        List<PamComment> comments=(List<PamComment>) DaoUtil.selectByExample(commentMapper,new PamCommentExample());
//        List<PamFavorite> favorites=(List<PamFavorite>)DaoUtil.selectByExample(favoriteMapper,new PamFavoriteExample());
//        actionDataBeans.addAll(likes);
//        actionDataBeans.addAll(comments);
//        actionDataBeans.addAll(favorites);
//        for(ActionDataBean actionDataBean:actionDataBeans){
//            messageService.save(actionDataBean.createMessage());
//        }



        //messageService.dealMessages();
        messageHandler.dealMessages();

    }


    @Test
    public void undo() throws Exception{
        try{
            likeService.deleteByUserIdAndPostId("8502fa2ce96c414d8e338688d7fe754d","5bd70addaa824a7ca85def358e02e898");
        }catch (Exception ex){

        }

        favoriteService.deleteByUserIdAndPostId("8502fa2ce96c414d8e338688d7fe754d","5bd70addaa824a7ca85def358e02e898");
        commentService.deleteByID("27b35f4cc2a047e0a4448a62df48477e");


    }
    @Autowired
    PmPostMapper pmPostMapper;

    @Autowired
    BmGeoPlaceinfoMapper geoPlaceinfoMapper;

    @Test
    public void testSelectException(){
        //测试搜索时的异常

        //允许list为空或list的size为0

        //BadSQL异常
        try{
//            PmPostExample example=new PmPostExample();
//            example.createCriteria().andPostIdIn(new LinkedList<>());
//            DaoUtil.selectByExample(pmPostMapper,example);
              BmGeoPlaceinfoExample example=new BmGeoPlaceinfoExample();
              example.createCriteria().andPiIdIn(new LinkedList<>());
              System.out.println( geoPlaceinfoMapper.selectByExample(example));

        }catch (Exception ex){
            System.err.println("size为0---------------------------------------------------");
            System.err.println(ex);
        }

        //空指针异常
        try{
            PmPostExample example=new PmPostExample();
            example.createCriteria().andPostIdIn(null);
            DaoUtil.selectByExample(pmPostMapper,example);
            //pmPostMapper.selectByExample(example);
        }catch (Exception ex){
            System.err.println("集合为null------------------------------------------------------------------");
            System.err.println(ex);
        }

        //不报异常
        try{
            System.out.println( pmPostMapper.selectByPrimaryKey(null));
        }catch (Exception ex){
            System.err.println("PrimaryKey为null------------------------------------------------");
            System.err.println(ex);
        }

        //不报异常
        try{
            pmPostMapper.selectByPrimaryKey("122333");
        }catch (Exception ex){
            System.err.println("PrimaryKey不存在------------------------------------------------");
            System.err.println(ex);
        }

    }

    @Test
    public void testSaveException(){

        //DataIntegrityViolationException
        try{
            //pmPostMapper.insert(new PmPost());
            DaoUtil.insert(pmPostMapper,new PmPost());
        }catch (Exception ex){
            System.err.println("约束异常------------------------------------------------");
            System.err.println(ex);
        }

        //DataIntegrityViolationException
        try{
            System.out.println(pmPostMapper.insert(null));

        }catch (Exception ex){
            System.err.println("存储对象为空------------------------------------------------");
            System.err.println(ex);
        }

    }
    @Autowired
    UimFollowMapper followMapper;

    @Test
    public void testUpdateException(){

        //更新对象不存在 返回为0
        try{
            UimFollow follow=new UimFollow("321","123","123");

            //System.out.println(pmPostMapper.updateByPrimaryKey(post));
            DaoUtil.updateByID(followMapper,follow);

        }catch (Exception ex){
            System.err.println("更新对象不存在-----------------------------------------------");
            ex.printStackTrace();
        }


        //更新对象违反外键约束 DataIntegrityViolationException
        try{
            UimFollow follow=new UimFollow("d7370b0d2dd043c08de08f01c167f0b8","123","123");
            System.out.println(DaoUtil.updateByID(followMapper,follow));
        }catch (Exception ex){
            System.err.println("更新对象违反外键约束-----------------------------------------------");
            ex.printStackTrace();

        }

    }

    @Test
    public void throwException(){
        throw new DaoUtilException("错误",new RuntimeException());
    }


    @Autowired
    IPostRecommend postRecommend;

    @Test
    public void recommend(){
        postRecommend.recommendPostByScore(0,5);

    }

}
