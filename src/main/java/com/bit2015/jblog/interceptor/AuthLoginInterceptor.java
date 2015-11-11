package com.bit2015.jblog.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.bit2015.jblog.service.UserService;
import com.bit2015.jblog.vo.BlogUserVo;

public class AuthLoginInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		BlogUserVo vo = new BlogUserVo();
		vo.setUserId(userId);
		vo.setPassword(password);
		ApplicationContext applicationContext = WebApplicationContextUtils
				.getWebApplicationContext(request.getServletContext());
		UserService userService = applicationContext.getBean(UserService.class);
		BlogUserVo authUser = userService.login(vo);
		if (authUser == null) {
			response.sendRedirect("/jblog/user/loginform?result=error");
			return false;
		}
		HttpSession session = request.getSession(true);
		session.setAttribute("authUser", authUser);
		response.sendRedirect("/jblog/main/");
		return false;
	}

}
