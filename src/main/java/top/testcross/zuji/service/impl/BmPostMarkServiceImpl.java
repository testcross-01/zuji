package top.testcross.zuji.service.impl;

import javafx.print.Collation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.testcross.zuji.bean.*;
import top.testcross.zuji.bean.interfaces.DataBean;
import top.testcross.zuji.mapper.BmPostMarkMapper;
import top.testcross.zuji.mapper.BmTagMapper;
import top.testcross.zuji.mapper.PmPostMapper;
import top.testcross.zuji.service.IBmPostMarkService;
import top.testcross.zuji.util.DaoUtil;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

@Service
public class BmPostMarkServiceImpl implements IBmPostMarkService {
    @Autowired
    BmPostMarkMapper postMarkMapper;

    @Autowired
    PmPostMapper pmPostMapper;

    @Autowired
    BmTagMapper bmTagMapper;

    @Override
    public int save(DataBean dataBean) {
        return DaoUtil.insert(postMarkMapper,dataBean);
    }

    @Override
    public int deleteByID(String id) {
        return DaoUtil.deleteByID(postMarkMapper,id);
    }

    @Override
    public int modifyByID(DataBean dataBean) {
        return DaoUtil.updateByID(postMarkMapper,dataBean);
    }

    @Override
    public DataBean findByID(String id) {
        return DaoUtil.selectByID(postMarkMapper,id);
    }

    @Override
    public List<? extends DataBean> findTagByPost(String postId) {
        //根据post id查询所有标记记录
        BmPostMarkExample bmPostMarkExample=new BmPostMarkExample();
        bmPostMarkExample.createCriteria().andPostIdEqualTo(postId);
        List<BmPostMark> marks= (List<BmPostMark>)DaoUtil.selectByExample(postMarkMapper,bmPostMarkExample);

        //根据tagid字段建立集合（可以优化改为用sql）
        List<String> tagIds=new LinkedList<String>();
        for(BmPostMark mark:marks){
            tagIds.add(mark.getTagId());
        }

        //根据标记记录查询对应的tag
        BmTagExample tagExample=new BmTagExample();
        tagExample.createCriteria().andTagIdIn(tagIds);

        return  DaoUtil.selectByExample(bmTagMapper,tagExample);
    }

    @Override
    public List<? extends DataBean> findPostByTag(String tagId) {
        //根据tag id查询所有标记记录
        BmPostMarkExample bmPostMarkExample=new BmPostMarkExample();
        bmPostMarkExample.createCriteria().andTagIdEqualTo(tagId);
        List<BmPostMark> marks= (List<BmPostMark>)DaoUtil.selectByExample(postMarkMapper,bmPostMarkExample);

        //根据post id建立集合
        List<String> postIds=new LinkedList<String>();
        for (BmPostMark mark:marks){
            postIds.add(mark.getPostId());
        }

        //根据动态id查询出对应的动态
        PmPostExample pmPostExample=new PmPostExample();
        pmPostExample.createCriteria().andPostIdIn(postIds);

        return DaoUtil.selectByExample(pmPostMapper,pmPostExample);
    }




    /**
     * 根据tag名模糊查询对应的动态
     * @param tagName
     * @return
     */
    public List<? extends DataBean> findPostByTagName(String tagName){
        throw new UnsupportedOperationException();
    }
}
