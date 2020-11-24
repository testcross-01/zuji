package top.testcross.zuji.service;

import top.testcross.zuji.bean.BmMessage;
import top.testcross.zuji.bean.interfaces.DataBean;

public interface IBmMessageService extends IBaseService {
    /**
     * 处理message信息
     * @param message
     * @param userId
     * @return messageh对象
     * @throws Exception
     */
    public DataBean dealMessage(BmMessage message, String userId) throws Exception;
}
