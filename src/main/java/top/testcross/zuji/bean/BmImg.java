package top.testcross.zuji.bean;

import lombok.Data;
import top.testcross.zuji.bean.interfaces.DataBean;

/**
 * Table: bm_img
 */
@Data
public class BmImg implements DataBean {
    /**
     * 图片id
     *
     * Column:    img_id
     * Nullable:  false
     */
    private String imgId;

    /**
     * 图片来源id
     *
     * Column:    img_src_id
     * Nullable:  false
     */
    private String imgSrcId;

    /**
     * 图片来源类型
     *
     * Column:    img_src_type
     * Nullable:  false
     */
    private Byte imgSrcType;

    /**
     * 图片内容
     *
     * Column:    img_cont
     * Nullable:  false
     */
    private String imgCont;

    /**
     * 审核状态
     *
     * Column:    audit_status
     * Nullable:  false
     */
    private Boolean auditStatus;

    @Override
    public void setUUID(String uuid) {
        setImgId(uuid);
    }
}