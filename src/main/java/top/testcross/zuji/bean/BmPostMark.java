package top.testcross.zuji.bean;

import lombok.Data;
import top.testcross.zuji.bean.interfaces.DataBean;

/**
 * Table: bm_post_mark
 */
@Data
public class BmPostMark implements DataBean {
    /**
     * 用户标签id
     *
     * Column:    pm_id
     * Nullable:  false
     */
    private String pmId;

    /**
     * 动态id
     *
     * Column:    post_id
     * Nullable:  false
     */
    private String postId;

    /**
     * 标签id
     *
     * Column:    tag_id
     * Nullable:  false
     */
    private String tagId;

    @Override
    public void setUUID(String uuid) {
        setPmId(uuid);
    }

    @Override
    public String getUUID() {
        return getPmId();
    }

    public BmPostMark(){

    }

    public BmPostMark(String pmId, String postId, String tagId) {
        this.pmId = pmId;
        this.postId = postId;
        this.tagId = tagId;
    }
}