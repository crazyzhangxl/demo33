package com.jit.demo.models;

import java.util.Date;

public class DeviceCurrent {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column device_current.id
     *
     * @mbggenerated Wed Apr 04 12:37:59 CST 2018
     */
    private Integer id;

    public DeviceCurrent(String deviceNumber, String ip, String currentValue, Date time) {
        this.deviceNumber = deviceNumber;
        this.ip = ip;
        this.currentValue = currentValue;
        this.time = time;
    }

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column device_current.device_number
     *
     * @mbggenerated Wed Apr 04 12:37:59 CST 2018
     */
    private String deviceNumber;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column device_current.ip
     *
     * @mbggenerated Wed Apr 04 12:37:59 CST 2018
     */
    private String ip;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column device_current.current_value
     *
     * @mbggenerated Wed Apr 04 12:37:59 CST 2018
     */
    private String currentValue;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column device_current.time
     *
     * @mbggenerated Wed Apr 04 12:37:59 CST 2018
     */
    private Date time;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table device_current
     *
     * @mbggenerated Wed Apr 04 12:37:59 CST 2018
     */
    public DeviceCurrent(Integer id, String deviceNumber, String ip, String currentValue, Date time) {
        this.id = id;
        this.deviceNumber = deviceNumber;
        this.ip = ip;
        this.currentValue = currentValue;
        this.time = time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table device_current
     *
     * @mbggenerated Wed Apr 04 12:37:59 CST 2018
     */
    public DeviceCurrent() {
        super();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column device_current.id
     *
     * @return the value of device_current.id
     *
     * @mbggenerated Wed Apr 04 12:37:59 CST 2018
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column device_current.id
     *
     * @param id the value for device_current.id
     *
     * @mbggenerated Wed Apr 04 12:37:59 CST 2018
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column device_current.device_number
     *
     * @return the value of device_current.device_number
     *
     * @mbggenerated Wed Apr 04 12:37:59 CST 2018
     */
    public String getDeviceNumber() {
        return deviceNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column device_current.device_number
     *
     * @param deviceNumber the value for device_current.device_number
     *
     * @mbggenerated Wed Apr 04 12:37:59 CST 2018
     */
    public void setDeviceNumber(String deviceNumber) {
        this.deviceNumber = deviceNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column device_current.ip
     *
     * @return the value of device_current.ip
     *
     * @mbggenerated Wed Apr 04 12:37:59 CST 2018
     */
    public String getIp() {
        return ip;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column device_current.ip
     *
     * @param ip the value for device_current.ip
     *
     * @mbggenerated Wed Apr 04 12:37:59 CST 2018
     */
    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column device_current.current_value
     *
     * @return the value of device_current.current_value
     *
     * @mbggenerated Wed Apr 04 12:37:59 CST 2018
     */
    public String getCurrentValue() {
        return currentValue;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column device_current.current_value
     *
     * @param currentValue the value for device_current.current_value
     *
     * @mbggenerated Wed Apr 04 12:37:59 CST 2018
     */
    public void setCurrentValue(String currentValue) {
        this.currentValue = currentValue == null ? null : currentValue.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column device_current.time
     *
     * @return the value of device_current.time
     *
     * @mbggenerated Wed Apr 04 12:37:59 CST 2018
     */
    public Date getTime() {
        return time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column device_current.time
     *
     * @param time the value for device_current.time
     *
     * @mbggenerated Wed Apr 04 12:37:59 CST 2018
     */
    public void setTime(Date time) {
        this.time = time;
    }
}