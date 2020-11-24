package top.testcross.zuji.process;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import top.testcross.zuji.bean.*;
import top.testcross.zuji.mapper.BmMessageMapper;
import top.testcross.zuji.mapper.PmPostMapper;
import top.testcross.zuji.service.*;
import top.testcross.zuji.util.DaoUtil;

import java.util.*;

@Component
public class MessageHandler {
    @Autowired
    IUimUserService userService;

    @Autowired
    IPmPostService pmPostService;

    @Autowired
    IBmMessageService messageService;

    @Autowired
    IPamCommentService commentService;

    @Autowired
    IPamLikeService likeService;

    @Autowired
    IPamFavoriteService favoriteService;

    @Autowired
    IUimFollowService followService;

    @Autowired
    IBmImgService imgService;

    @Autowired
    BmMessageMapper messageMapper;

    @Autowired
    PmPostMapper postMapper;




    public int dealMessages() {
        int result=1;
        //查出所有未处理消息
        BmMessageExample messageExample=new BmMessageExample();
        messageExample.createCriteria().andMsgIsDealEqualTo(false);

        List<BmMessage> messages=(List<BmMessage>) DaoUtil.selectByExample(messageMapper,messageExample);

        //构建post id集合
        Set<String> postSet=new HashSet<>();
        for(BmMessage message:messages){
            if(message.getMsgType()==4||message.getMsgType()==7){
                try{
                    dealMessage(message,message.getUserId());
                }catch (Exception e){
                    result=0;
                }
            }if(message.getMsgType()==9||message.getMsgType()==10){
                try{
                    dealMessage(message,message.getUserId());
                }catch (Exception e){
                    result=0;
                }
            }else if(message.getMsgType()!=0){
                postSet.add(message.getMsgSrcId());
            }
        }

        //查询出所有影响到的动态
        PmPostExample pmPostExample=new PmPostExample();
        List<String> postIds=new LinkedList<>(postSet);
        postIds.remove("-1");
        pmPostExample.createCriteria().andPostIdIn(postIds);
        List<PmPost> posts=(List<PmPost>)DaoUtil.selectByExample(postMapper,pmPostExample);

        //构建post map
        Map<String,PmPost> postMap=new HashMap<>();
        for (PmPost post:posts){
            postMap.put(post.getPostId(),post);
        }

        //遍历messag批量处理处理
        for(BmMessage message:messages){
            PmPost post=postMap.get(message.getMsgSrcId());
            if(post!=null) {
                String userId = post.getUserId();
                try {
                    dealMessage(message,userId);
                }catch (Exception e){
                    result=0;
                }
            }
        }
        return  result;
    }

    @Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
    public  void dealMessage(BmMessage message, String userId) throws Exception{
        BmMessageH bmMessageH=(BmMessageH) messageService.dealMessage(message,userId);
        updatePost(bmMessageH);
        updateUser(bmMessageH);
    }

    private void updateUser(BmMessageH messageH) throws Exception{
        String userId=messageH.getMsgAcUserId();
        UimUser user= (UimUser)userService.findByID(userId);
        if(user==null||user.getUUID()==null)throw new Exception("更新用户数据出错");

        //根据不同情况处理消息内容
        switch (messageH.getMsgType()){
            case 1:
            case 2:
            case 5:
            case 6:
                //更新喜爱与收藏信息
                user.setUserLafCount(likeService.countActionByOtherUser(userId)+favoriteService.countActionByOtherUser(userId));
                break;
            case 4:
            case 7:
                //更新关注人数
                user.setUserFollowerCount(followService.countFollowersByUser(userId));
                UimUser acUser= (UimUser)userService.findByID(messageH.getUserId());
                //更新被关注人数
                if(acUser!=null){
                    acUser.setUserFollowCount(followService.countFollowByUser(acUser.getUserId()));
                    userService.modifyByID(acUser);
                }else throw new Exception("更新用户数据出错");
                break;
            case 9:
            case 10:
                //更新照片数量
                user.setUserImgCount(imgService.countImgsByUser(userId));
                //更新喜爱与收藏信息
                user.setUserLafCount(likeService.countActionByOtherUser(userId)+favoriteService.countActionByOtherUser(userId));
                //更新动态数量
                user.setUserPostCount(pmPostService.countPostByUser(userId));
                break;
        }

        userService.modifyByID(user);
    }


    private void updatePost(BmMessageH messageH) throws Exception{
        String postId=messageH.getMsgSrcId();
        PmPost post=(PmPost)pmPostService.findByID(postId);
        if(post==null||post.getUUID()==null)return;
        //根据不同情况处理消息内容
        switch (messageH.getMsgType()){
            case 1:
            case 5:
            //更新喜爱计数
                post.setPostLikeCount(likeService.countActionByPost(postId));
                break;
            case 3:
            case 8:
            //更新评论计数
                post.setPostCmtCount(commentService.countActionByPost(postId));
                break;
            case 2:
            case 6:
            //更新收藏计数
                post.setPostFavCount(favoriteService.countActionByPost(postId));
                break;
        }

        pmPostService.modifyByID(post);
    }
}
