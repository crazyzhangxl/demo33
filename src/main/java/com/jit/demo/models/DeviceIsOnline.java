package com.jit.demo.models;

import java.io.Serializable;

/**
 * Created by 张先磊 on 2018/5/21.
 * 呵呵 这里必须是private 而且包含set和 get方法的啊
 */
public class DeviceIsOnline {
      private   String deviceId;
      private boolean isOnline;

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public boolean isOnline() {
        return isOnline;
    }

    public void setOnline(boolean online) {
        isOnline = online;
    }

    public DeviceIsOnline(String deviceId, boolean isOnline) {
        this.deviceId = deviceId;
        this.isOnline = isOnline;
    }
}
