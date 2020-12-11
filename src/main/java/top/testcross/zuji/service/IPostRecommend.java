package top.testcross.zuji.service;

import top.testcross.zuji.bean.PmPost;

import java.util.List;

public interface IPostRecommend {
    /**
     * 根据用户id推荐动态
     * @param userId
     * @return 动态id集合
     */
    List<String> recommendPostByUser(String userId);

    /**
     * 根据点赞、评论和收藏计分推荐动态
     * @return 动态id集合
     */
    List<String> recommendPostByScore(int start,int limit);

    /**
     * 根据地点推荐动态
     * @return 动态id集合
     */
    List<String> recommendPostByPI();

    /**
     * 根据tag推荐动态
     * @return 动态id集合
     */
    List<String> recommendPostByTag(int start,int limit,String tagId);
    
}
