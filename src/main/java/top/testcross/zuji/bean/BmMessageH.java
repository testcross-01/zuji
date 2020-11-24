package top.testcross.zuji.bean;

import java.util.Date;
import lombok.Data;
import top.testcross.zuji.bean.interfaces.DataBean;

/**
 * Table: bm_message_h
 */
@Data
public class BmMessageH implements DataBean {
    /**
     * 消息id
     *
     * Column:    msg_id
     * Nullable:  false
     */
    private String msgId;

    /**
     * 消息类型（点赞、收藏、评论、粉丝、系统、动态）
     *
     * Column:    msg_type
     * Nullable:  false
     */
    private Byte msgType;

    /**
     * 接收消息用户的id
     *
     * Column:    msg_ac_user_id
     * Nullable:  false
     */
    private String msgAcUserId;

    /**
     * 消息来源id
     *
     * Column:    msg_src_id
     * Nullable:  false
     */
    private String msgSrcId;

    /**
     * 消息创建时间
     *
     * Column:    msg_create_date
     * Nullable:  false
     */
    private Date msgCreateDate;

    /**
     * 消息内容
     *
     * Column:    msg_cont
     * Nullable:  false
     */
    private String msgCont;

    /**
     * 创建消息用户id
     *
     * Column:    user_id
     * Nullable:  false
     */
    private String userId;

    /**
     * 消息创建人信息
     */
    private UimUser user;


    public static final String LIKE_ACTION="点赞了你的照片";

    public static final String FAV_ACTION="收藏了你的动态";

    public static final String FOLLOW_ACTION="关注了你，去他的主页看看";

    public static final String CMT_ACTION="评论了你的动态";

    public static final String UNDO_CMT_ACTION="删除评论";

    public static final String UNDO_FOLLOW_ACTION="取消关注";

    public static final String UNDO_LIKE_ACTION="取消点赞";

    public static final String UNDO_FAV_ACTION="取消收藏";

    public static final String CREATE_POST="发表了动态";

    public static final String DELETE_POST="删除动态";

    @Override
    public void setUUID(String uuid) {
        setMsgId(uuid);
    }

    @Override
    public String getUUID() {
        return getMsgId();
    }

    public BmMessageH() {
    }

    public BmMessageH(String msgId, Byte msgType, String msgAcUserId, String msgSrcId, Date msgCreateDate, String msgCont, String userId) {
        this.msgId = msgId;
        this.msgType = msgType;
        this.msgAcUserId = msgAcUserId;
        this.msgSrcId = msgSrcId;
        this.msgCreateDate = msgCreateDate;
        this.msgCont = msgCont;
        this.userId = userId;
    }
}