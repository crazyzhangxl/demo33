package com.jit.demo.models;

import java.util.Date;

public class DeviceState {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column device_state.id
     *
     * @mbggenerated Wed Apr 04 12:37:59 CST 2018
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column device_state.device_number
     *
     * @mbggenerated Wed Apr 04 12:37:59 CST 2018
     */
    private String deviceNumber;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column device_state.ip
     *
     * @mbggenerated Wed Apr 04 12:37:59 CST 2018
     */
    private String ip;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column device_state.state_value
     *
     * @mbggenerated Wed Apr 04 12:37:59 CST 2018
     */
    private String stateValue;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column device_state.time
     *
     * @mbggenerated Wed Apr 04 12:37:59 CST 2018
     */
    private Date time;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table device_state
     *
     * @mbggenerated Wed Apr 04 12:37:59 CST 2018
     */
    public DeviceState(Integer id, String deviceNumber, String ip, String stateValue, Date time) {
        this.id = id;
        this.deviceNumber = deviceNumber;
        this.ip = ip;
        this.stateValue = stateValue;
        this.time = time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table device_state
     *
     * @mbggenerated Wed Apr 04 12:37:59 CST 2018
     */
    public DeviceState() {
        super();
    }

    public DeviceState(String deviceNumber, String ip, String stateValue, Date time) {
        this.deviceNumber = deviceNumber;
        this.ip = ip;
        this.stateValue = stateValue;
        this.time = time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column device_state.id
     *
     * @return the value of device_state.id
     *
     * @mbggenerated Wed Apr 04 12:37:59 CST 2018
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column device_state.id
     *
     * @param id the value for device_state.id
     *
     * @mbggenerated Wed Apr 04 12:37:59 CST 2018
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column device_state.device_number
     *
     * @return the value of device_state.device_number
     *
     * @mbggenerated Wed Apr 04 12:37:59 CST 2018
     */
    public String getDeviceNumber() {
        return deviceNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column device_state.device_number
     *
     * @param deviceNumber the value for device_state.device_number
     *
     * @mbggenerated Wed Apr 04 12:37:59 CST 2018
     */
    public void setDeviceNumber(String deviceNumber) {
        this.deviceNumber = deviceNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column device_state.ip
     *
     * @return the value of device_state.ip
     *
     * @mbggenerated Wed Apr 04 12:37:59 CST 2018
     */
    public String getIp() {
        return ip;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column device_state.ip
     *
     * @param ip the value for device_state.ip
     *
     * @mbggenerated Wed Apr 04 12:37:59 CST 2018
     */
    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column device_state.state_value
     *
     * @return the value of device_state.state_value
     *
     * @mbggenerated Wed Apr 04 12:37:59 CST 2018
     */
    public String getStateValue() {
        return stateValue;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column device_state.state_value
     *
     * @param stateValue the value for device_state.state_value
     *
     * @mbggenerated Wed Apr 04 12:37:59 CST 2018
     */
    public void setStateValue(String stateValue) {
        this.stateValue = stateValue == null ? null : stateValue.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column device_state.time
     *
     * @return the value of device_state.time
     *
     * @mbggenerated Wed Apr 04 12:37:59 CST 2018
     */
    public Date getTime() {
        return time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column device_state.time
     *
     * @param time the value for device_state.time
     *
     * @mbggenerated Wed Apr 04 12:37:59 CST 2018
     */
    public void setTime(Date time) {
        this.time = time;
    }
}