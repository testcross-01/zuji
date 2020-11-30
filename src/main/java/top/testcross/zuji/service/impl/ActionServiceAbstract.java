package top.testcross.zuji.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.testcross.zuji.bean.BmMessage;
import top.testcross.zuji.bean.interfaces.ActionDataBean;
import top.testcross.zuji.bean.interfaces.DataBean;
import top.testcross.zuji.mapper.BmMessageMapper;
import top.testcross.zuji.service.IActionService;
import top.testcross.zuji.service.IPamService;
import top.testcross.zuji.util.DaoUtil;

@Service
public abstract class ActionServiceAbstract implements IActionService {
    @Autowired
    BmMessageMapper messageMapper;


    /**
     * 创建并保存message
     * @param actionDataBean
     * @param actionType
     * @return 执行情况
     * @throws Exception
     */
    protected int createAndSaveMessage(ActionDataBean actionDataBean,int actionType){
        BmMessage message=null;
        //根据actionType判定是添加还是撤销
        switch (actionType){
            case 0:message=actionDataBean.createUoDoMessage();break;
            case 1:message=actionDataBean.createMessage();break;
        }
        return DaoUtil.insert(messageMapper,message);
    }
}
