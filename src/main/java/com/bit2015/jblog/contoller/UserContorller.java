package com.bit2015.jblog.contoller;

import java.util.List;

import javax.servlet.http.HttpSession;

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
	public String userLogin(@ModelAttribute BlogUserVo vo, HttpSession session) {
		BlogUserVo blogUserVo = userService.login(vo);
		if (blogUserVo == null) {
			return "redirect:/user/loginform?result=error";
		}
		session.setAttribute("authUser", blogUserVo);
		return "redirect:/user/list";
	}

	@RequestMapping("/logout")
	public String userLogout(HttpSession session) {
		session.removeAttribute("authUser");
		session.invalidate();
		return "redirect:/user/list";
	}
}
