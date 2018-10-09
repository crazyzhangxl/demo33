package com.jit.demo;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * description: 用于模拟客户端来进行测试的
 * Created by 张先磊 on 2018/3/22.
 *
 */
public class CTClientHandler extends IoHandlerAdapter {
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public void messageReceived(IoSession session, Object message) throws Exception {
        System.out.println(message.toString()+"  时间: "+dateFormat.format(new Date()));
        String str = message.toString();
        if (str.contains("3.CONTROL")){
            session.write("CACK");
        }else if (str.contains("4.TIMER")){
            session.write("TACK");
        }
    }

    @Override
    public void messageSent(IoSession session, Object message) throws Exception {
    }

    @Override
    public void sessionClosed(IoSession session) throws Exception {
        System.out.println("  时间: "+dateFormat.format(new Date()));

        super.sessionClosed(session);
    }
}
