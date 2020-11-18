package top.testcross.zuji.bean;

import lombok.Data;
import top.testcross.zuji.bean.interfaces.DataBean;

/**
 * Table: bm_user_mark
 */
@Data
public class BmUserMark implements DataBean {
    /**
     * 用户标签id
     *
     * Column:    um_id
     * Nullable:  false
     */
    private String umId;

    /**
     * 用户id
     *
     * Column:    user_id
     * Nullable:  false
     */
    private String userId;

    /**
     * 标签id
     *
     * Column:    tag_id
     * Nullable:  false
     */
    private String tagId;

    @Override
    public void setUUID(String uuid) {
        setUmId(uuid);
    }
}