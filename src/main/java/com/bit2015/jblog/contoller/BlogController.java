package com.bit2015.jblog.contoller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bit2015.jblog.service.BlogService;
import com.bit2015.jblog.vo.CategoryVo;

@Controller
@RequestMapping("/blog")
public class BlogController {
	
	@Autowired 
	BlogService blogService;
	
	@RequestMapping("/main")
	public String blogMain(@RequestParam(value="ct_no",required=true,defaultValue="1") String ct_no,
						   @RequestParam(value="bl_no",required=true,defaultValue="3") long bl_no,
						   Model model){
		
		List<CategoryVo> cateList = blogService.blogCategoryList(bl_no);
		List<Map<String, Object>> mainList = blogService.blogMainList(ct_no);
		List<Map<String, Object>> countList = blogService.blogCountList(ct_no);
		
		System.out.println( mainList);
		System.out.println( countList);
		model.addAttribute("cateList", cateList);
		model.addAttribute("mainList", mainList);
		model.addAttribute("countList", countList);
		
		return "/blog/main";
	}
	
	@RequestMapping("/maindetail")
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
	
	@RequestMapping("/writer")
	public String blogWrite() {
				
		return "/blog/write";
	}
}
