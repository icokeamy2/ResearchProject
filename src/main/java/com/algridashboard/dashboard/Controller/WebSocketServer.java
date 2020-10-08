package com.algridashboard.dashboard.Controller;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import com.algridashboard.dashboard.model.AllChart;
import com.algridashboard.dashboard.model.Datasets;
import com.algridashboard.dashboard.util.JsonResult;
import com.alibaba.fastjson.JSON;

import com.algridashboard.dashboard.model.Humidity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * WebSocket服务端
 * @author ygc
 */
@ServerEndpoint(value = "/websocket")
@Component
public class WebSocketServer {

    private final static Logger log = LoggerFactory.getLogger(WebSocketServer.class);
    private static final AtomicInteger OnlineCount = new AtomicInteger(0);
    // concurrent包的线程安全Set，用来存放每个客户端对应的Session对象。
    private static CopyOnWriteArraySet<Session> SessionSet = new CopyOnWriteArraySet<Session>();


    /**
     * 连接建立成功调用的方法
     * @throws IOException
     */
    @OnOpen
    public void onOpen(Session session) throws IOException {
        SessionSet.add(session);
        //Humidity hu=new Humidity();
       // hu.setHumidity("0");
       // hu.setTime(new Date(2017-02-17));

        int personCount = OnlineCount.incrementAndGet(); // 在线数加1
        System.out.println("有连接加入，当前连接数为："+personCount);
        log.info("有连接加入，当前连接数为：{}", personCount);
//		SendMessage(session, "连接成功,当前连接人数为:"+personCount);
//		SendMessage(session,String.valueOf(personCount));
        BroadCastInfo(String.valueOf(OnlineCount.get()));

       // BroadCastInfo(JSON.toJSONString(hu));
    }

    /**
     * 连接关闭调用的方法
     * @throws IOException
     */
    @OnClose
    public void onClose(Session session) throws IOException {
        int personCount = OnlineCount.decrementAndGet();
        System.out.println("有连接关闭，当前连接数为："+personCount);
        log.info("有连接关闭，当前连接数为：{}", personCount);
        SessionSet.remove(session);
    }

    /**
     * 收到客户端消息后调用的方法
     *
     * @param message
     *            客户端发送过来的消息
     * @throws IOException
     */
    @OnMessage
    public void onMessage(String message, Session session) throws IOException {
        log.info("来自客户端的消息：{}",message);

//		System.out.println("来自客户端的消息:"+message);
//		SendMessage(session, "收到消息，消息内容："+message);
        if(message.equals("管理平台")) {
            System.out.println("收到平台类型:"+message);
            BroadCastInfo(String.valueOf(OnlineCount.get()-1));
        }
		if(message.equals("新增人数")) {
			System.out.println("打开页面:"+message);
			BroadCastInfo(String.valueOf(OnlineCount.get()+1));
            BroadCastInfo(String.valueOf(OnlineCount.get()+2));
		}
        if(message.equals("关闭页面")) {
            System.out.println("收到关闭页面:"+message);
            //在线数加-1
            BroadCastInfo(String.valueOf(OnlineCount.get()-1));

        }
    }

    /**
     * 出现错误
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error) {
        log.error("发生错误：{}，Session ID： {}",error.getMessage(),session.getId());
        System.out.println("发生错误：{}，Session ID： "+error.getMessage()+session.getId());
        error.printStackTrace();
    }

    /**
     * 发送消息，实践表明，每次浏览器刷新，session会发生变化。
     * @param session
     * @param message
     */
    public static void SendMessage(Session session, String message) {
        try {
            session.getBasicRemote().sendText(message);
//			session.getBasicRemote().sendText(String.format("%s (From Server，Session ID=%s)",message,session.getId()));
        } catch (IOException e) {
            log.error("发送消息出错：{}", e.getMessage());
            System.out.println("发送消息出错：{}"+e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * 群发消息
     * @param message
     * @throws IOException
     */
    public static void BroadCastInfo(String message) throws IOException {
        for (Session session : SessionSet) {
            if(session.isOpen()){
                SendMessage(session, message);
            }
        }
    }

    /**
     * 指定Session发送消息
     * @param sessionId
     * @param message
     * @throws IOException
     */
    public static void SendMessage(String sessionId,String message) throws IOException {
        Session session = null;
        for (Session s : SessionSet) {
            if(s.getId().equals(sessionId)){
                session = s;
                break;
            }
        }
        if(session!=null){
            SendMessage(session, message);
        }
        else{
            log.warn("没有找到你指定ID的会话：{}",sessionId);
            System.out.println("没有找到你指定ID的会话:"+sessionId);
        }
    }

}
