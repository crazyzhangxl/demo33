package com.jit.demo;

import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.transport.socket.nio.NioSocketConnector;

import java.net.InetSocketAddress;
import java.nio.charset.Charset;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * Created by 张先磊 on 2018/3/22.
 */
public class CTClient {
    public static void main(String[] args){
        // 第一步，建立一个connecter
        NioSocketConnector connecter = new NioSocketConnector();
        // 第二步，设置消息处理的Handler
        connecter.setHandler(new CTClientHandler());
        // 第三步骤，设置过滤器
        connecter.getFilterChain().addLast("minaClinet", new ProtocolCodecFilter(new TextLineCodecFactory(Charset.forName("utf-8"))));
        // 第四步骤，连接服务器
        //ConnectFuture future = connecter.connect(new InetSocketAddress("223.2.197.240",8431));
        ConnectFuture future = connecter.connect(new InetSocketAddress("127.0.0.1",8431));
        // 阻塞等待连接创建
        future.awaitUninterruptibly();

        String[] sendMsg = {"1.ZHONGYU:88888","2222.STATE:00000,1,1","2222.CURRENT，......,015"
        ,"3.CONTROL:11111,1,1500001","4.TIMER 08:30-10:30,11:00-11:30,15:00-16:00,17:00-19:00,5,1500001"};
/*        for (int i=0;i<2;i++) {
            try {
                Thread.sleep(5000);
                sendMsg(future.getSession(), sendMsg[i]);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }*/
/*        sendMsg(future.getSession(),sendMsg[0]);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
         //sendMsg(future.getSession(),sendMsg[1]);
        //sendMsg(future.getSession(),sendMsg[3]);
/*        sendMsg(future.getSession(),"888888:9999999");
        try {
            Thread.sleep(1000*120);
            sendMsg(future.getSession(),"888888:9999999");
            Thread.sleep(1000*120);
            sendMsg(future.getSession(),"888888:9999999");
            Thread.sleep(1000*120);
            sendMsg(future.getSession(),"888888:9999999");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        try {
            sendMsg(future.getSession(),"1.ZHONGYU:9999999999");
            Thread.sleep(1000);
            //sendMsg(future.getSession(),"GET_USER_DEVICE_OK;32");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void sendMsg(IoSession session , String msg){
        if(session != null){
            session.write(msg);
        }
    }
}
