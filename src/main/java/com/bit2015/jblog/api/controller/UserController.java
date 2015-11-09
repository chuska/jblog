package com.bit2015.jblog.api.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bit2015.jblog.service.UserService;
import com.bit2015.jblog.vo.BlogUserVo;

@Controller("userAPIController")
@RequestMapping("/api/user")
public class UserController {
	@Autowired
	UserService userService;

	@ResponseBody
	@RequestMapping("/checkid")
	public Map<String, Object> checkId(
			@RequestParam(value = "id", required = true, defaultValue = "") String id) {
		BlogUserVo vo = userService.getUser(id);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", "success");
		map.put("data", vo == null);
		return map;
	}
}
