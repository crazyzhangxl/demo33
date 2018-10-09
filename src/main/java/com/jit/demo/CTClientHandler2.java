package com.jit.demo;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;

/**
 * description: 用于模拟客户端来进行测试的
 * Created by 张先磊 on 2018/3/22.
 *
 */
public class CTClientHandler2 extends IoHandlerAdapter {
    @Override
    public void messageReceived(IoSession session, Object message) throws Exception {
        System.out.println(message.toString());


    }

    @Override
    public void messageSent(IoSession session, Object message) throws Exception {
    }

}
