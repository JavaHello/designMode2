package org.lk.springboot.demo.web.controller.wweixin;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import me.chanjar.weixin.mp.bean.result.WxMpUser;

@Controller
@RequestMapping("/wxAuth")
public class WxAuthController {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	private final String redirectURI = "http://yugf85.natappfree.cc/boot/wxAuth/callback";
	@Autowired
	private WxMpService wxMpService;
	
	@RequestMapping("/into")
	public String wxInto() {
		logger.info("进入微信授权引导");
		String url = wxMpService.oauth2buildAuthorizationUrl(redirectURI, WxConsts.OAUTH2_SCOPE_USER_INFO, null);
		logger.info("跳转地址:{}", url);
		return "redirect:" + url;
	}
	
	@RequestMapping("/callback")
	@ResponseBody
	public WxMpUser callback(HttpServletRequest request,@RequestParam(value = "code", required = false) String code, @RequestParam(value = "state", required = false)String state) throws WxErrorException {
		WxMpOAuth2AccessToken wxMpOAuth2AccessToken = wxMpService.oauth2getAccessToken(code);
		WxMpUser wxMpUser = wxMpService.oauth2getUserInfo(wxMpOAuth2AccessToken, null);
		return wxMpUser;
	}

}
