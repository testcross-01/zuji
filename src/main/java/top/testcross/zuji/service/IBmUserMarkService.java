package top.testcross.zuji.service;

import top.testcross.zuji.bean.interfaces.DataBean;

import java.util.List;

public interface IBmUserMarkService extends  IBaseService {
    /**
     * 根据动用户id查询对应的tag
     * @param userId
     * @return
     */
    List<? extends DataBean> findTagByUser(String userId);

    /**
     * 根据标签id查询对应的动用户
     * @param tagId
     * @return
     */
    List<? extends DataBean> findUserByTag(String tagId);

}
