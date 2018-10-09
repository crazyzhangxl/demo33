package com.jit.demo.mappers;

import com.jit.demo.models.AutoStart;
import com.jit.demo.models.AutoStartExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface AutoStartMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table auto_start
     *
     * @mbggenerated Wed Apr 04 12:37:59 CST 2018
     */
    int countByExample(AutoStartExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table auto_start
     *
     * @mbggenerated Wed Apr 04 12:37:59 CST 2018
     */
    int deleteByExample(AutoStartExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table auto_start
     *
     * @mbggenerated Wed Apr 04 12:37:59 CST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table auto_start
     *
     * @mbggenerated Wed Apr 04 12:37:59 CST 2018
     */
    int insert(AutoStart record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table auto_start
     *
     * @mbggenerated Wed Apr 04 12:37:59 CST 2018
     */
    int insertSelective(AutoStart record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table auto_start
     *
     * @mbggenerated Wed Apr 04 12:37:59 CST 2018
     */
    List<AutoStart> selectByExample(AutoStartExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table auto_start
     *
     * @mbggenerated Wed Apr 04 12:37:59 CST 2018
     */
    AutoStart selectByPrimaryKey(Integer id);

    AutoStart selectByDeviceNumber(String device_number);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table auto_start
     *
     * @mbggenerated Wed Apr 04 12:37:59 CST 2018
     */
    int updateByExampleSelective(@Param("record") AutoStart record, @Param("example") AutoStartExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table auto_start
     *
     * @mbggenerated Wed Apr 04 12:37:59 CST 2018
     */
    int updateByExample(@Param("record") AutoStart record, @Param("example") AutoStartExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table auto_start
     *
     * @mbggenerated Wed Apr 04 12:37:59 CST 2018
     */
    int updateByPrimaryKeySelective(AutoStart record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table auto_start
     *
     * @mbggenerated Wed Apr 04 12:37:59 CST 2018
     */
    int updateByPrimaryKey(AutoStart record);

    int updateAutoStart(AutoStart record);

}