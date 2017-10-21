package org.lk.springboot.demo.web.controller.v1;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.lk.springboot.demo.domain.model.user.UserInfo;
import org.lk.springboot.demo.exception.ApiException;
import org.lk.springboot.demo.service.user.UserInfoService;
import org.lk.springboot.demo.util.PasswordHelper;
import org.lk.springboot.demo.web.interceptor.Permission;
import org.lk.springboot.demo.web.util.ResponseMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/v1/user")
public class UserController {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private UserInfoService userInfoService;

	@Autowired
	private PasswordHelper passwordHelper;

	@RequestMapping(value = "/list")
	//@PreAuthorize("hasRole('USER')")
	@Permission("user:list")
	ResponseMessage list(@RequestBody(required = false) JSONObject userInfo) {
		int pageSize = 2;
		int pageNum = 1;
		logger.debug("");
		return ResponseMessage.success().put("pageInfo",userInfoService.findByPage(userInfo, pageNum, pageSize)).build();
	}

	@RequestMapping("/list/ui")
	public String list(Model model){
		PageInfo<UserInfo> pageInfo = userInfoService.findByPage(null, 1, 20);
		model.addAttribute("pageInfo", pageInfo);
		return "user/list";
	}

	@RequestMapping(value = "/getOne/{id}", method = RequestMethod.GET)
	@ResponseBody
	@Permission("user:one")
	UserInfo getUser(@PathVariable("id")Long id){
		return userInfoService.findById(id);
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(){
		return "user/add";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	ResponseMessage update(@RequestBody @Valid UserInfo userInfo){
		userInfoService.updateObj(userInfo);
		return ResponseMessage.success().build();
	}


	@GetMapping("/delete/{id}")
	@ResponseBody
	ResponseMessage delete(@PathVariable("id")Long id){
		userInfoService.delObj(id);
		return ResponseMessage.success().build();
	}
	
	@PostMapping("/login")
	@ResponseBody
	ResponseMessage login(@RequestBody @Valid UserInfo userInfo,HttpServletRequest request) throws ApiException{
		UserInfo userInfo2 = userInfoService.findByUserName(userInfo.getUsername());
		passwordHelper.validateUserPassword(userInfo.getUpassword(), userInfo2);
		HttpSession session = request.getSession();
		session.setAttribute("token", userInfo2);
		return ResponseMessage.success().build();
	}
}
