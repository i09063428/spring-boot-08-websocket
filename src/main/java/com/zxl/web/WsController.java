package com.zxl.web;

import com.zxl.domain.WiselyMessage;
import com.zxl.domain.WiselyResponse;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

/**
 * @author zxl16
 * @Date 2019/9/27.
 */
@Controller
public class WsController {

    @MessageMapping("/welcome")
    @SendTo("/topicsocket/getResponse")
    public WiselyResponse say(WiselyMessage message) throws InterruptedException {
        Thread.sleep(3000);
        return  new WiselyResponse("welcome , " + message.getName() + "!");
    }
}
