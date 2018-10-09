package com.jit.demo;

import com.jit.demo.components.DataService;
import com.jit.demo.components.JacksonUtils;
import com.jit.demo.components.SpringBeanFactory;
import com.jit.demo.mappers.*;
import com.jit.demo.models.*;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by 张先磊 on 2018/3/22.
 */
public class CTServerHandler extends IoHandlerAdapter {
    private final static Logger LOGGER = LoggerFactory.getLogger(CTServerHandler.class);
    private final Set<SessionInfo> sessions = Collections.synchronizedSet(new HashSet<SessionInfo>());
    private final Set<SessionInfo> sessions2 = Collections.synchronizedSet(new HashSet<SessionInfo>());
    private  static final DataService dataService = SpringBeanFactory.getBean(DataService.class);
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public CTServerHandler() {
        super();
    }
    // 这里会存在整个项目中

    @Override
    public void sessionCreated(IoSession session) throws Exception {
        super.sessionCreated(session);
        System.out.println("MinaServerHandler---sessionCreated");
    }

    @Override
    public void sessionOpened(IoSession session) throws Exception {
        super.sessionOpened(session);
    }

    @Override
    public void sessionIdle(IoSession session, IdleStatus status) throws Exception {
        super.sessionIdle(session, status);
        System.out.println("MinaServerHandler---sessionIdle");
    }

    @Override
    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
        LOGGER.warn("Unexpected exception:" + cause);
        cause.printStackTrace();
    }

    @Override
    public void messageReceived(IoSession session, Object message) throws Exception {

        String str = (String)message;
        String resultStr = "";
        String clientAddress = session.getRemoteAddress().toString().replace("/", "");
        System.out.println("接受来自 { "+clientAddress+"} 的信息:{"+str+"}\n");
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        File file = new File("log.txt");
        // 这里只是用于打印log信息,用于服务器观察
        if (!file.exists()) {
            file.createNewFile();
        }
        if (file.length() > 20000){
            file.delete();
            file.createNewFile();
        }
        FileOutputStream fileOutputStream = new FileOutputStream(file,true);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
        bufferedWriter.write("传输时间:"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())+" , 客户端地址{ "+clientAddress+"} , 信息:{"+str+"}\n");
        bufferedWriter.flush();

        String deviceId;// 模拟设备号
        String state_status;    // 模拟设备状态
        String current_status;  // 模拟设备的当前状态
       //3.29版本

        if (str.contains("ZHONGYU")){
            resultStr = "1.ACK";
            deviceId = str.trim().split(":")[1];
            // step1:将设备存入静态表中
            assert dataService != null;
            DeviceInfo deviceInfo = dataService.getDeviceInfoByID(deviceId);
            if (deviceInfo == null) {
                dataService.insertDeviceInfo(deviceId);
            }
            // step2: 放入在线设备表中
            DeviceOnline deviceOnline = new DeviceOnline(deviceId, new Date());
            dataService.insertDeviceOnline(deviceOnline);
            // ==============解决重复发送设备的问题======================
            // step3：带有id 将其存入在线的set中
            SessionInfo sessionInfo = new SessionInfo(deviceOnline.getId(), session, deviceId, clientAddress);
            // 新增当前的时间
            sessionInfo.setLong_time(System.currentTimeMillis());
            // 硬件设备加入SESSION中
            sessions.add(sessionInfo);
            // 以上是ok的
            // log.txt
            bufferedWriter.write("在线设备==========:"+deviceId+"\n");
            bufferedWriter.flush();
            // 将设备插入咯
        }else if (str.contains("STATE")){
            //获得设备的状态属性
            state_status = str.trim().split(":")[1];
            resultStr = "2.SACK";
            // 将设备的状态属性入库

            // 首先从在线设备中提取出设备id
            for (SessionInfo info:sessions){
                String str_status = "";
                if (info.getAddress().equals(clientAddress)){
                    // 通过遍历找到设备号,确保在线才能传输
                    DeviceState deviceState = new DeviceState(info.getDeviceId(), clientAddress, state_status, new Date());
                    try {
//                        str_status = mDeviceStateMapper.selectDeviceStateStatus(deviceState);
                    }catch (Exception e){
                        LOGGER.error("查询电机状态出错",e);
                    }
                    if (!state_status.equals(str_status)){
//                        mDeviceStateMapper.insert(deviceState);
                    }
                    break;
                }

            }
            // 获得初次连接的状态
        }else if ( str.contains("CURRENT")){
            resultStr = "2.CACK";
            // 获得状态的连接
            current_status = str.trim().split(":")[1];
            // 将设备的状态属性入库
            // 首先从在线设备中提取出设备id
            for (SessionInfo info:sessions){
                String str_status = "";
                if (info.getAddress().equals(clientAddress)){
                    // 通过遍历找到设备号,确保在线才能传输
                    DeviceCurrent currentState = new DeviceCurrent(info.getDeviceId(), clientAddress, current_status, new Date());
                    try {
//                        str_status = mDeviceCurrentMapper.selectDeviceCurrentStatus(currentState);
                    }catch (Exception e){
                        LOGGER.error("查询设备电流出错",e);
                    }
                    if (!current_status.equals(str_status)){
//                       mDeviceCurrentMapper.insert(currentState);
                    }
                    break;
                }
            }

        }else if(str.contains("CONTROL") ||str.contains("READ")){
            // 说明这里是app 控制哦
            // 进行模拟,控制完了就Ok了
            String msg_to_hardware = str.trim().split(";")[0];
            String msg_info = str.trim().split(";")[1];
            deviceId = msg_info;
            System.out.println(deviceId);
            boolean controlDeviceOnline = false;
            for (SessionInfo value:sessions){
                if (deviceId.equals(value.getDeviceId())){
                    // 说明存在
                    try {
                        value.getSession().write(msg_to_hardware);
                    }catch (Exception e){
                        bufferedWriter.write("============输入异常==========\n");
                    }
                    if (!isAppSessionHas(deviceId)) {
                        sessions2.add(new SessionInfo(session,value.getDeviceId(),value.getAddress()));
                    }
                    bufferedWriter.write("====向增氧机"+value.getDeviceId()+"==="+"信息:{"+msg_to_hardware+"}\n");
                    bufferedWriter.flush();
                    controlDeviceOnline = true;
                    break;
                }
            }
            if (!controlDeviceOnline){
                session.write("error:设备:"+deviceId+"不在线");
                bufferedWriter.write("+++++++++++++对不起操作的设备:"+deviceId+"不在线+++++++++++++++"+"\n");
                bufferedWriter.flush();
                return;
            }
        }else if(str.contains("TIMER")){
            String msg_to_hardware = str.trim().split(";")[0];
            String msg_info = str.trim().split(";")[1];
/*            deviceId =Integer.parseInt( msg_info.split(",")[1]);
            int customerId = Integer.parseInt(msg_info.split(",")[0]);*/
            deviceId = msg_info;
            boolean controlDeviceOnline = false;
            for (SessionInfo value:sessions){
                if (deviceId.equals(value.getDeviceId())){
                    // 判断控制的设备已经存在
                    value.getSession().write(msg_to_hardware);
                    bufferedWriter.write("====向增氧机"+value.getDeviceId()+"==="+"信息:{"+msg_to_hardware+"}\n");
                    bufferedWriter.flush();
                    if (!isAppSessionHas(deviceId)){
                        sessions2.add(new SessionInfo(session,value.getDeviceId(),value.getAddress()));
                    }
                    controlDeviceOnline = true;
                    break;
                }
            }
            if (!controlDeviceOnline){
                session.write("对不起你控制的设备"+deviceId+"不在线");
                return;
            }
            // 将用户设置的时间放入
            String time_first = null;
            String time_second = null;
            String time_third = null;
            String time_forth = null;
            String time_fifth = null;
            String timer_with_num = msg_to_hardware.split("TIMER")[1].trim();
            int num = Integer.parseInt(timer_with_num.substring(timer_with_num.length()-1));
            String time = timer_with_num.substring(0,timer_with_num.length()-2);
            switch (num){
                case 1:
                    time_first = time;
                    break;
                case 2:
                    time_second = time;
                    break;
                case 3:
                    time_third = time;
                    break;
                case 4:
                    time_forth = time;
                     break;
                case 5:
                    time_fifth = time;
                    break;
            }
            AutoStart autoStart = new AutoStart(deviceId,time_first,time_second,time_third,time_forth,time_fifth);
            AutoStart isHas = null ;
//            isHas =  mAutoStartMapper.selectByDeviceNumber(deviceId);
            if (isHas == null){
                // 说明是不存在 那么插入
//                mAutoStartMapper.insert(autoStart);
            }else {
//                mAutoStartMapper.updateAutoStart(autoStart);
            }

        } else if (str.contains("CACK") || str.contains("TACK") || str.contains("RACK")){
            for (SessionInfo value:sessions2){
                if (clientAddress.equals(value.getAddress())){
                    value.getSession().write(str);
                    break;
                }
            }
        }else if (str.contains("GET_DEVICE_STATUS_WITH_ELE")|| str.contains("GET_DEVICE_NOW_WITH_ELE")){
            // 这时候搜寻,怎么搜寻呢，就是搜寻当前已登录，且超过1000*61 61秒可以吧
            deviceId = str.split(";")[1].trim();
            DeviceStateWithEle deviceStateWithEle = new DeviceStateWithEle();
            DeviceCurrentWithEle deviceCurrentWithEle = new DeviceCurrentWithEle();
            deviceStateWithEle.setState("");
            deviceCurrentWithEle.setCurrent("");
            for (SessionInfo value:sessions){
                if (deviceId.equals(value.getDeviceId() )) {
                    if (System.currentTimeMillis() - value.getLong_time() >= 1000*31){
                        // 在这里查询状态 并返回
                        // 查询最后一条的状态
                        deviceStateWithEle.setCode(200);
                        deviceCurrentWithEle.setCode(200);
                        if (str.contains("STATUS")) {
                            DeviceState deviceState = new DeviceState();
                            deviceState.setDeviceNumber(value.getDeviceId());
                            deviceState.setIp(value.getAddress());
                            String str_status = "";
                            try {
//                                str_status = mDeviceStateMapper.selectDeviceStateStatus(deviceState);
                            }catch (Exception e){
                                LOGGER.error("查询电机状态出错",e);
                            }
                            deviceStateWithEle.setState(str_status);
                        }else {
                            DeviceCurrent currentState = new DeviceCurrent();
                            currentState.setDeviceNumber(value.getDeviceId());
                            currentState.setIp(value.getAddress());
                            String str_current = "";
                            try {
//                                str_current = mDeviceCurrentMapper.selectDeviceCurrentStatus(currentState);
                            } catch (Exception e) {
                                LOGGER.error("查询设备电流出错", e);
                            }
                            deviceCurrentWithEle.setCurrent(str_current);
                        }
                    }
                    break;
                }
            }
            if (str.contains("STATUS")){
                session.write(JacksonUtils.toJson(deviceStateWithEle));
            }else {
                session.write(JacksonUtils.toJson(deviceCurrentWithEle));
            }
        } else if(str.contains("GET_USER_DEVICE_OK")){
            /* 格式 GET_USER_CONTROL_OK;userId*/
            int userId = Integer.parseInt(str.split(";")[1].trim());
            UserDeviceState userDeviceState = new UserDeviceState();
            userDeviceState.setUserId(userId);
            ArrayList<DeviceIsOnline> deviceIsOnlines = new ArrayList<DeviceIsOnline>();
            List<String> deviceList = new ArrayList<>();
//            deviceList = mUserBindingDeviceMapper.selectByUserId(userId);
            for (String mDesId:deviceList){
                System.out.println(mDesId);
                boolean isOnline = false;
                System.out.println(sessions);
                for (SessionInfo sessionInfo:sessions){
                    if (mDesId.equals(sessionInfo.getDeviceId())){
                        isOnline = true;
                        break;
                    }
                }
                deviceIsOnlines.add(new DeviceIsOnline(mDesId,isOnline));
            }
            userDeviceState.setmDeviceStateLists(deviceIsOnlines);
            session.write(JacksonUtils.toJson(userDeviceState));
        }else {
            resultStr = "error:指令："+str+":错误";
        }
        if (!"".equals(resultStr))
            session.write(resultStr);
        // log.txt
        bufferedWriter.close();
        outputStreamWriter.close();
        fileOutputStream.close();
    }

    // 关闭与客户端的连接会调动
    @Override
    public void sessionClosed(IoSession session) throws Exception {
        super.sessionClosed(session);
        System.out.println("MinaServerHandler---sessionClosed");
        // 移除硬件设备在线
        for (SessionInfo value:sessions){
            if (value.getSession().equals(session)){
                String deviceId = value.getDeviceId();
                for (SessionInfo value2:sessions2){
                    if (value2.getDeviceId().equals(deviceId)){
                        value2.getSession().write("OFFLINE;"+deviceId);
                        break;
                    }
                }
                sessions.remove(value);
                // 然后这里要把时间存入了
                DeviceOnline deviceOff = new DeviceOnline(value.getId(), value.getDeviceId(), new Date());
//                mDeviceOnlineMapper.updateDeviceOffline(deviceOff);
                break;
            }
        }
        // 移除APP设备在线
        for (SessionInfo value:sessions2){
            if (value.getSession().equals(session)){
                /* 怎么是*/
                sessions2.remove(value);
                break;
            }
        }
    }

    @Override
    public void messageSent(IoSession session, Object message) throws Exception {
        System.out.println("发送成功啦");
        File file = new File("log.txt");
        // 这里只是用于打印log信息,用于服务器观察
        if (!file.exists()) {
            file.createNewFile();
        }
        FileOutputStream fileOutputStream = new FileOutputStream(file,true);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
        bufferedWriter.write("\n"+"**********服务端发送消息成功啦**********"+"session:"+session+"\n消息:{"+message.toString()+"}    " +
                "时间:"+dateFormat.format(new Date())+"\n"+"**********服务端发送消息成功啦**********\n");
        bufferedWriter.flush();
        bufferedWriter.close();
        outputStreamWriter.close();
        fileOutputStream.close();
        super.messageSent(session, message);

    }

    @Override
    public void inputClosed(IoSession session) throws Exception {
        super.inputClosed(session);
    }

    // 如果map 中存在设备号，那么就返回存在，那么就不会接着添加了
    private boolean isAppSessionHas(String deviceID){
        boolean result = false;
        for (SessionInfo value:sessions2){
            if (deviceID.equals(value.getDeviceId())){
                result = true;
                break;
            }
        }
        return result;
    }
}
