package top.testcross.zuji.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import top.testcross.zuji.bean.BmUserMark;
import top.testcross.zuji.bean.BmUserMarkExample;

public interface BmUserMarkMapper extends  Mapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bm_user_mark
     *
     * @mbggenerated Fri Nov 13 23:23:31 GMT+08:00 2020
     */
    int countByExample(BmUserMarkExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bm_user_mark
     *
     * @mbggenerated Fri Nov 13 23:23:31 GMT+08:00 2020
     */
    int deleteByExample(BmUserMarkExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bm_user_mark
     *
     * @mbggenerated Fri Nov 13 23:23:31 GMT+08:00 2020
     */
    int deleteByPrimaryKey(String umId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bm_user_mark
     *
     * @mbggenerated Fri Nov 13 23:23:31 GMT+08:00 2020
     */
    int insert(BmUserMark record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bm_user_mark
     *
     * @mbggenerated Fri Nov 13 23:23:31 GMT+08:00 2020
     */
    int insertSelective(BmUserMark record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bm_user_mark
     *
     * @mbggenerated Fri Nov 13 23:23:31 GMT+08:00 2020
     */
    List<BmUserMark> selectByExample(BmUserMarkExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bm_user_mark
     *
     * @mbggenerated Fri Nov 13 23:23:31 GMT+08:00 2020
     */
    BmUserMark selectByPrimaryKey(String umId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bm_user_mark
     *
     * @mbggenerated Fri Nov 13 23:23:31 GMT+08:00 2020
     */
    int updateByExampleSelective(@Param("record") BmUserMark record, @Param("example") BmUserMarkExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bm_user_mark
     *
     * @mbggenerated Fri Nov 13 23:23:31 GMT+08:00 2020
     */
    int updateByExample(@Param("record") BmUserMark record, @Param("example") BmUserMarkExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bm_user_mark
     *
     * @mbggenerated Fri Nov 13 23:23:31 GMT+08:00 2020
     */
    int updateByPrimaryKeySelective(BmUserMark record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bm_user_mark
     *
     * @mbggenerated Fri Nov 13 23:23:31 GMT+08:00 2020
     */
    int updateByPrimaryKey(BmUserMark record);
}