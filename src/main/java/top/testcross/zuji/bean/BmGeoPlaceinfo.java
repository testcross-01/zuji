package top.testcross.zuji.bean;

import lombok.Data;
import top.testcross.zuji.bean.interfaces.DataBean;

/**
 * Table: bm_geo_placeinfo
 */
@Data
public class BmGeoPlaceinfo implements DataBean {
    /**
     * 地址id
     *
     * Column:    pi_id
     * Nullable:  false
     */
    private String piId;

    /**
     * 地址信息
     *
     * Column:    pi_address
     * Nullable:  false
     */
    private String piAddress;

    /**
     * Column:    pi_city
     * Nullable:  false
     */
    private String piCity;

    /**
     * 国家
     *
     * Column:    pi_country
     * Nullable:  false
     */
    private String piCountry;

    /**
     * poi类型
     *
     * Column:    pi_poi_type
     * Nullable:  false
     */
    private String piPoiType;

    /**
     * 地点名称
     *
     * Column:    pi_name
     * Nullable:  false
     */
    private String piName;

    @Override
    public void setUUID(String uuid) {
        setPiId(uuid);
    }

    public BmGeoPlaceinfo(){

    }

    public BmGeoPlaceinfo(String piId, String piAddress, String piCity, String piCountry, String piPoiType, String piName) {
        this.piId = piId;
        this.piAddress = piAddress;
        this.piCity = piCity;
        this.piCountry = piCountry;
        this.piPoiType = piPoiType;
        this.piName = piName;
    }
}