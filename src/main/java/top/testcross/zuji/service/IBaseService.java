package top.testcross.zuji.service;

import top.testcross.zuji.bean.interfaces.DataBean;

/**
 * 服务基础接口
 * 基本的增删改方法
 */
public interface IBaseService {

    int save(DataBean dataBean) throws Exception;
    int deleteByID(String id) throws  Exception;
    int modifyByID(DataBean dataBean) throws Exception;
    DataBean findByID(String id) throws Exception;

}
