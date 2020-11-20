package top.testcross.zuji.bean;

import lombok.Data;
import top.testcross.zuji.bean.interfaces.DataBean;

/**
 * Table: uim_user
 */
@Data
public class UimUser implements DataBean {
    /**
     * 用户id
     *
     * Column:    user_id
     * Nullable:  false
     */
    private String userId;

    /**
     * 用户打卡数
     *
     * Column:    user_post_count
     * Nullable:  false
     */
    private Integer userPostCount;

    /**
     * 用户图片数
     *
     * Column:    user_img_count
     * Nullable:  false
     */
    private Integer userImgCount;

    /**
     * 用户性别
     *
     * Column:    user_sex
     * Nullable:  false
     */
    private Byte userSex;

    /**
     * 用户赞与收藏数
     *
     * Column:    user_laf_count
     * Nullable:  false
     */
    private Integer userLafCount;

    /**
     * 用户昵称
     *
     * Column:    user_name
     * Nullable:  false
     */
    private String userName;

    /**
     * 用户头像，资源位置
     *
     * Column:    user_dp_id
     * Nullable:  false
     */
    private String userDpId;

    /**
     * 用户密码
     *
     * Column:    user_password
     * Nullable:  false
     */
    private String userPassword;

    /**
     * 用户简介
     *
     * Column:    user_intro
     * Nullable:  true
     */
    private String userIntro;

    /**
     * 用户粉丝数
     *
     * Column:    user_follower_count
     * Nullable:  false
     */
    private Integer userFollowerCount;

    /**
     * 用户关注数
     *
     * Column:    user_follow_count
     * Nullable:  false
     */
    private Integer userFollowCount;

    @Override
    public void setUUID(String uuid) {
        setUserId(uuid);
    }

    @Override
    public String getUUID() {
        return getUserId();
    }

    public UimUser() {
    }

    public UimUser(String userId, Integer userPostCount, Integer userImgCount, Byte userSex, Integer userLafCount, String userName, String userDpId, String userPassword, String userIntro, Integer userFollowerCount, Integer userFollowCount) {
        this.userId = userId;
        this.userPostCount = userPostCount;
        this.userImgCount = userImgCount;
        this.userSex = userSex;
        this.userLafCount = userLafCount;
        this.userName = userName;
        this.userDpId = userDpId;
        this.userPassword = userPassword;
        this.userIntro = userIntro;
        this.userFollowerCount = userFollowerCount;
        this.userFollowCount = userFollowCount;
    }
}