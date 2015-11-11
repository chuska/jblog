package com.bit2015.jblog.api.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bit2015.jblog.service.BlogService;
import com.bit2015.jblog.vo.CategoryVo;

@Controller("blogAPIContoller")
@RequestMapping("/api/blog")
public class BlogController {
	
	@Autowired
	BlogService blogService;
	
	@ResponseBody
	@RequestMapping("/category")
	public Map<String, Object> categoryList(@RequestParam(value="bl_no",required=true,defaultValue="3") long blogNo,Model model)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		
		List<CategoryVo> categoryList = blogService.blogCategoryList(blogNo);
		map.put("result", "ok");
		map.put("data",categoryList);
		
		return map; 
	}
	
	@ResponseBody
	@RequestMapping("/insert")
	public Map<String, Object> categoryInsert(@ModelAttribute CategoryVo categoryVo)
	{
		
		Map<String, Object> map = new HashMap<String, Object>();
		CategoryVo category = blogService.blogCategoryInsert(categoryVo);
	
		map.put("result", "ok");
		map.put("data",category);
		
		return map; 
	}
	
	@ResponseBody
	@RequestMapping("/delete")
	public Map<String, Object> categoryDelete(@RequestParam("cate_no") long categoryNo)
	{
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		boolean result = blogService.blogCategoryDelete(categoryNo); 
	
		map.put("result", "ok");
		map.put("data",result);
		
		return map; 
	}
	
	
}
