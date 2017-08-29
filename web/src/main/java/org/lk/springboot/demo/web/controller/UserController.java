package org.lk.springboot.demo.web.controller;

import com.alibaba.fastjson.JSONObject;
import org.lk.springboot.demo.domain.model.user.UserInfo;
import org.lk.springboot.demo.service.user.UserInfoService;
import org.lk.springboot.demo.util.PasswordHelper;
import org.lk.springboot.demo.web.util.ResponseMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/v1/user")
public class UserController {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private UserInfoService userInfoService;

	@Autowired
	private PasswordHelper passwordHelper;

	@RequestMapping(value = "/list",method = RequestMethod.POST)
	@ResponseBody
	ResponseMessage list(@RequestBody(required = false) JSONObject userInfo) {
		int pageSize = 2;
		int pageNum = 1;
		return ResponseMessage.success().setContent(userInfoService.findByPage(userInfo, pageNum, pageSize)).build();
	}

	@RequestMapping(value = "/getOne/{id}", method = RequestMethod.GET)
	@ResponseBody
	UserInfo getUser(@PathVariable("id")Long id){
		return userInfoService.findById(id);
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	ResponseMessage add(@RequestBody @Valid UserInfo userInfo){
		userInfo.setCreateUserId(1L);
		passwordHelper.encryptUserPassword(userInfo);
		userInfoService.addObj(userInfo);
		return ResponseMessage.success().build();
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	ResponseMessage update(@RequestBody @Valid UserInfo userInfo){
		userInfoService.updateObj(userInfo);
		return ResponseMessage.success().build();
	}


	@RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
	@ResponseBody
	ResponseMessage delete(@PathVariable("id")Long id){
		userInfoService.delObj(id);
		return ResponseMessage.success().build();
	}
}
