package top.testcross.zuji.bean;

import java.util.Date;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import top.testcross.zuji.bean.interfaces.ActionDataBean;
import top.testcross.zuji.bean.interfaces.DataBean;

import javax.xml.stream.events.Comment;

/**
 * Table: pam_comment
 */
@Data
@ApiModel(description = "评论模型")
public class PamComment implements ActionDataBean {
    /**
     * 评论id
     *
     * Column:    cmt_id
     * Nullable:  false
     */
    @ApiModelProperty("评论id")
    private String cmtId;

    /**
     * 评论内容
     *
     * Column:    cmt_cont
     * Nullable:  false
     */
    @ApiModelProperty("评论内容")
    private String cmtCont;

    /**
     * 动态id
     *
     * Column:    post_id
     * Nullable:  false
     */
    @ApiModelProperty("动态id")
    private String postId;

    /**
     * 父评论id
     *
     * Column:    cmt_parent_id
     * Nullable:  true
     */
    @ApiModelProperty("父评论id")
    private String cmtParentId;

    /**
     * 用户id
     *
     * Column:    user_id
     * Nullable:  false
     */
    @ApiModelProperty("用户id")
    private String userId;

    /**
     * 评论类型（用于判断是否为动态评论）
     *
     * Column:    cmt_type
     * Nullable:  false
     */
    @ApiModelProperty("评论类型")
    private Byte cmtType;

    /**
     * 回复用户id
     *
     * Column:    cmt_target_user_id
     * Nullable:  true
     */
    @ApiModelProperty("回复用户id")
    private String cmtTargetUserId;

    /**
     * 评论创建时间
     *
     * Column:    cmt_create_time
     * Nullable:  false
     */
    @ApiModelProperty("评论创建时间")
    private Date cmtCreateTime;

    /**
     * 子评论
     */
    @ApiModelProperty("子评论")
    private List<PamComment> comments;

    @Override
    public void setUUID(String uuid) {
        setCmtId(uuid);
    }

    @Override
    public String getUUID() {
        return getCmtId();
    }

    @Override
    public BmMessage createMessage() {
        if(postId==null||userId==null||cmtCreateTime==null)
            return new BmMessage();
        BmMessage message=new BmMessage(null,(byte)3,userId,cmtCreateTime,postId,false);
        return message;
    }

    @Override
    public BmMessage createUoDoMessage() {
        if(postId==null||userId==null)
            return new BmMessage();
        BmMessage message=new BmMessage(null,(byte)8,userId,new Date(System.currentTimeMillis()),postId,false);
        return message;
    }

    public PamComment(){

    }

    public PamComment(String cmtId, String cmtCont, String postId, String cmtParentId, String userId, Byte cmtType, String cmtTargetUserId, Date cmtCreateTime, List<PamComment> comments) {
        this.cmtId = cmtId;
        this.cmtCont = cmtCont;
        this.postId = postId;
        this.cmtParentId = cmtParentId;
        this.userId = userId;
        this.cmtType = cmtType;
        this.cmtTargetUserId = cmtTargetUserId;
        this.cmtCreateTime = cmtCreateTime;
        this.comments = comments;
    }
}