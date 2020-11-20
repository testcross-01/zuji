package top.testcross.zuji.service;

import top.testcross.zuji.bean.interfaces.ActionDataBean;

public interface IActionService extends IBaseService {

    /**
     * 保存actiondatacbean 同时创建并保存消息对象
     * @param actionDataBean
     * @return
     * @throws Exception
     */
    int saveAndCreateMessage(ActionDataBean actionDataBean) throws Exception;
}
