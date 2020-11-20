package top.testcross.zuji.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import top.testcross.zuji.bean.interfaces.ActionDataBean;
import top.testcross.zuji.bean.interfaces.DataBean;
import top.testcross.zuji.mapper.BmMessageMapper;
import top.testcross.zuji.service.IActionService;
import top.testcross.zuji.service.IPamService;
import top.testcross.zuji.util.DaoUtil;

public abstract class ActionServiceAbstract implements IActionService {
    @Autowired
    BmMessageMapper messageMapper;



    protected int createAndSaveMessage(ActionDataBean actionDataBean) throws Exception{
        return DaoUtil.insert(messageMapper,actionDataBean.createMessage());
    }
}
