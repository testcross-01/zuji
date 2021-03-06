package top.testcross.zuji.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import top.testcross.zuji.bean.UimFollow;
import top.testcross.zuji.bean.UimFollowExample;

public interface UimFollowMapper extends Mapper{
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table uim_follow
     *
     * @mbggenerated Fri Nov 13 23:23:31 GMT+08:00 2020
     */
    int countByExample(UimFollowExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table uim_follow
     *
     * @mbggenerated Fri Nov 13 23:23:31 GMT+08:00 2020
     */
    int deleteByExample(UimFollowExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table uim_follow
     *
     * @mbggenerated Fri Nov 13 23:23:31 GMT+08:00 2020
     */
    int deleteByPrimaryKey(String followId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table uim_follow
     *
     * @mbggenerated Fri Nov 13 23:23:31 GMT+08:00 2020
     */
    int insert(UimFollow record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table uim_follow
     *
     * @mbggenerated Fri Nov 13 23:23:31 GMT+08:00 2020
     */
    int insertSelective(UimFollow record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table uim_follow
     *
     * @mbggenerated Fri Nov 13 23:23:31 GMT+08:00 2020
     */
    List<UimFollow> selectByExample(UimFollowExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table uim_follow
     *
     * @mbggenerated Fri Nov 13 23:23:31 GMT+08:00 2020
     */
    UimFollow selectByPrimaryKey(String followId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table uim_follow
     *
     * @mbggenerated Fri Nov 13 23:23:31 GMT+08:00 2020
     */
    int updateByExampleSelective(@Param("record") UimFollow record, @Param("example") UimFollowExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table uim_follow
     *
     * @mbggenerated Fri Nov 13 23:23:31 GMT+08:00 2020
     */
    int updateByExample(@Param("record") UimFollow record, @Param("example") UimFollowExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table uim_follow
     *
     * @mbggenerated Fri Nov 13 23:23:31 GMT+08:00 2020
     */
    int updateByPrimaryKeySelective(UimFollow record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table uim_follow
     *
     * @mbggenerated Fri Nov 13 23:23:31 GMT+08:00 2020
     */
    int updateByPrimaryKey(UimFollow record);
}