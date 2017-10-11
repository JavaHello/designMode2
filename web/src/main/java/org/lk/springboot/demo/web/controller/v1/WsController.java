package org.lk.springboot.demo.web.controller.v1;

import org.lk.springboot.demo.web.util.ResponseMessage;
import org.lk.springboot.demo.web.websocket.SocketReqMsg;
import org.lk.springboot.demo.web.websocket.SocketRespMsg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageExceptionHandler;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WsController {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/welcome")
    @SendToUser("/topic/subscribe")
    public SocketRespMsg say(SocketReqMsg message) {
        System.out.println(message.getName());
        return new SocketRespMsg("welcome," + message.getName() + " !");
    }

    @RequestMapping("sendMessage/{userName}")
    @ResponseBody
    public SocketRespMsg sendMessage(@PathVariable("userName") String userName){
        SocketRespMsg socketRespMsg = new SocketRespMsg("welcome," + "websocket" + " !");
        messagingTemplate.convertAndSend("/topic/"+userName
                +"/subscribe", socketRespMsg);
        return socketRespMsg;
    }

    @RequestMapping("chat")
    public String socket(Model model){
        Object myUserDetails = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user", myUserDetails);
        return "websocket/chat";
    }

    @MessageExceptionHandler
    @SendToUser(destinations = "", broadcast = false)
    public ResponseMessage handleExceptino(Exception ex){
        logger.error(ex.getMessage(), ex);
        return ResponseMessage.failure().build();
    }
}