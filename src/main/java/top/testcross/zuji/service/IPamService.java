package top.testcross.zuji.service;

import top.testcross.zuji.bean.interfaces.ActionDataBean;
import top.testcross.zuji.bean.interfaces.DataBean;

/**
 * 动态操作类型的接口
 * 实现各种统计操作（方便更新时替换）
 */
public interface IPamService extends IActionService{


    /**
     * 计算某个用户对动态进行某操作的数量
     * @param id
     * @return 操作总数
     */
    int countActionByUser(String id);

    /**
     * 计算某个动态被用户进行某操作的数量
     * @param id
     * @return 操作总数
     */
    int countActionByPost(String id);

    /**
     * 计算被其他用户进行的某操作的数量
     * @param id
     * @return 操作总数
     */
    int countActionByOtherUser(String id);




}
