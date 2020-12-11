package top.testcross.zuji.bean;

import java.util.Date;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import top.testcross.zuji.bean.interfaces.ActionDataBean;
import top.testcross.zuji.bean.interfaces.DataBean;

/**
 * Table: pm_post
 */
@Data
@ApiModel(description = "动态模型")
public class PmPost implements ActionDataBean {
    /**
     * 动态id
     *
     * Column:    post_id
     * Nullable:  false
     */
    @ApiModelProperty("动态id")
    private String postId;

    /**
     * 动态点赞数
     *
     * Column:    post_like_count
     * Nullable:  false
     */
    @ApiModelProperty("动态点赞数")
    private Integer postLikeCount;

    /**
     * 动态收藏数
     *
     * Column:    post_fav_count
     * Nullable:  false
     */
    @ApiModelProperty("动态收藏数")
    private Integer postFavCount;

    /**
     * 动态评论数
     *
     * Column:    post_cmt_count
     * Nullable:  false
     */
    @ApiModelProperty("动态评论数")
    private Integer postCmtCount;

    /**
     * 动态图片数
     *
     * Column:    post_img_count
     * Nullable:  false
     */
    @ApiModelProperty("动态图片数")
    private Integer postImgCount;

    /**
     * 动态封面对应图片id
     *
     * Column:    post_cp_img_id
     * Nullable:  true
     */
    @ApiModelProperty(value = "动态封面对应图片id",notes = "前端无需提供")
    private String postCpImgId;

    /**
     * 动态可见性
     *
     * Column:    post_visible
     * Nullable:  false
     */
    @ApiModelProperty(value = "动态可见性",notes = "其他人是否可见（暂未实现）")
    private Boolean postVisible;

    /**
     * 动态描述对应评论id
     *
     * Column:    post_intro_comment_id
     * Nullable:  false
     */
    @ApiModelProperty(value = "动态描述对应评论id",notes = "前端无需提供（暂未实现）")
    private String postIntroCommentId;

    /**
     * 动态描述
     *
     * Column:    post_intro
     * Nullable:  false
     */
    @ApiModelProperty(value = "动态描述")
    private String postIntro;

    /**
     * 位置id
     *
     * Column:    pi_id
     * Nullable:  false
     */
    @ApiModelProperty(value = "位置id",notes = "前端无需提供")
    private String piId;

    /**
     * 用户id
     *
     * Column:    user_id
     * Nullable:  false
     */
    @ApiModelProperty(value = "用户id")
    private String userId;

    /**
     * 动态创建时间
     *
     * Column:    post_create_time
     * Nullable:  false
     */
    @ApiModelProperty(value = "动态创建时间")
    private Date postCreateTime;



    /**
     * 动态的位置信息
     */
    @ApiModelProperty(value = "动态的位置信息")
    private BmGeoPlaceinfo placeinfo;

    /**
     * 动态图片
     */
    @ApiModelProperty(value = "动态图片")
    private List<BmImg> imgs;


    /**
     * 动态的所有tag
     */
    @ApiModelProperty(value = "动态的所有tag")
    private List<BmTag> tags;

    /**
     * 封面图片
     */
    @ApiModelProperty(value = "封面图片")
    private BmImg cpImg;

    /**
     * 当前用户对应此动态的fav id
     */
    @ApiModelProperty(value = "当前用户对应此动态的fav id",notes = "前端无需提供")
    String favId;

    /**
     * 当前用户对应此动态的like id
     */
    @ApiModelProperty(value = "当前用户对应此动态的like id",notes = "前端无需提供")
    String likeId;

    @Override
    public void setUUID(String uuid) {
        setPostId(uuid);
    }

    @Override
    public String getUUID() {
        return getPostId();
    }

    public PmPost() {
    }

    public PmPost(String postId, Integer postLikeCount, Integer postFavCount, Integer postCmtCount, Integer postImgCount, String postCpImgId, Boolean postVisible, String postIntroCommentId, String postIntro, String piId, String userId, Date postCreateTime, BmGeoPlaceinfo placeinfo, List<BmImg> imgs, List<BmTag> tags, BmImg cpImg) {
        this.postId = postId;
        this.postLikeCount = postLikeCount;
        this.postFavCount = postFavCount;
        this.postCmtCount = postCmtCount;
        this.postImgCount = postImgCount;
        this.postCpImgId = postCpImgId;
        this.postVisible = postVisible;
        this.postIntroCommentId = postIntroCommentId;
        this.postIntro = postIntro;
        this.piId = piId;
        this.userId = userId;
        this.postCreateTime = postCreateTime;
        this.placeinfo = placeinfo;
        this.imgs = imgs;
        this.tags = tags;
        this.cpImg = cpImg;
    }

    @Override
    public BmMessage createMessage() {
        if(userId==null||postCreateTime==null||postId==null)
            return new BmMessage();
        BmMessage message=new BmMessage(null,(byte)9,userId,postCreateTime,postId,false);
        return message;
    }

    @Override
    public BmMessage createUoDoMessage() {
        if(userId==null||postId==null)
            return new BmMessage();
        BmMessage message=new BmMessage(null,(byte)10,userId,new Date(System.currentTimeMillis()),postId,false);
        return message;
    }
}