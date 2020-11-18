package top.testcross.zuji.service;

import top.testcross.zuji.bean.interfaces.DataBean;

import java.util.List;

public interface IPamFavoriteService extends IPamService{
    /**
     * 根据用户查询所有喜爱的地点
     * @param id
     * @return 地点信息集合
     */
    List<? extends DataBean> findFavoritePlaceByUser(String id);
}
