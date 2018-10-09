package com.jit.demo;

import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.keepalive.KeepAliveMessageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by db on 17-1-10.
 */
public  class KeepAliveMessageFactoryImpl implements KeepAliveMessageFactory {
    //心跳包内容  heartbeatRequest
    private static final String HEARTBEATREQUEST = "ping";
    //          heartbeatResponse
    private static final String HEARTBEATRESPONSE = "pong";
    private final static Logger LOGGER = LoggerFactory.getLogger(KeepAliveMessageFactoryImpl.class);

    public boolean isRequest(IoSession session, Object message){
        if (message.equals(HEARTBEATREQUEST)){
            //LOGGER.info("请求心跳包信息: " + message);
            System.out.println(HEARTBEATREQUEST);
            return true;
        }
        return false;
    }

    public boolean isResponse(IoSession session, Object message){
        if (message.equals(HEARTBEATRESPONSE))
        {
            System.out.println(HEARTBEATRESPONSE);
            return  true;
        }
        return false;
    }

    public Object getRequest(IoSession session){
        System.out.println("getRequest ==== 服务端向客户端请求啦");
        System.out.println(new SimpleDateFormat("yyyyMMdd-HH:mm:ss-SSS").format(new Date()));

        return HEARTBEATREQUEST;
    }

    public Object getResponse(IoSession session, Object request){
        System.out.println("get Response ==== 做出回应啦");
        return  HEARTBEATRESPONSE;
    }
}
