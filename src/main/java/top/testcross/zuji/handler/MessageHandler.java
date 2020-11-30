package top.testcross.zuji.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import top.testcross.zuji.bean.*;
import top.testcross.zuji.exception.DaoUtilException;
import top.testcross.zuji.exception.ExceptionLog;
import top.testcross.zuji.exception.ServiceException;
import top.testcross.zuji.mapper.BmGeoPlaceinfoMapper;
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
    BmGeoPlaceinfoMapper geoPlaceinfoMapper;

    @Autowired
    BmMessageMapper messageMapper;

    @Autowired
    PmPostMapper postMapper;




    public void dealMessages() {
        //查出所有未处理消息
        BmMessageExample messageExample=new BmMessageExample();
        messageExample.createCriteria().andMsgIsDealEqualTo(false);

        List<BmMessage> messages=(List<BmMessage>) DaoUtil.selectByExample(messageMapper,messageExample);

        //构建post id集合
        Set<String> postSet=new HashSet<>();
        for(BmMessage message:messages){
            try{
                if(message.getMsgType()==4||message.getMsgType()==7){
                    dealMessage(message,message.getUserId());
                }if(message.getMsgType()==9||message.getMsgType()==10){
                    dealMessage(message,message.getUserId());
                }else if(message.getMsgType()!=0){
                    postSet.add(message.getMsgSrcId());
                }
            }catch (DaoUtilException ex){
                ex.printStackTrace();
            }catch (Exception ex){
                ex.printStackTrace();
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

        //遍历messag批量处理
        for(BmMessage message:messages){
            PmPost post=postMap.get(message.getMsgSrcId());
            if(post!=null) {
                String userId = post.getUserId();
                try {
                    dealMessage(message,userId);
                }catch (DaoUtilException ex){
                    ex.printStackTrace();
                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        }

    }

    @Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
    public  void dealMessage(BmMessage message, String userId){
        BmMessageH bmMessageH=(BmMessageH) messageService.dealMessage(message,userId);
        updatePost(bmMessageH);
        updateUser(bmMessageH);
    }

    private void updateUser(BmMessageH messageH){
        String userId=messageH.getMsgAcUserId();
        UimUser user= (UimUser)userService.findByID(userId);
        if(user==null||user.getUUID()==null)throw new ServiceException(ExceptionLog.NOUSER_EXCEPTION);

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
                }else throw new ServiceException(ExceptionLog.NOUSER_EXCEPTION);
                break;
            case 9:
            case 10:
                //更新照片数量
                user.setUserImgCount(imgService.countImgsByUser(userId));
                //更新喜爱与收藏信息
                user.setUserLafCount(likeService.countActionByOtherUser(userId)+favoriteService.countActionByOtherUser(userId));
                //更新动态数量
                user.setUserPostCount(pmPostService.countPostByUser(userId));
                //更新地点数据
                updateCntyCityPlaceNumberByUser(user);
                break;
        }

        userService.modifyByID(user);
    }


    private void updatePost(BmMessageH messageH){
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

    /**
     * 根据用户计算国家、城市和地点数量
     * @param user
     * @return
     */
    private void updateCntyCityPlaceNumberByUser(UimUser user){
        //查询所有动态对应的pi信息
        PmPostExample example=new PmPostExample();
        example.createCriteria().andUserIdEqualTo(user.getUserId());
        List<PmPost> posts= (List<PmPost>)DaoUtil.selectByExample(postMapper,example);
        Set<String> piIds=new HashSet<>();
        for(PmPost post:posts){
            piIds.add(post.getPiId());
        }

        BmGeoPlaceinfoExample placeinfoExample=new BmGeoPlaceinfoExample();
        placeinfoExample.createCriteria().andPiIdIn(new LinkedList<>(piIds));
        List<BmGeoPlaceinfo> placeinfos=(List<BmGeoPlaceinfo>) DaoUtil.selectByExample(geoPlaceinfoMapper,placeinfoExample);

        Set<String> countrys=new HashSet<>();
        Set<String> citys=new HashSet<>();

        //建立城市和国家集合
        for (BmGeoPlaceinfo placeinfo:placeinfos){
           countrys.add(placeinfo.getPiCountry());
            citys.add(placeinfo.getPiCountry()+placeinfo.getPiCity());
        }

        user.setUserCityCount(citys.size());
        user.setUserPlaceCount(placeinfos.size());
        user.setUserCntyCount(countrys.size());
    }
}
