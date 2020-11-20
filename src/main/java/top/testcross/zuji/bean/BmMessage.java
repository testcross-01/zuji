package top.testcross.zuji.bean;

import java.util.Date;
import lombok.Data;
import top.testcross.zuji.bean.interfaces.DataBean;

/**
 * Table: bm_message
 */
@Data
public class BmMessage implements DataBean {
    /**
     * 消息id
     *
     * Column:    msg_id
     * Nullable:  false
     */
    private String msgId;

    /**
     * 消息类型
     *
     * Column:    msg_type
     * Nullable:  false
     */
    private Byte msgType;

    /**
     * 创建消息的用户id
     *
     * Column:    user_id
     * Nullable:  false
     */
    private String userId;

    /**
     * 消息创建时间
     *
     * Column:    msg_create_date
     * Nullable:  false
     */
    private Date msgCreateDate;

    /**
     * 消息来源id
     *
     * Column:    msg_src_id
     * Nullable:  false
     */
    private String msgSrcId;

    /**
     * 消息是否已处理
     *
     * Column:    msg_is_deal
     * Nullable:  false
     */
    private Boolean msgIsDeal;

    @Override
    public void setUUID(String uuid) {
        setMsgId(uuid);
    }

    @Override
    public String getUUID() {
        return getMsgId();
    }

    public BmMessage() {
    }

    public BmMessage(String msgId, Byte msgType, String userId, Date msgCreateDate, String msgSrcId, Boolean msgIsDeal) {
        this.msgId = msgId;
        this.msgType = msgType;
        this.userId = userId;
        this.msgCreateDate = msgCreateDate;
        this.msgSrcId = msgSrcId;
        this.msgIsDeal = msgIsDeal;
    }

    public BmMessageH createBmMessageH(String acUserId){
        if(msgType==null||userId==null||msgCreateDate==null||msgSrcId==null||msgSrcId==null)
            return  new BmMessageH();
        BmMessageH messageH=new BmMessageH(null,msgType,acUserId,msgSrcId,msgCreateDate,null,userId);

        //根据不同情况放入不同的消息内容
        switch (this.getMsgType()){
            case 1:messageH.setMsgCont(BmMessageH.LIKE_ACTION);break;
            case 3:messageH.setMsgCont(BmMessageH.CMT_ACTION);break;
            case 4:messageH.setMsgCont(BmMessageH.FOLLOW_ACTION);break;
        }
        return  messageH;
    }
}