package top.testcross.zuji.bean;

import java.util.Date;
import lombok.Data;
import top.testcross.zuji.bean.interfaces.ActionDataBean;
import top.testcross.zuji.bean.interfaces.DataBean;

/**
 * Table: pam_favorite
 */
@Data
public class PamFavorite implements ActionDataBean {
    /**
     * 收藏id
     *
     * Column:    fav_id
     * Nullable:  false
     */
    private String favId;

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
     * 地点id
     *
     * Column:    pi_id
     * Nullable:  false
     */
    private String piId;

    /**
     * 收藏时间
     *
     * Column:    fav_create_time
     * Nullable:  false
     */
    private Date favCreateTime;

    @Override
    public void setUUID(String uuid) {
        setFavId(uuid);
    }

    @Override
    public String getUUID() {
        return getFavId();
    }

    @Override
    public BmMessage createMessage() {
        if(postId==null||userId==null||favCreateTime==null)
            return new BmMessage();
        BmMessage message=new BmMessage(null,(byte)2,userId,favCreateTime,postId,false);
        return message;
    }

    @Override
    public BmMessage createUoDoMessage() {
        if(postId==null||userId==null||favCreateTime==null)
            return new BmMessage();
        BmMessage message=new BmMessage(null,(byte)6,userId,favCreateTime,postId,false);
        return message;
    }

    public PamFavorite(){

    }

    public PamFavorite(String favId, String userId, String postId, String piId, Date favCreateTime) {
        this.favId = favId;
        this.userId = userId;
        this.postId = postId;
        this.piId = piId;
        this.favCreateTime = favCreateTime;
    }
}