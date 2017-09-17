package org.lk.springboot.demo.web.controller.wweixin;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.lk.springboot.demo.exception.ApiException;
import org.lk.springboot.demo.exception.ErrorCodeEnum;
import org.lk.springboot.demo.service.weixin.WeiXinConfig;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("weixin")
public class WeiXinController {

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        return "OK";
    }

    @RequestMapping("listen")
    public void listen(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String echostr = getEchostr(request);
        response.getOutputStream().write(echostr.getBytes());
    }

    private String getEchostr(HttpServletRequest request) throws ApiException {
        String signature = request.getParameter("signature");
        String timestamp = request.getParameter("timestamp");
        String nonce = request.getParameter("nonce");
        String echostr = request.getParameter("echostr");
        if (StringUtils.isEmpty(echostr)){
            return null;
        }
        List<String> list = new ArrayList<>();
        list.add(WeiXinConfig.TOKEN);
        list.add(timestamp);
        list.add(nonce);
        Collections.sort(list);
        String sv = StringUtils.join(list, "");
        String s = DigestUtils.sha1Hex(sv);
        if (s.equals(signature)) {
            return echostr;
        }
        throw new ApiException(ErrorCodeEnum.ERROR_WEIXIN_ECHOSTR);
    }
}
