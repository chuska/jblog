package com.bit2015.jblog.contoller;
//
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main")
public class MainContorller {
	
	@RequestMapping("/")
	public String main() {
				
		return "/main/index";
	}
	
	
	
}
