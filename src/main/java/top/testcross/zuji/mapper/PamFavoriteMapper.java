package top.testcross.zuji.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import top.testcross.zuji.bean.PamFavorite;
import top.testcross.zuji.bean.PamFavoriteExample;

public interface PamFavoriteMapper extends Mapper{
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pam_favorite
     *
     * @mbggenerated Sun Nov 15 12:07:48 GMT+08:00 2020
     */
    int countByExample(PamFavoriteExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pam_favorite
     *
     * @mbggenerated Sun Nov 15 12:07:48 GMT+08:00 2020
     */
    int deleteByExample(PamFavoriteExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pam_favorite
     *
     * @mbggenerated Sun Nov 15 12:07:48 GMT+08:00 2020
     */
    int deleteByPrimaryKey(String favId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pam_favorite
     *
     * @mbggenerated Sun Nov 15 12:07:48 GMT+08:00 2020
     */
    int insert(PamFavorite record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pam_favorite
     *
     * @mbggenerated Sun Nov 15 12:07:48 GMT+08:00 2020
     */
    int insertSelective(PamFavorite record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pam_favorite
     *
     * @mbggenerated Sun Nov 15 12:07:48 GMT+08:00 2020
     */
    List<PamFavorite> selectByExample(PamFavoriteExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pam_favorite
     *
     * @mbggenerated Sun Nov 15 12:07:48 GMT+08:00 2020
     */
    PamFavorite selectByPrimaryKey(String favId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pam_favorite
     *
     * @mbggenerated Sun Nov 15 12:07:48 GMT+08:00 2020
     */
    int updateByExampleSelective(@Param("record") PamFavorite record, @Param("example") PamFavoriteExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pam_favorite
     *
     * @mbggenerated Sun Nov 15 12:07:48 GMT+08:00 2020
     */
    int updateByExample(@Param("record") PamFavorite record, @Param("example") PamFavoriteExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pam_favorite
     *
     * @mbggenerated Sun Nov 15 12:07:48 GMT+08:00 2020
     */
    int updateByPrimaryKeySelective(PamFavorite record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pam_favorite
     *
     * @mbggenerated Sun Nov 15 12:07:48 GMT+08:00 2020
     */
    int updateByPrimaryKey(PamFavorite record);
}