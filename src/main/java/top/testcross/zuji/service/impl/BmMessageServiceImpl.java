package top.testcross.zuji.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import top.testcross.zuji.bean.*;
import top.testcross.zuji.bean.interfaces.DataBean;
import top.testcross.zuji.mapper.BmMessageHMapper;
import top.testcross.zuji.mapper.BmMessageMapper;
import top.testcross.zuji.mapper.PmPostMapper;
import top.testcross.zuji.service.IBmMessageService;
import top.testcross.zuji.util.DaoUtil;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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
        List<BmMessage> messages=messageMapper.selectByExample(messageExample);

        //构建post id集合
        List<String> postIds=new LinkedList<>();
        for(BmMessage message:messages){
            if(message.getMsgType()!=0||message.getMsgType()!=2){
                postIds.add(message.getMsgSrcId());
            }else if(message.getMsgType()==4){
                BmMessageH messageH=message.createBmMessageH(message.getMsgSrcId());
                if(DaoUtil.insert(messageHMapper,messageH)==0)
                    result=0;
            }
        }

        //查询出所有影响到的动态
        PmPostExample pmPostExample=new PmPostExample();
        pmPostExample.createCriteria().andPostIdIn(postIds);
        List<PmPost> posts= postMapper.selectByExample(pmPostExample);

        //构建post map
        Map<String,PmPost> postMap=new HashMap<>();
        for (PmPost post:posts){
            postMap.put(post.getPostId(),post);
        }

        //遍历messag批量处理处理
        for(BmMessage message:messages){
            PmPost post=postMap.get(message.getMsgSrcId());
            if(post!=null){
                String userId=post.getUserId();
                BmMessageH messageH=message.createBmMessageH(userId);

                if(DaoUtil.insert(messageMapper,messageH)==0)
                    result=0;
                }else {
                    message.setMsgIsDeal(true);
                    messageMapper.updateByPrimaryKey(message);
                }
        }

        return  result;
    }
}
