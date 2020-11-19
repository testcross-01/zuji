package top.testcross.zuji.bean;

import java.util.Date;
import lombok.Data;
import top.testcross.zuji.bean.interfaces.ActionDataBean;
import top.testcross.zuji.bean.interfaces.DataBean;

/**
 * Table: pam_like
 */
@Data
public class PamLike implements ActionDataBean {
    /**
     * 点赞id
     *
     * Column:    like_id
     * Nullable:  false
     */
    private String likeId;

    /**
     * 用户id
     *
     * Column:    user_id
     * Nullable:  false
     */
    private String userId;

    /**
     * 动态id
     *
     * Column:    post_id
     * Nullable:  false
     */
    private String postId;

    /**
     * 点赞时间
     *
     * Column:    like_create_time
     * Nullable:  false
     */
    private Date likeCreateTime;

    @Override
    public void setUUID(String uuid) {
        setLikeId(uuid);
    }

    @Override
    public BmMessage createMessage() {
        if(postId==null||userId==null||likeCreateTime==null)
            return new BmMessage();
        BmMessage message=new BmMessage(null,(byte)1,userId,likeCreateTime,postId,false);
        return message;
    }

    public PamLike(){

    }

    public PamLike(String likeId, String userId, String postId, Date likeCreateTime) {
        this.likeId = likeId;
        this.userId = userId;
        this.postId = postId;
        this.likeCreateTime = likeCreateTime;
    }
}