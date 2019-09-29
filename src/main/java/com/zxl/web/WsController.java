package com.zxl.web;

import com.zxl.domain.WiselyMessage;
import com.zxl.domain.WiselyResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

/**
 * @author zxl16
 * @Date 2019/9/27.
 */
@Controller
public class WsController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/welcome")
    @SendTo("/topicsocket/getResponse")
    public WiselyResponse say(WiselyMessage message) throws InterruptedException {
        Thread.sleep(3000);
        return  new WiselyResponse("welcome , " + message.getName() + "!");
    }

    /**
     *
     * @param principal
     * @param msg
     */
    @MessageMapping("/chat")
    public void handleChat(Principal principal, String msg){
        if(principal.getName().equals("zxl")){
                messagingTemplate.convertAndSendToUser("wyf","/queue/notifications",principal.getName() + "-send:" + msg);
        }else{
                messagingTemplate.convertAndSendToUser("zxl","/queue/notifications",principal.getName() + "-send:" + msg);
        }
    }
}
