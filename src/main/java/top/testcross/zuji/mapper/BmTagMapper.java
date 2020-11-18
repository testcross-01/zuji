package top.testcross.zuji.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import top.testcross.zuji.bean.BmTag;
import top.testcross.zuji.bean.BmTagExample;

public interface BmTagMapper extends  Mapper{
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bm_tag
     *
     * @mbggenerated Fri Nov 13 23:23:31 GMT+08:00 2020
     */
    int countByExample(BmTagExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bm_tag
     *
     * @mbggenerated Fri Nov 13 23:23:31 GMT+08:00 2020
     */
    int deleteByExample(BmTagExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bm_tag
     *
     * @mbggenerated Fri Nov 13 23:23:31 GMT+08:00 2020
     */
    int deleteByPrimaryKey(String tagId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bm_tag
     *
     * @mbggenerated Fri Nov 13 23:23:31 GMT+08:00 2020
     */
    int insert(BmTag record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bm_tag
     *
     * @mbggenerated Fri Nov 13 23:23:31 GMT+08:00 2020
     */
    int insertSelective(BmTag record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bm_tag
     *
     * @mbggenerated Fri Nov 13 23:23:31 GMT+08:00 2020
     */
    List<BmTag> selectByExample(BmTagExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bm_tag
     *
     * @mbggenerated Fri Nov 13 23:23:31 GMT+08:00 2020
     */
    BmTag selectByPrimaryKey(String tagId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bm_tag
     *
     * @mbggenerated Fri Nov 13 23:23:31 GMT+08:00 2020
     */
    int updateByExampleSelective(@Param("record") BmTag record, @Param("example") BmTagExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bm_tag
     *
     * @mbggenerated Fri Nov 13 23:23:31 GMT+08:00 2020
     */
    int updateByExample(@Param("record") BmTag record, @Param("example") BmTagExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bm_tag
     *
     * @mbggenerated Fri Nov 13 23:23:31 GMT+08:00 2020
     */
    int updateByPrimaryKeySelective(BmTag record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bm_tag
     *
     * @mbggenerated Fri Nov 13 23:23:31 GMT+08:00 2020
     */
    int updateByPrimaryKey(BmTag record);
}