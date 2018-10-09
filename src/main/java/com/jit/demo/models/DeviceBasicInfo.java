package com.jit.demo.models;

/**
 * Created by 张先磊 on 2018/3/28.
 */
public class DeviceBasicInfo {
    private int id;
    private String deviceId;
    private String name;

    public DeviceBasicInfo(String deviceId) {
        this.deviceId = deviceId;
    }


    public DeviceBasicInfo(String deviceId, String name) {
        this.deviceId = deviceId;
        this.name = name;
    }

    public DeviceBasicInfo(int id, String deviceId, String name) {
        this.id = id;
        this.deviceId = deviceId;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
