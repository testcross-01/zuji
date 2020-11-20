package top.testcross.zuji.bean;

import java.util.Date;
import java.util.List;

import lombok.Data;
import top.testcross.zuji.bean.interfaces.DataBean;

/**
 * Table: pm_post
 */
@Data
public class PmPost implements DataBean {
    /**
     * 动态id
     *
     * Column:    post_id
     * Nullable:  false
     */
    private String postId;

    /**
     * 动态点赞数
     *
     * Column:    post_like_count
     * Nullable:  false
     */
    private Integer postLikeCount;

    /**
     * 动态收藏数
     *
     * Column:    post_fav_count
     * Nullable:  false
     */
    private Integer postFavCount;

    /**
     * 动态评论数
     *
     * Column:    post_cmt_count
     * Nullable:  false
     */
    private Integer postCmtCount;

    /**
     * 动态图片数
     *
     * Column:    post_img_count
     * Nullable:  false
     */
    private Integer postImgCount;

    /**
     * 动态封面对应图片id
     *
     * Column:    post_cp_img_id
     * Nullable:  false
     */
    private String postCpImgId;

    /**
     * 动态可见性
     *
     * Column:    post_visible
     * Nullable:  false
     */
    private Boolean postVisible;

    /**
     * 动态描述对应评论id
     *
     * Column:    post_intro_comment_id
     * Nullable:  false
     */
    private String postIntroCommentId;

    /**
     * 动态描述
     *
     * Column:    post_intro
     * Nullable:  false
     */
    private String postIntro;

    /**
     * 位置id
     *
     * Column:    pi_id
     * Nullable:  false
     */
    private String piId;

    /**
     * 用户id
     *
     * Column:    user_id
     * Nullable:  false
     */
    private String userId;

    /**
     * 动态创建时间
     *
     * Column:    post_create_time
     * Nullable:  false
     */
    private Date postCreateTime;



    /**
     * 动态的位置信息
     */
    private BmGeoPlaceinfo placeinfo;

    /**
     * 动态图片
     */
    private List<BmImg> imgs;


    /**
     * 动态的所有tag
     */
    private List<BmTag> tags;

    /**
     * 封面图片
     */
    private BmImg cpImg;

    /**
     * 当前用户对应此动态的fav id
     */
    String favId;

    /**
     * 当前用户对应此动态的like id
     */
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
}