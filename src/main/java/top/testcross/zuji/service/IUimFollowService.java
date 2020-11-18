package top.testcross.zuji.service;

public interface IUimFollowService extends IBaseService {
    int countFollowersByUser(String userId);
    int countFollowByUser(String userId);
}
