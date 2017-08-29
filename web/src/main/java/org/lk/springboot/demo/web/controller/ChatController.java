package org.lk.springboot.demo.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/v1/chat")
public class ChatController {

    @RequestMapping("/{userId}")
    public String chat(String userId){
        return "websocket/chat";
    }
}
