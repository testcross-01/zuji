package top.testcross.zuji.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.testcross.zuji.bean.PamComment;
import top.testcross.zuji.bean.PamCommentExample;
import top.testcross.zuji.bean.PmPost;
import top.testcross.zuji.bean.PmPostExample;
import top.testcross.zuji.bean.interfaces.DataBean;
import top.testcross.zuji.mapper.PamCommentMapper;
import top.testcross.zuji.mapper.PmPostMapper;
import top.testcross.zuji.service.IPamCommentService;
import top.testcross.zuji.service.IPamService;
import top.testcross.zuji.util.DaoUtil;

import java.util.LinkedList;
import java.util.List;

@Service
public class PamCommentServiceImpl implements IPamCommentService {
    private static final String BASE_COMMENT="";

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
        List<PmPost> posts=pmPostMapper.selectByExample(postExample);

        //计算所有动态的总评论数
        int count=0;
        for(PmPost post:posts){
            count+=post.getPostCmtCount();
        }
        return count;
    }

    @Override
    public int save(DataBean dataBean) {
        return DaoUtil.insert(pamCommentMapper,dataBean);
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
        List<PamComment> comments=pamCommentMapper.selectByExample(example);


        example=new PamCommentExample();
        example.createCriteria().andPostIdEqualTo(postID).andCmtParentIdNotEqualTo(BASE_COMMENT);
        example.setOrderByClause("cmt_parent_id asc");
        //筛选出对应动态的所有子评论 按评论id排序
        List<PamComment> chidComments=pamCommentMapper.selectByExample(example);
        int index=0;
        for(PamComment pamComment:comments){
            pamComment.setComments(new LinkedList<PamComment>());
            for(;index<chidComments.size();index++){
                PamComment chidComment=chidComments.get(index);
                if(chidComment.getCmtParentId()==pamComment.getCmtId()){
                    pamComment.getComments().add(chidComment);
                }else {
                    break;
                }
            }
        }
        return comments;
    }
}
