package top.testcross.zuji.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import top.testcross.zuji.bean.*;
import top.testcross.zuji.bean.interfaces.DataBean;
import top.testcross.zuji.mapper.BmMessageHMapper;
import top.testcross.zuji.mapper.BmMessageMapper;
import top.testcross.zuji.mapper.PmPostMapper;
import top.testcross.zuji.service.IBmMessageService;
import top.testcross.zuji.util.DaoUtil;

import java.util.*;

@Service
public class BmMessageServiceImpl implements IBmMessageService {
    @Autowired
    BmMessageMapper messageMapper;

    @Autowired
    PmPostMapper postMapper;

    @Autowired
    BmMessageHMapper messageHMapper;

    @Override
    public int save(DataBean dataBean) {
        return DaoUtil.insert(messageMapper,dataBean);
    }

    @Override
    public int deleteByID(String id) {
        return DaoUtil.deleteByID(messageMapper,id);
    }

    @Override
    public int modifyByID(DataBean dataBean) {
        return DaoUtil.updateByID(messageMapper,dataBean);
    }

    @Override
    public DataBean findByID(String id) {
        return DaoUtil.selectByID(messageMapper,id);
    }


    @Override
    public int dealMessages() {
        int result=1;
        //查出所有未处理消息
        BmMessageExample messageExample=new BmMessageExample();
        messageExample.createCriteria().andMsgIsDealEqualTo(false);

        List<BmMessage> messages=(List<BmMessage>) DaoUtil.selectByExample(messageMapper,messageExample);

        //构建post id集合
        Set<String> postSet=new HashSet<>();
        for(BmMessage message:messages){
            if(message.getMsgType()!=0||message.getMsgType()!=2){
                postSet.add(message.getMsgSrcId());
            }else if(message.getMsgType()==4){
                try{
                    dealMessage(message,message.getMsgSrcId());
                }catch (Exception e){
                    result=0;
                }
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
    public void dealMessage(BmMessage message,String userId) throws Exception{
        BmMessageH messageH=message.createBmMessageH(userId);

        if(DaoUtil.insert(messageHMapper,messageH)==0){
           throw new Exception("messageH归档异常");
        }else {
            message.setMsgIsDeal(true);
            if(DaoUtil.updateByID(messageMapper,message)==0)
                throw new Exception();
        }
    }
}
