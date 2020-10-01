package com.algridashboard.dashboard.Controller;
import java.io.IOException;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/dash")
public class WebSocketController {
    //	@Autowired
//	private RedisOperator redisOperator;
   // @RequestMapping(value="/sendAll", method=RequestMethod.GET)
    /**
     * 群发消息内容
     * @param message
     * @return
     */
    String sendAllMessage(@RequestParam(required=true) String message){
        try {
            for(int i=0;i<4;i++){
                WebSocketServer.BroadCastInfo(message+i);
                System.out.println(message+i);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
        return "ok";
    }
   // @RequestMapping(value="/analytics", method=RequestMethod.GET)
    /**
     * 指定会话ID发消息
     * @param message 消息内容
     * @param id 连接会话ID
     * @return
     */
    String sendOneMessage(@RequestParam(required=true) String message,@RequestParam(required=true) String id){
        try {
            WebSocketServer.SendMessage(id,message);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "ok";
    }
}
