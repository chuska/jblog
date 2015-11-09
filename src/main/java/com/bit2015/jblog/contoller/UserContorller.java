package com.bit2015.jblog.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bit2015.jblog.service.UserService;
import com.bit2015.jblog.vo.BlogUserVo;

@Controller
@RequestMapping("/user")
public class UserContorller {
	@Autowired
	UserService userService;

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

	@RequestMapping("/registerform")
	public String userRegisterForm() {

		return "/user/register-form";
	}

	@RequestMapping("/register")
	public String userRegister(@ModelAttribute BlogUserVo vo) {
		userService.insert(vo);
		return "redirect:/user/list";
	}

	@RequestMapping("/login")
	public String userLogin(@ModelAttribute BlogUserVo vo) {
		BlogUserVo blogUserVo = userService.login(vo);
		System.out.println(blogUserVo);
		return "redirect:/user/list";
	}
}
