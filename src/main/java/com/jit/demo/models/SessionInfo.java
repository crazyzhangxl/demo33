package com.jit.demo.models;

import org.apache.mina.core.session.IoSession;

/**
 * Created by 张先磊 on 2018/3/24.
 * 这里的话,字段还是需要进行添加的
 * 比如对应的存储设备的id
 *
 *
 */
public class SessionInfo {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private long long_time;

    public long getLong_time() {
        return long_time;
    }

    public void setLong_time(long long_time) {
        this.long_time = long_time;
    }

    public SessionInfo(int id, IoSession session, String deviceId, String address) {
        this.id = id;
        this.session = session;
        this.deviceId = deviceId;
        this.address = address;
    }

    // 用于控制的IoSession
    private IoSession session;
    // 设备的id号,其实这里我只需要存放deviceId
    private String deviceId;

    private String address;

    public SessionInfo(IoSession session, String deviceId, String address) {
        this.session = session;
        this.deviceId = deviceId;
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public IoSession getSession() {
        return session;
    }

    public void setSession(IoSession session) {
        this.session = session;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }


    @Override
    public String toString() {
        return "SessionInfo{" +
                "id=" + id + '\'' +
                ", deviceID=" + deviceId + '\'' +
                ", address=" + address + '\'' +
                '}';
    }
}
