package com.bit2015.jblog.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserContorller {
	
	@RequestMapping("/list")
	public String userList() {
				
		return "/user/list";
	}
	
	@RequestMapping("/loginform")
	public String userLoginForm() {
				
		return "/user/login-form";
	}
	
	@RequestMapping("/registerform")
	public String userRegisterForm() {
				
		return "/user/login-form";
	}
}
