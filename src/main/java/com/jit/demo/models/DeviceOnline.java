package com.jit.demo.models;

import java.util.Date;

public class DeviceOnline {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column device_online.id
     *
     * @mbggenerated Wed Apr 04 12:37:59 CST 2018
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column device_online.device_number
     *
     * @mbggenerated Wed Apr 04 12:37:59 CST 2018
     */
    private String deviceNumber;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column device_online.on_time
     *
     * @mbggenerated Wed Apr 04 12:37:59 CST 2018
     */
    private Date onTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column device_online.off_time
     *
     * @mbggenerated Wed Apr 04 12:37:59 CST 2018
     */
    private Date offTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table device_online
     *
     * @mbggenerated Wed Apr 04 12:37:59 CST 2018
     */
    public DeviceOnline(Integer id, String deviceNumber, Date onTime, Date offTime) {
        this.id = id;
        this.deviceNumber = deviceNumber;
        this.onTime = onTime;
        this.offTime = offTime;
    }

    public DeviceOnline(Integer id, String deviceNumber, Date offTime) {
        this.id = id;
        this.deviceNumber = deviceNumber;
        this.offTime = offTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table device_online
     *
     * @mbggenerated Wed Apr 04 12:37:59 CST 2018
     */
    public DeviceOnline() {
        super();
    }

    public DeviceOnline(String deviceNumber, Date onTime) {
        this.deviceNumber = deviceNumber;
        this.onTime = onTime;
    }



    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column device_online.id
     *
     * @return the value of device_online.id
     *
     * @mbggenerated Wed Apr 04 12:37:59 CST 2018
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column device_online.id
     *
     * @param id the value for device_online.id
     *
     * @mbggenerated Wed Apr 04 12:37:59 CST 2018
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column device_online.device_number
     *
     * @return the value of device_online.device_number
     *
     * @mbggenerated Wed Apr 04 12:37:59 CST 2018
     */
    public String getDeviceNumber() {
        return deviceNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column device_online.device_number
     *
     * @param deviceNumber the value for device_online.device_number
     *
     * @mbggenerated Wed Apr 04 12:37:59 CST 2018
     */
    public void setDeviceNumber(String deviceNumber) {
        this.deviceNumber = deviceNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column device_online.on_time
     *
     * @return the value of device_online.on_time
     *
     * @mbggenerated Wed Apr 04 12:37:59 CST 2018
     */
    public Date getOnTime() {
        return onTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column device_online.on_time
     *
     * @param onTime the value for device_online.on_time
     *
     * @mbggenerated Wed Apr 04 12:37:59 CST 2018
     */
    public void setOnTime(Date onTime) {
        this.onTime = onTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column device_online.off_time
     *
     * @return the value of device_online.off_time
     *
     * @mbggenerated Wed Apr 04 12:37:59 CST 2018
     */
    public Date getOffTime() {
        return offTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column device_online.off_time
     *
     * @param offTime the value for device_online.off_time
     *
     * @mbggenerated Wed Apr 04 12:37:59 CST 2018
     */
    public void setOffTime(Date offTime) {
        this.offTime = offTime;
    }
}