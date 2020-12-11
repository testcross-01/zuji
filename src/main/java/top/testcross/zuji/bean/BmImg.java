package top.testcross.zuji.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import top.testcross.zuji.bean.interfaces.DataBean;

/**
 * Table: bm_img
 */
@Data
@ApiModel(description = "图片")
public class BmImg implements DataBean {
    /**
     * 图片id
     *
     * Column:    img_id
     * Nullable:  false
     */
    @ApiModelProperty("图片id")
    private String imgId;

    /**
     * 图片来源id
     *
     * Column:    img_src_id
     * Nullable:  false
     */
    @ApiModelProperty("图片来源id")
    private String imgSrcId;

    /**
     * 图片来源类型
     *
     * Column:    img_src_type
     * Nullable:  false
     */
    @ApiModelProperty("图片来源类型")
    private Byte imgSrcType;

    /**
     * 图片内容
     *
     * Column:    img_cont
     * Nullable:  false
     */
    @ApiModelProperty("图片内容")
    private String imgCont;

    /**
     * 审核状态
     *
     * Column:    audit_status
     * Nullable:  false
     */
    @ApiModelProperty("图片内容")
    private Boolean auditStatus;

    @Override
    public void setUUID(String uuid) {
        setImgId(uuid);
    }

    @Override
    public String getUUID() {
        return getImgId();
    }

    public BmImg(){

    }

    public BmImg(String imgId, String imgSrcId, Byte imgSrcType, String imgCont, Boolean auditStatus) {
        this.imgId = imgId;
        this.imgSrcId = imgSrcId;
        this.imgSrcType = imgSrcType;
        this.imgCont = imgCont;
        this.auditStatus = auditStatus;
    }
}