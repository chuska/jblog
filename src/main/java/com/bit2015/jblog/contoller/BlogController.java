package com.bit2015.jblog.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/blog")
public class BlogController {
	@RequestMapping("/main")
	public String blogMain() {
				
		return "/blog/main";
	}
	
	@RequestMapping("/main-detail")
	public String blogMainDetail() {
				
		return "/blog/main-detail";
	}
	
	@RequestMapping("/basic")
	public String blogBasic() {
				
		return "/blog/basic";
	}
	
	@RequestMapping("/category")
	public String blogCategory() {
				
		return "/blog/category";
	}
	
	@RequestMapping("/write")
	public String blogWrite() {
				
		return "/blog/write";
	}
}
