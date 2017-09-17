package org.lk.springboot.demo.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping("/login")
    public String login(){
        return "login";
    }
    @RequestMapping("/success")
    public String loginSuccess(){
        return "redirect:/v1/user/list/ui";
    }
    @RequestMapping("/index")
    public String index(){
        return "index";
    }
}
