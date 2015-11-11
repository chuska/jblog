package com.bit2015.jblog.contoller;
//
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bit2015.jblog.service.MainService;

@Controller
@RequestMapping("/main")
public class MainContorller {
	
	@Autowired
	MainService mainService;
	
	@RequestMapping("/")
	public String main() {
				
		return "/main/index";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session){
		
		session.removeAttribute("authUser");
		session.invalidate();
		
		return "redirect:/main/";
	}
	
	@RequestMapping("/search")
	public String search(@RequestParam("searchKeyword")String searchKeyword,
			@RequestParam("radioValue") String searchValue,
			@RequestParam(value="p",required=true, defaultValue="1") Long page, Model model){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("radioValue", searchValue);
		map.put("searchKeyword", searchKeyword);
		map = mainService.listBoard(searchKeyword, searchValue, page);
		model.addAttribute("map", map);
		return "/main/index";
		
	}
	
	
	
	
	
}
