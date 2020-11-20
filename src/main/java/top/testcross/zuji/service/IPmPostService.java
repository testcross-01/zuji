package top.testcross.zuji.service;

import top.testcross.zuji.bean.interfaces.DataBean;

import java.util.List;

public interface IPmPostService extends IBaseService{
    /**
     * 根据用户查询到所有动态,按时间升序排列
     * @param id
     * @return 动态集合
     */
    List<? extends DataBean> findPostByUserIdOrderByCreateTime(String id);

    /**
     * 按照id批量查询完整的动态(包含userId时会查出用户对动态的操作)
     * @param ids
     * @return
     */
    List<? extends DataBean> findPostInIds(List<String> ids,String userId);


    /**
     * 按照id查询缺省的动态
     * @param ids
     * @return
     */
    List<? extends DataBean> findPartPostInIds(List<String> ids);
}
