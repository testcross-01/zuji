package top.testcross.zuji.bean.interfaces;

import top.testcross.zuji.bean.BmMessage;

public interface ActionDataBean extends DataBean{
    //创建操作对应的信息
   BmMessage createMessage();
}
