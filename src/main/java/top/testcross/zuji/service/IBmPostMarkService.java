package top.testcross.zuji.service;

import top.testcross.zuji.bean.interfaces.DataBean;

import java.util.List;

public interface IBmPostMarkService extends IBaseService {
    /**
     * 根据动态id查询对应的tag
     * @param postId
     * @return
     */
    List<? extends DataBean> findTagByPost(String postId);

    /**
     * 根据标签id查询对应的动态
     * @param tagId
     * @return
     */
    List<? extends DataBean> findPostByTag(String tagId);



}
