package top.testcross.zuji.service.impl;

import com.github.pagehelper.PageHelper;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.testcross.zuji.bean.PmPostExample;
import top.testcross.zuji.bean.interfaces.DataBean;
import top.testcross.zuji.exception.NotImplException;
import top.testcross.zuji.mapper.PmPostMapper;
import top.testcross.zuji.service.IPostRecommend;
import top.testcross.zuji.util.DaoUtil;

import java.util.LinkedList;
import java.util.List;

@Service
public class PostRecommendImpl implements IPostRecommend {
    @Autowired
    PmPostMapper postMapper;

    @Override
    public List<String> recommendPostByUser(String userId) {
        throw new NotImplException();
    }

    @Override
    public List<String> recommendPostByScore(int start,int limit) {
        PmPostExample postExample=new PmPostExample();
        postExample.setOrderByClause("post_like_count+2*post_fav_count+3*post_cmt_count DESC,post_create_time DESC");
        PageHelper.startPage(start,limit);
        List<? extends DataBean> dataBeans= DaoUtil.selectByExample(postMapper,postExample);
        List<String> ids=new LinkedList<>();
        for (DataBean dataBean:dataBeans){
            ids.add(dataBean.getUUID());
        }
        return ids;
    }

    @Override
    public List<String> recommendPostByPI() {
        throw new NotImplException();    }

    @Override
    public List<String> recommendPostByTag(int start,int limit,String tagId) {
        PmPostExample postExample=new PmPostExample();
        postExample.setOrderByClause("post_like_count+2*post_fav_count+3*post_cmt_count DESC,post_create_time DESC");
        PageHelper.startPage(start,limit);
        List<? extends DataBean> dataBeans= DaoUtil.selectByExample(postMapper,postExample);
        List<String> ids=new LinkedList<>();
        for (DataBean dataBean:dataBeans){
            ids.add(dataBean.getUUID());
        }
        return ids;
    }
}
