package top.testcross.zuji.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import top.testcross.zuji.bean.*;
import top.testcross.zuji.bean.interfaces.DataBean;
import top.testcross.zuji.mapper.BmMessageHMapper;
import top.testcross.zuji.mapper.BmMessageMapper;
import top.testcross.zuji.mapper.PmPostMapper;
import top.testcross.zuji.service.IBmMessageService;
import top.testcross.zuji.util.DaoUtil;

import java.util.*;

@Service
public class BmMessageServiceImpl implements IBmMessageService {
    @Autowired
    BmMessageMapper messageMapper;

    @Autowired
    PmPostMapper postMapper;

    @Autowired
    BmMessageHMapper messageHMapper;

    @Override
    public int save(DataBean dataBean) {
        return DaoUtil.insert(messageMapper,dataBean);
    }

    @Override
    public int deleteByID(String id) {
        return DaoUtil.deleteByID(messageMapper,id);
    }

    @Override
    public int modifyByID(DataBean dataBean) {
        return DaoUtil.updateByID(messageMapper,dataBean);
    }

    @Override
    public DataBean findByID(String id) {
        return DaoUtil.selectByID(messageMapper,id);
    }




    @Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
    public DataBean dealMessage(BmMessage message,String userId){
        BmMessageH messageH=message.createBmMessageH(userId);
        DaoUtil.insert(messageHMapper,messageH);
        message.setMsgIsDeal(true);
        DaoUtil.updateByID(messageMapper,message);

        return  messageH;
    }
}
