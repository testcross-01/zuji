package top.testcross.zuji.bean.interfaces;

import top.testcross.zuji.bean.BmMessage;

public interface ActionDataBean extends DataBean{
    /**
     * 创建操作时的消息对象
     * @return 消息对象
     */
   BmMessage createMessage();

    /**
     * 创建取消操作时的消息对象
     * @return 消息对象
     */
   BmMessage createUoDoMessage();
}
