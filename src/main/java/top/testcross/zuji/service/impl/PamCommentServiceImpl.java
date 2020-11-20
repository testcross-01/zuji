package top.testcross.zuji.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import top.testcross.zuji.bean.PamComment;
import top.testcross.zuji.bean.PamCommentExample;
import top.testcross.zuji.bean.PmPost;
import top.testcross.zuji.bean.PmPostExample;
import top.testcross.zuji.bean.interfaces.ActionDataBean;
import top.testcross.zuji.bean.interfaces.DataBean;
import top.testcross.zuji.mapper.PamCommentMapper;
import top.testcross.zuji.mapper.PmPostMapper;
import top.testcross.zuji.service.IPamCommentService;
import top.testcross.zuji.util.DaoUtil;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Service
public class PamCommentServiceImpl extends ActionServiceAbstract implements IPamCommentService {
    private static final String BASE_COMMENT="-1";

    @Autowired
    PamCommentMapper pamCommentMapper;

    @Autowired
    PmPostMapper pmPostMapper;

    @Override
    public int countActionByUser(String id) {
        PamCommentExample example=new PamCommentExample();
        PamCommentExample.Criteria criteria= example.createCriteria();
        criteria.andUserIdEqualTo(id);
        return pamCommentMapper.countByExample(example);
    }

    @Override
    public int countActionByPost(String id) {
        PamCommentExample example=new PamCommentExample();
        PamCommentExample.Criteria criteria= example.createCriteria();
        criteria.andPostIdEqualTo(id);
        return pamCommentMapper.countByExample(example);
    }

    @Override
    public int countActionByOtherUser(String id) {
        //查询出用户的所有动态
        PmPostExample postExample=new PmPostExample();
        postExample.createCriteria().andUserIdEqualTo(id);
        List<PmPost> posts=(List<PmPost>) DaoUtil.selectByExample(pmPostMapper,postExample);

        //计算所有动态的总评论数
        int count=0;
        for(PmPost post:posts){
            count+=post.getPostCmtCount();
        }
        return count;
    }

    @Override
    public int saveAndCreateMessage(ActionDataBean actionDataBean) throws Exception {
        if(DaoUtil.insert(pamCommentMapper,actionDataBean)==0||createAndSaveMessage(actionDataBean)==0)
            throw new Exception("保存操作时错误");
        return 1;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
    public int save(DataBean dataBean) throws Exception {
        return saveAndCreateMessage((ActionDataBean) dataBean);
    }

    @Override
    public int deleteByID(String id) {
        return DaoUtil.deleteByID(pamCommentMapper,id);
    }

    @Override
    public int modifyByID(DataBean dataBean) {
        return DaoUtil.updateByID(pamCommentMapper,dataBean);
    }

    @Override
    public DataBean findByID(String id) {
        return DaoUtil.selectByID(pamCommentMapper,id);
    }



    @Override
    public List<? extends DataBean> findCommentsByPostID(String postID) {
        PamCommentExample example=new PamCommentExample();
        //筛选出对应动态的非子评论 按评论id排序
        example.createCriteria().andPostIdEqualTo(postID).andCmtParentIdEqualTo(BASE_COMMENT);
        example.setOrderByClause("cmt_id asc");

        List<PamComment> comments=(List<PamComment>)DaoUtil.selectByExample(pamCommentMapper,example);

        //构造评论map
        Map<String,PamComment> commentMap=new HashMap<>();
        for(PamComment comment:comments){
            commentMap.put(comment.getCmtId(),comment);
        }

        //搜索所有子评论
        example=new PamCommentExample();
        example.createCriteria().andPostIdEqualTo(postID).andCmtParentIdNotEqualTo(BASE_COMMENT);

        //筛选出对应动态的所有子评论 按评论id排序
        List<PamComment> chidComments=(List<PamComment>)DaoUtil.selectByExample(pamCommentMapper,example);
        int index=0;
        for(PamComment childComment:chidComments){
           PamComment comment=commentMap.get(childComment.getCmtParentId());
           if(comment==null)continue;
           if(comment.getComments()==null)comment.setComments(new LinkedList<>());
           comment.getComments().add(childComment);
        }
        return comments;
    }
}
