package top.testcross.zuji.bean;

import lombok.Data;
import top.testcross.zuji.bean.interfaces.ActionDataBean;
import top.testcross.zuji.bean.interfaces.DataBean;

/**
 * Table: uim_follow
 */
@Data
public class UimFollow implements ActionDataBean {
    /**
     * 关注id
     *
     * Column:    follow_id
     * Nullable:  false
     */
    private String followId;

    /**
     * 用户id
     *
     * Column:    user_id
     * Nullable:  false
     */
    private String userId;

    /**
     * 被关注用户id
     *
     * Column:    follow_user_id
     * Nullable:  false
     */
    private String followUserId;

    public UimFollow(){

    }

    public UimFollow(String followId, String userId, String followUserId) {
        this.followId = followId;
        this.userId = userId;
        this.followUserId = followUserId;
    }

    @Override
    public void setUUID(String uuid) {
        setFollowId(uuid);
    }

    @Override
    public BmMessage createMessage() {
        if(userId==null||followUserId==null)
            return new BmMessage();
        BmMessage message=new BmMessage(null,(byte)1,userId,null,followUserId,false);
        return message;
    }
}