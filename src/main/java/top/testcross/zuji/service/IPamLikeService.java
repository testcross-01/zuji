package top.testcross.zuji.service;

import top.testcross.zuji.bean.interfaces.DataBean;

public interface IPamLikeService extends IPamService {
    /**
     * 查询用户对应的操作记录
     * @param userId
     * @param postId
     * @return
     */
    DataBean selectByUserIdAndPostId(String userId, String postId) throws Exception;

    /**
     * 删除用户对应的操作记录
     * @param userId
     * @param postId
     * @return
     */
    int deleteByUserIdAndPostId(String userId,String postId) throws Exception;

}
