package top.testcross.zuji.bean;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import top.testcross.zuji.bean.interfaces.ActionDataBean;
import top.testcross.zuji.bean.interfaces.DataBean;

/**
 * Table: pam_favorite
 */
@Data
@ApiModel(description = "收藏模型")
public class PamFavorite implements ActionDataBean {
    /**
     * 收藏id
     *
     * Column:    fav_id
     * Nullable:  false
     */
    @ApiModelProperty("收藏id")
    private String favId;

    /**
     * 用户id
     *
     * Column:    user_id
     * Nullable:  false
     */
    @ApiModelProperty("用户id")
    private String userId;

    /**
     * 动态id
     *
     * Column:    post_id
     * Nullable:  false
     */
    @ApiModelProperty("动态id")
    private String postId;

    /**
     * 地点id
     *
     * Column:    pi_id
     * Nullable:  false
     */
    @ApiModelProperty("地点id")
    private String piId;

    /**
     * 收藏时间
     *
     * Column:    fav_create_time
     * Nullable:  false
     */
    @ApiModelProperty("收藏时间")
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
        if(postId==null||userId==null)
            return new BmMessage();
        BmMessage message=new BmMessage(null,(byte)6,userId,new Date(System.currentTimeMillis()),postId,false);
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