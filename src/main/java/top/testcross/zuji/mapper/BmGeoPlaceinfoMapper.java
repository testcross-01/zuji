package top.testcross.zuji.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import top.testcross.zuji.bean.BmGeoPlaceinfo;
import top.testcross.zuji.bean.BmGeoPlaceinfoExample;

public interface BmGeoPlaceinfoMapper extends Mapper{
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bm_geo_placeinfo
     *
     * @mbggenerated Fri Nov 13 23:23:31 GMT+08:00 2020
     */
    int countByExample(BmGeoPlaceinfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bm_geo_placeinfo
     *
     * @mbggenerated Fri Nov 13 23:23:31 GMT+08:00 2020
     */
    int deleteByExample(BmGeoPlaceinfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bm_geo_placeinfo
     *
     * @mbggenerated Fri Nov 13 23:23:31 GMT+08:00 2020
     */
    int deleteByPrimaryKey(String piId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bm_geo_placeinfo
     *
     * @mbggenerated Fri Nov 13 23:23:31 GMT+08:00 2020
     */
    int insert(BmGeoPlaceinfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bm_geo_placeinfo
     *
     * @mbggenerated Fri Nov 13 23:23:31 GMT+08:00 2020
     */
    int insertSelective(BmGeoPlaceinfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bm_geo_placeinfo
     *
     * @mbggenerated Fri Nov 13 23:23:31 GMT+08:00 2020
     */
    List<BmGeoPlaceinfo> selectByExample(BmGeoPlaceinfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bm_geo_placeinfo
     *
     * @mbggenerated Fri Nov 13 23:23:31 GMT+08:00 2020
     */
    BmGeoPlaceinfo selectByPrimaryKey(String piId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bm_geo_placeinfo
     *
     * @mbggenerated Fri Nov 13 23:23:31 GMT+08:00 2020
     */
    int updateByExampleSelective(@Param("record") BmGeoPlaceinfo record, @Param("example") BmGeoPlaceinfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bm_geo_placeinfo
     *
     * @mbggenerated Fri Nov 13 23:23:31 GMT+08:00 2020
     */
    int updateByExample(@Param("record") BmGeoPlaceinfo record, @Param("example") BmGeoPlaceinfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bm_geo_placeinfo
     *
     * @mbggenerated Fri Nov 13 23:23:31 GMT+08:00 2020
     */
    int updateByPrimaryKeySelective(BmGeoPlaceinfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bm_geo_placeinfo
     *
     * @mbggenerated Fri Nov 13 23:23:31 GMT+08:00 2020
     */
    int updateByPrimaryKey(BmGeoPlaceinfo record);
}