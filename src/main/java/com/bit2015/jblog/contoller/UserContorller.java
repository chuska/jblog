package com.bit2015.jblog.contoller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bit2015.jblog.annotation.Auth;
import com.bit2015.jblog.service.UserService;
import com.bit2015.jblog.vo.BlogUserVo;

@Controller
@RequestMapping("/user")
public class UserContorller {
	@Autowired
	UserService userService;

	@Auth
	@RequestMapping("/list")
	public String userList(Model model) {
		List<BlogUserVo> list = userService.getList();
		model.addAttribute("list", list);
		return "/user/list";
	}

	@RequestMapping("/loginform")
	public String userLoginForm() {
		return "/user/login-form";
	}

	@Auth
	@RequestMapping("/registerform")
	public String userRegisterForm() {
		return "/user/register-form";
	}

	@Auth
	@RequestMapping("/register")
	public String userRegister(@ModelAttribute BlogUserVo vo) {
		userService.insert(vo);
		return "redirect:/user/list";
	}
}
