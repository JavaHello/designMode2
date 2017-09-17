package org.lk.springboot.demo.web.interceptor;

import java.lang.annotation.Annotation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.javafx.tk.PermissionHelper;
import org.lk.springboot.demo.domain.model.user.Permissions;
import org.lk.springboot.demo.domain.model.user.UserInfo;
import org.lk.springboot.demo.exception.ApiException;
import org.lk.springboot.demo.exception.ErrorCodeEnum;
import org.lk.springboot.demo.web.security.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class PermissionHandlerInterceptor implements HandlerInterceptor {

	@Autowired
	private PermissionHelper permissionHelper;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if(handler instanceof HandlerMethod){
			Permission methodAnnotation = ((HandlerMethod) handler).getMethodAnnotation(Permission.class);
			if(methodAnnotation != null){
				boolean flag = true;
				MyUserDetails principal = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
				for (Permissions permission : principal.getPermissions()) {
					if (permission.getPmCode().equals(methodAnnotation.value())){
						flag = false;break;
					}
				}
				if (flag)
					throw new ApiException(ErrorCodeEnum.NOT_PERMISSION);
			}
			return true;
		}else{
			return false;
		}
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}

}
