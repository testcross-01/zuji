package top.testcross.zuji.service;

import top.testcross.zuji.bean.UimUser;
import top.testcross.zuji.bean.interfaces.DataBean;

public interface IUimUserService extends IBaseService{
    /**
     * 查询完整的用户信息
     * @param userId
     * @return 用户信息
     */
    DataBean findCompleteUser(String userId);


}
