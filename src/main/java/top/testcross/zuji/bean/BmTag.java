package top.testcross.zuji.bean;

import lombok.Data;
import top.testcross.zuji.bean.interfaces.DataBean;

/**
 * Table: bm_tag
 */
@Data
public class BmTag implements DataBean {
    /**
     * 标签id
     *
     * Column:    tag_id
     * Nullable:  false
     */
    private String tagId;

    /**
     * 标签名
     *
     * Column:    tag_name
     * Nullable:  false
     */
    private String tagName;

    /**
     * 标签介绍
     *
     * Column:    tag_intro
     * Nullable:  false
     */
    private String tagIntro;

    /**
     * 标签类型
     *
     * Column:    tag_type
     * Nullable:  false
     */
    private Byte tagType;

    @Override
    public void setUUID(String uuid) {
        setTagId(uuid);
    }
}