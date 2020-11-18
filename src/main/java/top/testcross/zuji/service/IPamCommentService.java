package top.testcross.zuji.service;

import top.testcross.zuji.bean.interfaces.DataBean;

import java.util.List;

public interface IPamCommentService extends IPamService {

    /**
     * 根据动态查询对应的所有评论
     * @param postID
     * @return
     */
    List<? extends DataBean> findCommentsByPostID(String postID);


}
