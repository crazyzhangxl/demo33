package com.jit.demo.components;

import com.jit.demo.mappers.*;
import com.jit.demo.models.DeviceInfo;
import com.jit.demo.models.DeviceOnline;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by nsizm on 2018/8/3.
 */
@Service
public class DataService {

    @Autowired
    AutoStartMapper autoStartMapper;

    @Autowired
    DeviceCurrentMapper deviceCurrentMapper;

    @Autowired
    DeviceInfoMapper deviceInfoMapper;

    @Autowired
    DeviceOnlineMapper deviceOnlineMapper;

    @Autowired
    DeviceStateMapper deviceStateMapper;

    @Autowired
    UserBindingDeviceMapper userBindingDeviceMapper;


    public DeviceInfo getDeviceInfoByID(String deviceID){
        return deviceInfoMapper.selectByPrimaryKey(deviceID);
    }

    public void insertDeviceInfo(String deviceID){
        deviceInfoMapper.insert(new DeviceInfo(deviceID));
    }

    public void insertDeviceOnline(DeviceOnline deviceOnline){
        deviceOnlineMapper.insert(deviceOnline);
    }
}
