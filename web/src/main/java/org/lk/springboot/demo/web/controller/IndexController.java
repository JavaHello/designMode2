package org.lk.springboot.demo.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSONObject;

@Controller
public class IndexController {

	private final RestTemplate restTemplate;
	
	
	@Autowired
    public IndexController(RestTemplate restTemplate) {
		super();
		this.restTemplate = restTemplate;
	}
	@RequestMapping("/")
	@ResponseBody
    public Object test(){
		String url = "http://localhost:8888";
		JSONObject forObject = restTemplate.getForObject(url , JSONObject.class);
        return forObject;
    }
    
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
