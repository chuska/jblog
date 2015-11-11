package com.bit2015.jblog.contoller;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bit2015.jblog.service.BlogService;
import com.bit2015.jblog.vo.BlogVo;
import com.bit2015.jblog.vo.CategoryVo;
import com.bit2015.jblog.vo.CommentsVo;
import com.bit2015.jblog.vo.PostVo;

@Controller
@RequestMapping("/blog")
public class BlogController {
	
	@Autowired 
	BlogService blogService;
	
	@RequestMapping("/main")
	public String blogMain(@RequestParam(value="blogNo",required=true,defaultValue="3") long bl_no,
						   Model model){
		
		List<CategoryVo> cateList = blogService.blogCategoryList(bl_no);
		List<Map<String, Object>> mainList = blogService.blogMainList(bl_no);
		List<Map<String, Object>> countList = blogService.blogCountList(bl_no);
		
		Map<String, Object> blogInfoMap = mainList.get(1);
		
		System.out.println( mainList);
		System.out.println( countList);
		model.addAttribute("blogNo", bl_no);
		model.addAttribute("title", blogInfoMap.get("BLOG_TITLE"));
		model.addAttribute("tag", blogInfoMap.get("TAG"));
		model.addAttribute("cateList", cateList);
		model.addAttribute("mainList", mainList);
		model.addAttribute("countList", countList);
		
		return "/blog/main";
	}
	
	@RequestMapping("/maindetail")
	public String blogMainDetail(@RequestParam("blogNo") long blogNo,
								 @RequestParam("postNo") long postNo,
								 Model model) {
		List<CategoryVo> categoryList = blogService.blogCategoryList(blogNo);
		BlogVo blogVo = blogService.blogBlogInfo(blogNo);
		Map<String,Object> map = blogService.blogPostInfo(postNo);
		List<CommentsVo> commentsList = blogService.blogCommentsList(postNo);
		
		System.out.println(categoryList);
		System.out.println(map);
		System.out.println(commentsList);
		
		model.addAttribute("title",blogVo.getTitle());
		model.addAttribute("tag",blogVo.getTag());	
		model.addAttribute("categoryList",categoryList);
		model.addAttribute("commentsList",commentsList);
		model.addAttribute("map",map);
		return "/blog/main-detail";
	}
	
	@RequestMapping("/basic")
	public String blogBasic(@ModelAttribute BlogVo blogVo,
							Model model) {
				
		BlogVo bVo = blogService.blogBlogInfo(blogVo.getBlogNo());
		System.out.println("blogVo + " +bVo);
		model.addAttribute("blogVo", bVo);
		model.addAttribute("title",bVo.getTitle());
		model.addAttribute("tag",bVo.getTag());
		return "/blog/basic";
	}
	
	@RequestMapping("/blog-modify")
	public String blogInfoModify(@ModelAttribute BlogVo blogVo,Model model) {
		
		blogService.blogInfoModify(blogVo);
		model.addAttribute("blogVo",blogVo);
		model.addAttribute("title",blogVo.getTitle());
		model.addAttribute("tag",blogVo.getTag());
		return "/blog/basic";
	}
	
	@RequestMapping("/category")
	public String blogCategory( @RequestParam("blogNo") long blogNo, Model model) {
				
		List<CategoryVo> categoryList = blogService.blogCategoryList(blogNo);
		BlogVo blogVo = blogService.blogBlogInfo(blogNo);
		model.addAttribute("title",blogVo.getTitle());
		model.addAttribute("tag",blogVo.getTag());
		model.addAttribute("categoryList",categoryList);
		return "/blog/category";
	}
	
	@RequestMapping("/writer")
	public String blogWrite(@ModelAttribute BlogVo blogVo, Model model) {
		
		List<CategoryVo> categoryList = blogService.blogCategoryList(blogVo.getBlogNo());
		
		model.addAttribute("title",blogVo.getTitle());
		model.addAttribute("tag",blogVo.getTag());	
		model.addAttribute("blogNo",blogVo.getBlogNo());	
		model.addAttribute("categoryList",categoryList);
		return "/blog/write";
	}
	
	@RequestMapping("/writer-insert")
	public String blogWriteInsert(@ModelAttribute PostVo postVo,
								  @RequestParam("blogNo") long blogNo,
								  Model model) {
		
		List<CategoryVo> categoryList = blogService.blogCategoryList(blogNo);
		BlogVo blogVo = blogService.blogBlogInfo(blogNo);
		System.out.println(categoryList);
		System.out.println(blogVo);
		System.out.println(postVo);
		blogService.blogPostInsert(postVo);
		model.addAttribute("title",blogVo.getTitle());
		model.addAttribute("tag",blogVo.getTag());	
		model.addAttribute("categoryList",categoryList);
		return "/blog/write";
	}
}
