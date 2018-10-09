package com.jit.demo.mappers;

import com.jit.demo.models.DeviceCurrent;
import com.jit.demo.models.DeviceCurrentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceCurrentMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table device_current
     *
     * @mbggenerated Wed Apr 04 12:37:59 CST 2018
     */
    int countByExample(DeviceCurrentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table device_current
     *
     * @mbggenerated Wed Apr 04 12:37:59 CST 2018
     */
    int deleteByExample(DeviceCurrentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table device_current
     *
     * @mbggenerated Wed Apr 04 12:37:59 CST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table device_current
     *
     * @mbggenerated Wed Apr 04 12:37:59 CST 2018
     */
    int insert(DeviceCurrent record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table device_current
     *
     * @mbggenerated Wed Apr 04 12:37:59 CST 2018
     */
    int insertSelective(DeviceCurrent record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table device_current
     *
     * @mbggenerated Wed Apr 04 12:37:59 CST 2018
     */
    List<DeviceCurrent> selectByExample(DeviceCurrentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table device_current
     *
     * @mbggenerated Wed Apr 04 12:37:59 CST 2018
     */
    DeviceCurrent selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table device_current
     *
     * @mbggenerated Wed Apr 04 12:37:59 CST 2018
     */
    int updateByExampleSelective(@Param("record") DeviceCurrent record, @Param("example") DeviceCurrentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table device_current
     *
     * @mbggenerated Wed Apr 04 12:37:59 CST 2018
     */
    int updateByExample(@Param("record") DeviceCurrent record, @Param("example") DeviceCurrentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table device_current
     *
     * @mbggenerated Wed Apr 04 12:37:59 CST 2018
     */
    int updateByPrimaryKeySelective(DeviceCurrent record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table device_current
     *
     * @mbggenerated Wed Apr 04 12:37:59 CST 2018
     */
    int updateByPrimaryKey(DeviceCurrent record);

    String selectDeviceCurrentStatus(DeviceCurrent deviceCurrent);

}