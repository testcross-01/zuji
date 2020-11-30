package top.testcross.zuji.service;

import top.testcross.zuji.bean.interfaces.ActionDataBean;
import top.testcross.zuji.bean.interfaces.DataBean;

public interface IUimFollowService extends IActionService {
    int countFollowersByUser(String userId);
    int countFollowByUser(String userId);

    /**
     * 删除用户对于某个用户的关注
     * @param userId
     * @param followUserId
     * @return
     * @throws Exception
     */
    int deleteByUserIdAndFollowUserId(String userId,String followUserId);

    /**
     * 根据用户和关注用户信息查询对应记录
     * @param userId
     * @param followUserId
     * @return
     * @throws Exception
     */
    DataBean selectByUserIdAndFollowUserId(String userId,String followUserId);
}
