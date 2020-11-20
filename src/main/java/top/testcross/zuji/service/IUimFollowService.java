package top.testcross.zuji.service;

import top.testcross.zuji.bean.interfaces.ActionDataBean;

public interface IUimFollowService extends IActionService {
    int countFollowersByUser(String userId) throws Exception;
    int countFollowByUser(String userId) throws Exception;
}
