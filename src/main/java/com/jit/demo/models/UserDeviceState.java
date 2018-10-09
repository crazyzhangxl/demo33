package com.jit.demo.models;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 张先磊 on 2018/5/21.
 */
public class UserDeviceState {
    private int userId;
    private ArrayList<DeviceIsOnline> mDeviceStateLists;
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public ArrayList<DeviceIsOnline> getmDeviceStateLists() {
        return mDeviceStateLists;
    }

    public void setmDeviceStateLists(ArrayList<DeviceIsOnline> mDeviceStateLists) {
        this.mDeviceStateLists = mDeviceStateLists;
    }
}
