package org.lk.springboot.demo;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.nio.charset.Charset;

@Controller
@SpringBootApplication
@EnableRedisHttpSession
public class Application {
	@RequestMapping(value="/getSessionId")
	@ResponseBody
	public String getSessionId(HttpServletRequest request){

		Object o = request.getSession().getAttribute("springboot");
		if(o == null){
			o = "spring boot 牛逼了!!!有端口"+request.getLocalPort()+"生成";
			request.getSession().setAttribute("springboot", o);
		}

		return "端口=" + request.getLocalPort() +  " sessionId=" + request.getSession().getId() +"<br/>"+o;
	}
	@RequestMapping("/")
	String home(Model model) {
		model.addAttribute("welcome", "hello world");
		return "index";
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}
	/**
	 * 使用FastJson解析返回数据
	 */
	@Bean
	public HttpMessageConverters fastJsonHttpMessageConverters() {
		FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
		fastConverter.setDefaultCharset(Charset.forName("UTF-8"));
		FastJsonConfig fastJsonConfig = new FastJsonConfig();
		fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
		fastConverter.setFastJsonConfig(fastJsonConfig);
		return new HttpMessageConverters((HttpMessageConverter<?>) fastConverter);
	}
}