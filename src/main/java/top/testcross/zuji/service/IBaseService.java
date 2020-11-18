package top.testcross.zuji.service;

import top.testcross.zuji.bean.interfaces.DataBean;

/**
 * 服务基础接口
 * 基本的增删改方法
 */
public interface IBaseService {

    int save(DataBean dataBean);
    int deleteByID(String id);
    int modifyByID(DataBean dataBean);
    DataBean findByID(String id);

}
